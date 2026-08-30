package org.catrobat.catroid.libraries

import org.json.JSONArray
import org.json.JSONObject
import java.io.File

/** Portable JSON representation of a Lua-powered Kix custom block. */
object KixCustomBlockPackage {
    const val FILE_EXTENSION = ".kixblock.json"
    private const val FORMAT = "kix-custom-block"
    private const val VERSION = 1
    private val idPattern = Regex("[A-Za-z][A-Za-z0-9_-]{0,63}")
    private val loaded = mutableSetOf<String>()

    fun isLoaded(ownerId: String) = ownerId in loaded
    fun loadedIds(): Set<String> = loaded.toSet()

    fun load(file: File): CustomBrickDefinition {
        val ownerId = file.name
        val definition = decode(file.readText(), ownerId)
        CustomBrickManager.registerBrick(definition)
        loaded += ownerId
        return definition
    }

    fun unload(ownerId: String) {
        loaded -= ownerId
    }

    fun export(definition: CustomBrickDefinition, target: File) {
        require(definition.luaSource != null) { "Only Lua Kix blocks can be exported as JSON." }
        target.parentFile?.mkdirs()
        target.writeText(encode(definition).toString(2))
    }

    fun decode(json: String, ownerId: String): CustomBrickDefinition {
        val root = JSONObject(json)
        require(root.optString("format") == FORMAT) { "Unsupported block format." }
        require(root.optInt("version") == VERSION) { "Unsupported block version." }
        val id = root.getString("id")
        require(idPattern.matches(id)) { "Invalid block id." }
        val header = root.getString("header").trim()
        require(header.isNotEmpty() && header.length <= 80) { "Invalid block header." }
        val kind = root.optString("kind", KixBlockKind.CUSTOM.name).uppercase()
        val blockKind = try {
            KixBlockKind.valueOf(kind)
        } catch (exception: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid block kind.", exception)
        }
        val lua = root.getString("lua")
        require(lua.isNotBlank() && lua.length <= 65_536) { "Invalid Lua source." }
        val parameters = root.optJSONArray("parameters") ?: JSONArray()
        require(parameters.length() <= 8) { "A block can have at most 8 parameters." }
        val names = mutableSetOf<String>()
        val parsed = (0 until parameters.length()).map { index ->
            val parameter = parameters.getJSONObject(index)
            val name = parameter.getString("name")
            require(idPattern.matches(name) && names.add(name)) { "Invalid parameter name." }
            val type = parameter.optString("type", "text").uppercase()
            val parameterType = when (type) {
                "TEXT" -> ParameterType.TEXT_FIELD
                else -> try {
                    ParameterType.valueOf(type)
                } catch (exception: IllegalArgumentException) {
                    throw IllegalArgumentException("Invalid parameter type.", exception)
                }
            }
            require(parameterType != ParameterType.VARIABLE_DROPDOWN && parameterType != ParameterType.LIST_DROPDOWN) {
                "Dropdown parameters are not supported by portable blocks."
            }
            BrickParameter(parameterType, name)
        }
        return CustomBrickDefinition(id, header, parsed, id, ownerId, lua, blockKind)
    }

    fun encode(definition: CustomBrickDefinition): JSONObject = JSONObject().apply {
        put("format", FORMAT)
        put("version", VERSION)
        put("id", definition.id)
        put("header", definition.headerText)
        put("kind", definition.kind.name.lowercase())
        put("parameters", JSONArray().apply {
            definition.parameters.forEach { parameter ->
                val type = if (parameter.type == ParameterType.TEXT_FIELD) "text" else parameter.type.name.lowercase()
                put(JSONObject().put("name", parameter.nameInLuno).put("type", type))
            }
        })
        put("lua", definition.luaSource)
    }
}
