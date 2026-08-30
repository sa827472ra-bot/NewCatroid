// org/catrobat/catroid/libraries/CustomBrickDefinition.kt
package org.catrobat.catroid.libraries

/** Input controls supported by portable Kix blocks. Formula-backed inputs can contain literals or formulas. */
enum class ParameterType {
    TEXT_FIELD, NUMBER, BOOLEAN, COLOR, FILE, OBJECT_ID, SHADER_SOURCE,
    VARIABLE_DROPDOWN, LIST_DROPDOWN
}

/** A hint for grouping and presenting blocks in the Kix library picker. */
enum class KixBlockKind { BASIC, TEXT, SHADER, CAMERA, PRESET, THREE_D, CUSTOM }

data class BrickParameter(
    val type: ParameterType,
    val nameInLuno: String // Имя для Luno-функции
)

data class CustomBrickDefinition(
    val id: String,
    val headerText: String,
    val parameters: List<BrickParameter>,
    val lunoFunctionName: String,
    val ownerLibraryId: String,
    /** Lua source is used by portable Kix JSON blocks; null keeps legacy Luno libraries unchanged. */
    val luaSource: String? = null,
    val kind: KixBlockKind = KixBlockKind.CUSTOM
)
