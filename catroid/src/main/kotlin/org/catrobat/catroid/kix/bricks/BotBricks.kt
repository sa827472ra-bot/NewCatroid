package org.catrobat.catroid.kix.bricks

import org.catrobat.catroid.content.Sprite
import org.catrobat.catroid.content.bricks.Brick

/**
 * Kix Engine Bot Bricks
 * Blocos para AI e comportamento de bots/inimigos
 */

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
