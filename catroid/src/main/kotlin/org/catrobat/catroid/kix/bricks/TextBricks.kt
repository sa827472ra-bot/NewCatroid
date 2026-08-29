package org.catrobat.catroid.kix.bricks

import org.catrobat.catroid.content.Sprite
import org.catrobat.catroid.content.bricks.Brick

/**
 * Kix Engine Text Bricks
 * Blocos totalmente customizáveis para texto com cores, gradientes, contornos e animações
 */

class CreateTextBrick(var content: String = "", var x: Double = 0.0, var y: Double = 0.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class SetTextColorBrick(var colorHex: String = "#FFFFFF") : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class SetTextGradientBrick(
    var colorStart: String = "#FFFFFF",
    var colorEnd: String = "#000000",
    var gradientDirection: String = "HORIZONTAL"
) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class SetTextStrokeBrick(
    var enabled: Boolean = false,
    var thickness: Double = 1.0,
    var colorHex: String = "#000000"
) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class SetTextFontBrick(
    var fontName: String = "Arial",
    var fontSize: Double = 24.0
) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class SetTextAlignmentBrick(var alignment: String = "CENTER") : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class SetTextRotationBrick(var angleDegrees: Double = 0.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class SetTextScaleBrick(var scaleX: Double = 1.0, var scaleY: Double = 1.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class SetTextAlphaBrick(var alpha: Float = 1.0f) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

// ============ Text Animations ============

class TextAnimationFadeInBrick(var duration: Double = 1.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class TextAnimationFadeOutBrick(var duration: Double = 1.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class TextAnimationSlideInBrick(
    var direction: String = "LEFT",
    var duration: Double = 0.5
) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class TextAnimationTypewriterBrick(
    var speed: Double = 0.05,
    var enableSound: Boolean = false
) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class TextAnimationBounceBrick(var intensity: Double = 1.0, var duration: Double = 1.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class TextAnimationRotateBrick(var rotations: Int = 1, var duration: Double = 1.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class TextAnimationPulseBrick(var minScale: Double = 0.8, var maxScale: Double = 1.2, var duration: Double = 1.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class TextAnimationShakeBrick(var intensity: Double = 1.0, var duration: Double = 0.5) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class TextAnimationRainbowBrick(var speed: Double = 1.0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class TextAnimationGlitchBrick(var intensity: Double = 1.0, var duration: Double = 0.5) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}
