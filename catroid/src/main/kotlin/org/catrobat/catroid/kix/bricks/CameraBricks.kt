package org.catrobat.catroid.kix.bricks

import org.catrobat.catroid.content.Sprite
import org.catrobat.catroid.content.bricks.Brick

/**
 * Kix Engine Camera Bricks - Professional Game Development
 * Blocos avançados de câmera para desenvolvimento sério
 */

// ============ Basic Camera ============

class CameraFollowPlayerBrick(var offsetX: Double = 0.0, var offsetY: Double = 0.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class CameraFixedPositionBrick(var posX: Double = 0.0, var posY: Double = 0.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class CameraZoomBrick(var zoomLevel: Double = 1.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class CameraRotateBrick(var angleDegrees: Double = 0.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

// ============ Advanced Camera ============

class CameraShakeBrick(var intensity: Double = 1.0, var duration: Double = 0.5) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class CameraFadeInBrick(var duration: Double = 1.0, var targetAlpha: Float = 1.0f) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class CameraFadeOutBrick(var duration: Double = 1.0, var targetAlpha: Float = 0.0f) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class CameraBoundsBrick(var minX: Double = 0.0, var minY: Double = 0.0, 
                        var maxX: Double = 800.0, var maxY: Double = 600.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class CameraLerpBrick(var targetX: Double = 0.0, var targetY: Double = 0.0, 
                      var speed: Double = 1.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class CameraDepthOfFieldBrick(var focusDistance: Double = 5.0, var blurStrength: Double = 1.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class CameraIsometricBrick(var enabled: Boolean = true) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class CameraMultiplayerViewBrick(var playerCount: Int = 2, var layout: String = "SPLIT_HORIZONTAL") : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class CameraCinematicCutBrick(var targetX: Double = 0.0, var targetY: Double = 0.0, 
                              var duration: Double = 2.0, var easeType: String = "LINEAR") : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}
