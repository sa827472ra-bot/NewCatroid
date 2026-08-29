package org.catrobat.catroid.kix.bricks

import org.catrobat.catroid.content.Sprite
import org.catrobat.catroid.content.bricks.Brick

/**
 * Kix Engine Collision Bricks
 * Blocos para detecção de colisão e filtros
 */

class CollisionDetectionBrick(var layer1: Int = 0, var layer2: Int = 1) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class CollisionGroupFilterBrick(var layerFilter: Int = 0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class OnCollisionBrick(var targetLayer: Int = 0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}
