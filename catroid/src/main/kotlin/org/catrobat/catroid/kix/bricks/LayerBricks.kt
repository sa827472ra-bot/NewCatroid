package org.catrobat.catroid.kix.bricks

import org.catrobat.catroid.content.Sprite
import org.catrobat.catroid.content.bricks.Brick

/**
 * Kix Engine Layer Bricks
 * Blocos para controlar visibilidade e propriedades de layers
 */

class ShowLayerBrick(var layerIndex: Int = 0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class HideLayerBrick(var layerIndex: Int = 0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class ToggleLayerVisibilityBrick(var layerIndex: Int = 0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class SetLayerNameBrick(var layerIndex: Int = 0, var layerName: String = "") : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class SetActorLayerBrick(var layerIndex: Int = 0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class GetActorLayerBrick(var layerIndex: Int = 0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class BringLayerToFrontBrick(var layerIndex: Int = 0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class SendLayerToBackBrick(var layerIndex: Int = 0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}
