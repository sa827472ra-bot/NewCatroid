package org.catrobat.catroid.kix.bricks

import org.catrobat.catroid.content.Sprite
import org.catrobat.catroid.content.bricks.Brick

/**
 * Kix Engine Network Bricks
 * Blocos separados por tipo de protocolo: TCP e UDP
 */

// ============ UDP Network ============

class NetworkUDPConnectBrick(var serverIP: String = "", var serverPort: Int = 0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class NetworkUDPSendBrick(var data: String = "") : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class NetworkUDPReceiveBrick(var variableName: String = "") : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class NetworkUDPDisconnectBrick : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

// ============ TCP Network ============

class NetworkTCPConnectBrick(var serverIP: String = "", var serverPort: Int = 0) : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class NetworkTCPSendBrick(var data: String = "") : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class NetworkTCPReceiveBrick(var variableName: String = "") : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class NetworkTCPDisconnectBrick : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

// ============ Common Network ============

class NetworkBroadcastBrick(var message: String = "") : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}

class NetworkListenBrick(var port: Int = 0, var variableName: String = "") : Brick() {
    override fun getViewResource() = -1
    override fun executeBlock(sprite: Sprite?) = Unit
}
