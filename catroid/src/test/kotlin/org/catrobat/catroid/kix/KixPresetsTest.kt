package org.catrobat.catroid.kix

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.catrobat.catroid.kix.bricks.*

/**
 * Kix Engine Comprehensive Test Suite
 * Testes unitários para LayerManager e todos os blocos de presets
 */

class LayerManagerTest {
    private lateinit var layerManager: LayerManager

    @Before
    fun setUp() {
        layerManager = LayerManager()
    }

    @Test
    fun testInitializesWithTenLayers() {
        for (i in 0 until LayerManager.MAX_LAYERS) {
            assertNotNull("Layer $i should exist", layerManager.getLayer(i))
            assertTrue("Layer $i should be visible by default", layerManager.isLayerVisible(i))
        }
    }

    @Test
    fun testLayerNamesAreCustomizable() {
        val newName = "CustomLayer"
        assertTrue("Should set layer name", layerManager.setLayerName(0, newName))
        assertEquals("Layer name should be updated", newName, layerManager.getLayerName(0))
    }

    @Test
    fun testLayerVisibilityToggle() {
        assertTrue("Layer 0 should be visible initially", layerManager.isLayerVisible(0))
        assertTrue("Should hide layer", layerManager.hideLayer(0))
        assertFalse("Layer 0 should be hidden", layerManager.isLayerVisible(0))
        assertTrue("Should show layer", layerManager.showLayer(0))
        assertTrue("Layer 0 should be visible again", layerManager.isLayerVisible(0))
    }

    @Test
    fun testToggleLayerVisibility() {
        val initialState = layerManager.isLayerVisible(0)
        assertTrue("Should toggle visibility", layerManager.toggleLayerVisibility(0))
        assertNotEquals("Visibility should be toggled", initialState, layerManager.isLayerVisible(0))
    }

    @Test
    fun testInvalidLayerIndexReturnsFalse() {
        assertFalse("Should return false for invalid layer index", layerManager.setLayerName(15, "Invalid"))
        assertFalse("Should return false for negative index", layerManager.hideLayer(-1))
    }

    @Test
    fun testGetAllVisibleActors() {
        val actors = layerManager.getAllVisibleActors()
        assertTrue("Should return empty list initially", actors.isEmpty())
    }

    @Test
    fun testRenderOrderIsCorrect() {
        val renderOrder = layerManager.getRenderOrder()
        assertEquals("Should have all visible layers", LayerManager.MAX_LAYERS, renderOrder.size)
        for (i in 0 until LayerManager.MAX_LAYERS) {
            assertEquals("Layer order should match index", i, renderOrder[i].index)
        }
    }

    @Test
    fun testBringLayerToFrontReturnsTrue() {
        assertTrue("Should bring layer to front", layerManager.bringLayerToFront(5))
    }

    @Test
    fun testSendLayerToBackReturnsTrue() {
        assertTrue("Should send layer to back", layerManager.sendLayerToBack(5))
    }
}

// ============ Camera Bricks Tests ============

class CameraBricksTest {

    @Test
    fun testCameraFollowPlayerBrickInitialization() {
        val brick = CameraFollowPlayerBrick(offsetX = 10.0, offsetY = 20.0)
        assertEquals("Offset X should be set", 10.0, brick.offsetX, 0.0)
        assertEquals("Offset Y should be set", 20.0, brick.offsetY, 0.0)
    }

    @Test
    fun testCameraFixedPositionBrickInitialization() {
        val brick = CameraFixedPositionBrick(posX = 100.0, posY = 200.0)
        assertEquals("Position X should be set", 100.0, brick.posX, 0.0)
        assertEquals("Position Y should be set", 200.0, brick.posY, 0.0)
    }

    @Test
    fun testCameraZoomBrickInitialization() {
        val brick = CameraZoomBrick(zoomLevel = 2.5)
        assertEquals("Zoom level should be set", 2.5, brick.zoomLevel, 0.0)
    }

    @Test
    fun testCameraShakeBrickInitialization() {
        val brick = CameraShakeBrick(intensity = 1.5, duration = 0.8)
        assertEquals("Intensity should be set", 1.5, brick.intensity, 0.0)
        assertEquals("Duration should be set", 0.8, brick.duration, 0.0)
    }

    @Test
    fun testCameraFadeInBrickInitialization() {
        val brick = CameraFadeInBrick(duration = 2.0, targetAlpha = 1.0f)
        assertEquals("Duration should be set", 2.0, brick.duration, 0.0)
        assertEquals("Target alpha should be set", 1.0f, brick.targetAlpha)
    }

    @Test
    fun testCameraBoundsBrickInitialization() {
        val brick = CameraBoundsBrick(minX = 0.0, minY = 0.0, maxX = 800.0, maxY = 600.0)
        assertEquals("Min X should be set", 0.0, brick.minX, 0.0)
        assertEquals("Max X should be set", 800.0, brick.maxX, 0.0)
    }

    @Test
    fun testCameraIsometricBrickInitialization() {
        val brick = CameraIsometricBrick(enabled = true)
        assertTrue("Isometric should be enabled", brick.enabled)
    }

    @Test
    fun testCameraMultiplayerViewBrickInitialization() {
        val brick = CameraMultiplayerViewBrick(playerCount = 4, layout = "GRID_2x2")
        assertEquals("Player count should be set", 4, brick.playerCount)
        assertEquals("Layout should be set", "GRID_2x2", brick.layout)
    }

    @Test
    fun testCameraCinematicCutBrickInitialization() {
        val brick = CameraCinematicCutBrick(
            targetX = 100.0, targetY = 100.0,
            duration = 2.0, easeType = "EASE_OUT"
        )
        assertEquals("Target X should be set", 100.0, brick.targetX, 0.0)
        assertEquals("Duration should be set", 2.0, brick.duration, 0.0)
        assertEquals("Ease type should be set", "EASE_OUT", brick.easeType)
    }
}

// ============ Joystick Bricks Tests ============

class JoystickBricksTest {

    @Test
    fun testJoystickDPadBrickInitialization() {
        val brick = JoystickDPadBrick(sensitivityX = 1.5, sensitivityY = 1.5)
        assertEquals("Sensitivity X should be set", 1.5, brick.sensitivityX, 0.0)
        assertEquals("Sensitivity Y should be set", 1.5, brick.sensitivityY, 0.0)
    }

    @Test
    fun testJoystickAnalogBrickInitialization() {
        val brick = JoystickAnalogBrick(deadzone = 0.2, maxRange = 1.0)
        assertEquals("Deadzone should be set", 0.2, brick.deadzone, 0.0)
        assertEquals("Max range should be set", 1.0, brick.maxRange, 0.0)
    }

    @Test
    fun testJoystickDualStickBrickInitialization() {
        val brick = JoystickDualStickBrick(leftDeadzone = 0.1, rightDeadzone = 0.15)
        assertEquals("Left deadzone should be set", 0.1, brick.leftDeadzone, 0.0)
        assertEquals("Right deadzone should be set", 0.15, brick.rightDeadzone, 0.0)
    }

    @Test
    fun testGetJoystickInputBrickInitialization() {
        val brick = GetJoystickInputBrick(axisType = "Y")
        assertEquals("Axis type should be set", "Y", brick.axisType)
    }
}

// ============ Network Bricks Tests ============

class NetworkBricksTest {

    @Test
    fun testNetworkUDPConnectBrickInitialization() {
        val brick = NetworkUDPConnectBrick(serverIP = "192.168.1.1", serverPort = 5000)
        assertEquals("Server IP should be set", "192.168.1.1", brick.serverIP)
        assertEquals("Server port should be set", 5000, brick.serverPort)
    }

    @Test
    fun testNetworkTCPConnectBrickInitialization() {
        val brick = NetworkTCPConnectBrick(serverIP = "127.0.0.1", serverPort = 8080)
        assertEquals("Server IP should be set", "127.0.0.1", brick.serverIP)
        assertEquals("Server port should be set", 8080, brick.serverPort)
    }

    @Test
    fun testNetworkUDPSendBrickInitialization() {
        val brick = NetworkUDPSendBrick(data = "Hello UDP")
        assertEquals("Data should be set", "Hello UDP", brick.data)
    }

    @Test
    fun testNetworkTCPSendBrickInitialization() {
        val brick = NetworkTCPSendBrick(data = "Hello TCP")
        assertEquals("Data should be set", "Hello TCP", brick.data)
    }

    @Test
    fun testNetworkUDPReceiveBrickInitialization() {
        val brick = NetworkUDPReceiveBrick(variableName = "receivedData")
        assertEquals("Variable name should be set", "receivedData", brick.variableName)
    }

    @Test
    fun testNetworkBroadcastBrickInitialization() {
        val brick = NetworkBroadcastBrick(message = "Broadcasting")
        assertEquals("Message should be set", "Broadcasting", brick.message)
    }

    @Test
    fun testNetworkListenBrickInitialization() {
        val brick = NetworkListenBrick(port = 9000, variableName = "incomingData")
        assertEquals("Port should be set", 9000, brick.port)
        assertEquals("Variable name should be set", "incomingData", brick.variableName)
    }
}

// ============ Collision Bricks Tests ============

class CollisionBricksTest {

    @Test
    fun testCollisionDetectionBrickInitialization() {
        val brick = CollisionDetectionBrick(layer1 = 0, layer2 = 1)
        assertEquals("Layer 1 should be set", 0, brick.layer1)
        assertEquals("Layer 2 should be set", 1, brick.layer2)
    }

    @Test
    fun testCollisionGroupFilterBrickInitialization() {
        val brick = CollisionGroupFilterBrick(layerFilter = 3)
        assertEquals("Layer filter should be set", 3, brick.layerFilter)
    }

    @Test
    fun testOnCollisionBrickInitialization() {
        val brick = OnCollisionBrick(targetLayer = 2)
        assertEquals("Target layer should be set", 2, brick.targetLayer)
    }
}

// ============ Bot Bricks Tests ============

class BotBricksTest {

    @Test
    fun testBotPatrolBrickInitialization() {
        val waypoints = listOf(Pair(0.0, 0.0), Pair(100.0, 100.0))
        val brick = BotPatrolBrick(waypoints = waypoints)
        assertEquals("Waypoints should be set", waypoints, brick.waypoints)
        assertEquals("Should have 2 waypoints", 2, brick.waypoints.size)
    }

    @Test
    fun testBotFollowTargetBrickInitialization() {
        val brick = BotFollowTargetBrick(targetSprite = "Player", speed = 3.5)
        assertEquals("Target sprite should be set", "Player", brick.targetSprite)
        assertEquals("Speed should be set", 3.5, brick.speed, 0.0)
    }

    @Test
    fun testBotPathfindBrickInitialization() {
        val brick = BotPathfindBrick(targetX = 500.0, targetY = 500.0)
        assertEquals("Target X should be set", 500.0, brick.targetX, 0.0)
        assertEquals("Target Y should be set", 500.0, brick.targetY, 0.0)
    }

    @Test
    fun testBotAIBehaviorBrickInitialization() {
        val brick = BotAIBehaviorBrick(behaviorType = "CHASE")
        assertEquals("Behavior type should be set", "CHASE", brick.behaviorType)
    }
}

// ============ Layer Bricks Tests ============

class LayerBricksTest {

    @Test
    fun testShowLayerBrickInitialization() {
        val brick = ShowLayerBrick(layerIndex = 2)
        assertEquals("Layer index should be set", 2, brick.layerIndex)
    }

    @Test
    fun testHideLayerBrickInitialization() {
        val brick = HideLayerBrick(layerIndex = 3)
        assertEquals("Layer index should be set", 3, brick.layerIndex)
    }

    @Test
    fun testToggleLayerVisibilityBrickInitialization() {
        val brick = ToggleLayerVisibilityBrick(layerIndex = 1)
        assertEquals("Layer index should be set", 1, brick.layerIndex)
    }

    @Test
    fun testSetLayerNameBrickInitialization() {
        val brick = SetLayerNameBrick(layerIndex = 0, layerName = "Background")
        assertEquals("Layer index should be set", 0, brick.layerIndex)
        assertEquals("Layer name should be set", "Background", brick.layerName)
    }

    @Test
    fun testSetActorLayerBrickInitialization() {
        val brick = SetActorLayerBrick(layerIndex = 5)
        assertEquals("Layer index should be set", 5, brick.layerIndex)
    }

    @Test
    fun testBringLayerToFrontBrickInitialization() {
        val brick = BringLayerToFrontBrick(layerIndex = 2)
        assertEquals("Layer index should be set", 2, brick.layerIndex)
    }

    @Test
    fun testSendLayerToBackBrickInitialization() {
        val brick = SendLayerToBackBrick(layerIndex = 4)
        assertEquals("Layer index should be set", 4, brick.layerIndex)
    }
}

// ============ SuperTextBrick Tests ============

class SuperTextBrickTest {

    @Test
    fun testSuperTextBrickInitialization() {
        val brick = SuperTextBrick()
        assertNotNull("TextConfig should be initialized", brick.config)
        assertEquals("Content should be empty by default", "", brick.config.content)
        assertEquals("Font size should be 24 by default", 24.0, brick.config.fontSize, 0.0)
    }

    @Test
    fun testWithContent() {
        val brick = SuperTextBrick().withContent("Hello World")
        assertEquals("Content should be set", "Hello World", brick.config.content)
    }

    @Test
    fun testWithPosition() {
        val brick = SuperTextBrick().withPosition(100.0, 200.0)
        assertEquals("X position should be set", 100.0, brick.config.x, 0.0)
        assertEquals("Y position should be set", 200.0, brick.config.y, 0.0)
    }

    @Test
    fun testWithColor() {
        val brick = SuperTextBrick().withColor("#FF0000")
        assertEquals("Color should be set", "#FF0000", brick.config.colorHex)
        assertFalse("Gradient should be disabled", brick.config.useGradient)
    }

    @Test
    fun testWithGradient() {
        val brick = SuperTextBrick().withGradient("#FFFFFF", "#000000", "VERTICAL")
        assertTrue("Gradient should be enabled", brick.config.useGradient)
        assertEquals("Start color should be set", "#FFFFFF", brick.config.gradientColorStart)
        assertEquals("End color should be set", "#000000", brick.config.gradientColorEnd)
        assertEquals("Direction should be set", "VERTICAL", brick.config.gradientDirection)
    }

    @Test
    fun testWithStroke() {
        val brick = SuperTextBrick().withStroke(true, 2.5, "#FF00FF")
        assertTrue("Stroke should be enabled", brick.config.strokeEnabled)
        assertEquals("Stroke thickness should be set", 2.5, brick.config.strokeThickness, 0.0)
        assertEquals("Stroke color should be set", "#FF00FF", brick.config.strokeColor)
    }

    @Test
    fun testWithFont() {
        val brick = SuperTextBrick().withFont("Courier New", 32.0)
        assertEquals("Font name should be set", "Courier New", brick.config.fontName)
        assertEquals("Font size should be set", 32.0, brick.config.fontSize, 0.0)
    }

    @Test
    fun testWithAlignment() {
        val brick = SuperTextBrick().withAlignment("RIGHT")
        assertEquals("Alignment should be set", "RIGHT", brick.config.alignment)
    }

    @Test
    fun testWithRotation() {
        val brick = SuperTextBrick().withRotation(45.0)
        assertEquals("Rotation should be set", 45.0, brick.config.rotationDegrees, 0.0)
    }

    @Test
    fun testWithScale() {
        val brick = SuperTextBrick().withScale(2.0, 1.5)
        assertEquals("Scale X should be set", 2.0, brick.config.scaleX, 0.0)
        assertEquals("Scale Y should be set", 1.5, brick.config.scaleY, 0.0)
    }

    @Test
    fun testWithAlpha() {
        val brick = SuperTextBrick().withAlpha(0.5f)
        assertEquals("Alpha should be set", 0.5f, brick.config.alpha)
    }

    @Test
    fun testWithAlphaClamp() {
        val brick = SuperTextBrick().withAlpha(1.5f)
        assertEquals("Alpha should be clamped to 1.0", 1.0f, brick.config.alpha)
        
        val brick2 = SuperTextBrick().withAlpha(-0.5f)
        assertEquals("Alpha should be clamped to 0.0", 0.0f, brick2.config.alpha)
    }

    @Test
    fun testWithAnimationFadeIn() {
        val brick = SuperTextBrick().withAnimationFadeIn(2.0)
        assertEquals("Animation type should be FADE_IN", "FADE_IN", brick.config.animationType)
        assertEquals("Duration should be set", 2.0, brick.config.animationDuration, 0.0)
    }

    @Test
    fun testWithAnimationFadeOut() {
        val brick = SuperTextBrick().withAnimationFadeOut(1.5)
        assertEquals("Animation type should be FADE_OUT", "FADE_OUT", brick.config.animationType)
        assertEquals("Duration should be set", 1.5, brick.config.animationDuration, 0.0)
    }

    @Test
    fun testWithAnimationSlideIn() {
        val brick = SuperTextBrick().withAnimationSlideIn("DOWN", 0.8)
        assertEquals("Animation type should be SLIDE_IN", "SLIDE_IN", brick.config.animationType)
        assertEquals("Direction should be set", "DOWN", brick.config.slideDirection)
        assertEquals("Duration should be set", 0.8, brick.config.animationDuration, 0.0)
    }

    @Test
    fun testWithAnimationTypewriter() {
        val brick = SuperTextBrick().withAnimationTypewriter(0.03, true)
        assertEquals("Animation type should be TYPEWRITER", "TYPEWRITER", brick.config.animationType)
        assertEquals("Speed should be set", 0.03, brick.config.typewriterSpeed, 0.0)
        assertTrue("Sound should be enabled", brick.config.typewriterSound)
    }

    @Test
    fun testWithAnimationBounce() {
        val brick = SuperTextBrick().withAnimationBounce(1.5, 1.0)
        assertEquals("Animation type should be BOUNCE", "BOUNCE", brick.config.animationType)
        assertEquals("Intensity should be set", 1.5, brick.config.bounceIntensity, 0.0)
    }

    @Test
    fun testWithAnimationRotate() {
        val brick = SuperTextBrick().withAnimationRotate(2, 2.0)
        assertEquals("Animation type should be ROTATE", "ROTATE", brick.config.animationType)
        assertEquals("Rotation count should be set", 2, brick.config.rotationCount)
    }

    @Test
    fun testWithAnimationPulse() {
        val brick = SuperTextBrick().withAnimationPulse(0.9, 1.1, 0.5)
        assertEquals("Animation type should be PULSE", "PULSE", brick.config.animationType)
        assertEquals("Min scale should be set", 0.9, brick.config.pulseMinScale, 0.0)
        assertEquals("Max scale should be set", 1.1, brick.config.pulseMaxScale, 0.0)
    }

    @Test
    fun testWithAnimationShake() {
        val brick = SuperTextBrick().withAnimationShake(2.0, 0.3)
        assertEquals("Animation type should be SHAKE", "SHAKE", brick.config.animationType)
        assertEquals("Intensity should be set", 2.0, brick.config.shakeIntensity, 0.0)
    }

    @Test
    fun testWithAnimationRainbow() {
        val brick = SuperTextBrick().withAnimationRainbow(0.5)
        assertEquals("Animation type should be RAINBOW", "RAINBOW", brick.config.animationType)
        assertEquals("Speed should be set", 0.5, brick.config.rainbowSpeed, 0.0)
    }

    @Test
    fun testWithAnimationGlitch() {
        val brick = SuperTextBrick().withAnimationGlitch(1.5, 0.6)
        assertEquals("Animation type should be GLITCH", "GLITCH", brick.config.animationType)
        assertEquals("Intensity should be set", 1.5, brick.config.glitchIntensity, 0.0)
    }

    @Test
    fun testIsValidWithCompleteConfig() {
        val brick = SuperTextBrick()
            .withContent("Valid Text")
            .withFont("Arial", 20.0)
            .withAlpha(0.8f)
        assertTrue("Brick should be valid", brick.isValid())
    }

    @Test
    fun testIsInvalidWithEmptyContent() {
        val brick = SuperTextBrick()
            .withFont("Arial", 20.0)
        assertFalse("Brick should be invalid with empty content", brick.isValid())
    }

    @Test
    fun testIsInvalidWithInvalidFontSize() {
        val brick = SuperTextBrick()
            .withContent("Text")
            .withFont("Arial", 0.0)
        assertFalse("Brick should be invalid with zero font size", brick.isValid())
    }

    @Test
    fun testIsInvalidWithInvalidAnimation() {
        val brick = SuperTextBrick()
            .withContent("Text")
        brick.config.animationType = "INVALID_ANIMATION"
        assertFalse("Brick should be invalid with invalid animation", brick.isValid())
    }

    @Test
    fun testFluentAPIChaining() {
        val brick = SuperTextBrick()
            .withContent("Chained Text")
            .withPosition(50.0, 100.0)
            .withFont("Verdana", 28.0)
            .withColor("#00FF00")
            .withStroke(true, 1.5, "#FFFFFF")
            .withRotation(15.0)
            .withScale(1.2)
            .withAlpha(0.9f)
            .withAnimationPulse(0.8, 1.3, 1.0)
        
        assertTrue("Chained configuration should be valid", brick.isValid())
        assertEquals("Content should match", "Chained Text", brick.config.content)
        assertEquals("X position should match", 50.0, brick.config.x, 0.0)
        assertEquals("Animation type should match", "PULSE", brick.config.animationType)
    }

    @Test
    fun testGetTextInfo() {
        val brick = SuperTextBrick()
            .withContent("Test")
            .withFont("Arial", 24.0)
            .withColor("#FF0000")
        
        val info = brick.getTextInfo()
        assertTrue("Info should contain content", info.contains("Test"))
        assertTrue("Info should contain font name", info.contains("Arial"))
    }

    @Test
    fun testGetAnimationInfo() {
        val brick = SuperTextBrick()
            .withAnimationFadeIn(1.5)
        
        val info = brick.getAnimationInfo()
        assertTrue("Info should contain animation type", info.contains("FADE_IN"))
        assertTrue("Info should contain duration", info.contains("1.5"))
    }
}
