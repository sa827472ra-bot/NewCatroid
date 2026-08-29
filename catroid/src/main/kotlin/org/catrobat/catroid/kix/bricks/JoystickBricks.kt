package org.catrobat.catroid.kix.bricks

import org.catrobat.catroid.content.Sprite
import org.catrobat.catroid.content.bricks.Brick

/**
 * Kix Engine Joystick Bricks
 * Blocos para controle de entrada com diferentes tipos de joystick
 */

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
