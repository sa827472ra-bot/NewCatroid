package org.catrobat.catroid.kix.bricks

import org.catrobat.catroid.content.Sprite
import org.catrobat.catroid.content.bricks.Brick

/**
 * Kix Engine Layer Bricks
 * Blocos para controlar visibilidade e propriedades de layers
 */

class ShowLayerBrick(var layerIndex: Int = 0) : Brick() {
    override fun getViewResource() = -1 // Will be defined in layout
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

// Camera Preset Bricks

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

// Joystick Preset Bricks

class JoystickDPadBrick(var sensitivityX: Double = 1.0, var sensitivityY: Double = 1.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class JoystickAnalogBrick(var deadzone: Double = 0.1, var maxRange: Double = 1.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class JoystickDualStickBrick(
    var leftDeadzone: Double = 0.1,
    var rightDeadzone: Double = 0.1
) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class GetJoystickInputBrick(var axisType: String = "X") : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

// Network Preset Bricks

class NetworkUDPConnectBrick(var serverIP: String = "", var serverPort: Int = 0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class NetworkTCPConnectBrick(var serverIP: String = "", var serverPort: Int = 0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class NetworkSendDataBrick(var data: String = "") : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class NetworkReceiveDataBrick(var variableName: String = "") : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class NetworkDisconnectBrick : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

// Collision Preset Bricks

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

// Bot Preset Bricks

class BotPatrolBrick(var waypoints: List<Pair<Double, Double>> = emptyList()) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class BotFollowTargetBrick(var targetSprite: String = "", var speed: Double = 2.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class BotPathfindBrick(var targetX: Double = 0.0, var targetY: Double = 0.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class BotAIBehaviorBrick(var behaviorType: String = "IDLE") : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}
