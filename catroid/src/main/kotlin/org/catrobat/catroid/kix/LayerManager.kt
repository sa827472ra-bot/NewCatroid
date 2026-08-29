package org.catrobat.catroid.kix

import android.os.Parcel
import android.os.Parcelable
import org.catrobat.catroid.content.Sprite

/**
 * Kix Engine Layer System
 * Manages up to 10 layers with custom names and visibility
 * Layers control Z-order rendering and actor organization
 */
class LayerManager : Parcelable {

    companion object {
        const val MAX_LAYERS = 10
        const val DEFAULT_LAYER = 0
        
        @JvmField
        val CREATOR = object : Parcelable.Creator<LayerManager> {
            override fun createFromParcel(parcel: Parcel) = LayerManager(parcel)
            override fun newArray(size: Int) = arrayOfNulls<LayerManager>(size)
        }
    }

    private val layers = mutableMapOf<Int, Layer>()
    
    init {
        // Initialize all 10 layers
        for (i in 0 until MAX_LAYERS) {
            layers[i] = Layer(
                index = i,
                name = "Layer ${i + 1}",
                isVisible = true,
                actors = mutableSetOf()
            )
        }
    }

    /**
     * Data class representing a single layer
     */
    data class Layer(
        val index: Int,
        var name: String = "Layer ${index + 1}",
        var isVisible: Boolean = true,
        val actors: MutableSet<Sprite> = mutableSetOf()
    )

    // ============ Layer Management ============

    fun getLayer(index: Int): Layer? {
        return if (index in 0 until MAX_LAYERS) layers[index] else null
    }

    fun setLayerName(index: Int, name: String): Boolean {
        return if (index in 0 until MAX_LAYERS) {
            layers[index]?.name = name
            true
        } else false
    }

    fun getLayerName(index: Int): String? {
        return layers[index]?.name
    }

    fun setLayerVisibility(index: Int, visible: Boolean): Boolean {
        return if (index in 0 until MAX_LAYERS) {
            layers[index]?.isVisible = visible
            true
        } else false
    }

    fun isLayerVisible(index: Int): Boolean {
        return layers[index]?.isVisible ?: false
    }

    fun showLayer(index: Int): Boolean = setLayerVisibility(index, true)
    fun hideLayer(index: Int): Boolean = setLayerVisibility(index, false)

    fun toggleLayerVisibility(index: Int): Boolean {
        val layer = layers[index] ?: return false
        layer.isVisible = !layer.isVisible
        return true
    }

    // ============ Actor Management ============

    fun addActorToLayer(actor: Sprite, layerIndex: Int): Boolean {
        if (layerIndex !in 0 until MAX_LAYERS) return false
        
        // Remove actor from any existing layer
        removeActorFromAllLayers(actor)
        
        // Add to new layer
        return layers[layerIndex]?.actors?.add(actor) ?: false
    }

    fun removeActorFromLayer(actor: Sprite, layerIndex: Int): Boolean {
        return layers[layerIndex]?.actors?.remove(actor) ?: false
    }

    fun removeActorFromAllLayers(actor: Sprite): Boolean {
        var removed = false
        layers.values.forEach { layer ->
            if (layer.actors.remove(actor)) {
                removed = true
            }
        }
        return removed
    }

    fun getActorLayer(actor: Sprite): Int? {
        layers.forEach { (index, layer) ->
            if (layer.actors.contains(actor)) {
                return index
            }
        }
        return null
    }

    fun getLayerActors(layerIndex: Int): Set<Sprite>? {
        return layers[layerIndex]?.actors?.toSet()
    }

    fun getAllVisibleActors(): List<Sprite> {
        val visibleActors = mutableListOf<Sprite>()
        for (i in 0 until MAX_LAYERS) {
            if (layers[i]?.isVisible == true) {
                visibleActors.addAll(layers[i]?.actors ?: emptySet())
            }
        }
        return visibleActors
    }

    fun getAllLayerActors(): List<Sprite> {
        val allActors = mutableListOf<Sprite>()
        layers.values.forEach { layer ->
            allActors.addAll(layer.actors)
        }
        return allActors
    }

    // ============ Layer Ordering ============

    fun bringLayerToFront(index: Int): Boolean {
        if (index !in 0 until MAX_LAYERS) return false
        
        val layer = layers[index] ?: return false
        
        // Create new ordered map moving this layer to the end
        val newLayers = mutableMapOf<Int, Layer>()
        layers.forEach { (i, l) ->
            if (i != index) newLayers[i] = l
        }
        newLayers[index] = layer
        
        // Rebuild layers map with new order
        layers.clear()
        newLayers.forEach { (i, l) ->
            layers[i] = l
        }
        return true
    }

    fun sendLayerToBack(index: Int): Boolean {
        if (index !in 0 until MAX_LAYERS) return false
        
        val layer = layers[index] ?: return false
        
        // Create new ordered map moving this layer to the start
        val newLayers = mutableMapOf<Int, Layer>()
        newLayers[index] = layer
        layers.forEach { (i, l) ->
            if (i != index) newLayers[i] = l
        }
        
        // Rebuild layers map with new order
        layers.clear()
        newLayers.forEach { (i, l) ->
            layers[i] = l
        }
        return true
    }

    // ============ Rendering Order ============

    /**
     * Returns layers in render order (back to front)
     * Only includes visible layers
     */
    fun getRenderOrder(): List<Layer> {
        return layers.values
            .filter { it.isVisible }
            .sortedBy { it.index }
    }

    /**
     * Returns all actors in render order (back to front)
     * Only includes actors from visible layers
     */
    fun getActorsInRenderOrder(): List<Sprite> {
        val ordered = mutableListOf<Sprite>()
        getRenderOrder().forEach { layer ->
            ordered.addAll(layer.actors)
        }
        return ordered
    }

    // ============ Serialization ============

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(layers.size)
        layers.forEach { (index, layer) ->
            parcel.writeInt(index)
            parcel.writeString(layer.name)
            parcel.writeInt(if (layer.isVisible) 1 else 0)
        }
    }

    override fun describeContents(): Int = 0

    constructor(parcel: Parcel) {
        val size = parcel.readInt()
        for (i in 0 until size) {
            val index = parcel.readInt()
            val name = parcel.readString() ?: "Layer ${index + 1}"
            val visible = parcel.readInt() == 1
            layers[index] = Layer(index, name, visible, mutableSetOf())
        }
    }

    constructor()
}
