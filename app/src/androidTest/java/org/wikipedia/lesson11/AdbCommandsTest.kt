package org.wikipedia.lesson11

import android.view.Surface
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.main.MainActivity

//важно запустить на хосте adbswerver-desktop.jar до старта тестов:
//java -jar adbserver-desktop.jar

class AdbCommandsTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkAdb() {
        run {
// Сохраняем текст в файл на девайсе
// аналог это adb shell 'echo "Hello from Kaspresso" > /sdcard/kaspresso_test.txt'
            adbServer.performShell(
                command = "echo",
                arguments = listOf(
                    "Hello from Kaspresso",
                    ">",
                    "/sdcard/kaspresso_test.txt"
                )
            )
            adbServer.performAdb("shell svc data disable")
            adbServer.performAdb("shell svc wifi enable")
            adbServer.performAdb("shell svc wifi disable")
            device.uiDevice.findObject(UiSelector().scrollable(true))
                .click()

// Скачиваем файл с девайса на ПК
// аналог это adb pull //sdcard/kaspresso_test.txt ./kaspresso_test.txt
            adbServer.performAdb(
                command = "pull",
                arguments = listOf(
                    "/sdcard/kaspresso_test.txt",
                    "./kaspresso_test.txt"
                )
            )
        }
    }

    @Test
    fun preAndPostScenario() {
        before("Название теста") {
            device.network.toggleMobileData(false)
            device.network.toggleWiFi(false)
            device.exploit.rotate()
            device.location.disableGps()
        }.after {
            device.network.toggleMobileData(true)
            device.network.toggleWiFi(true)
            device.location.enableGps()
        }.run {
            // код сценария
        }
    }

    //Practice
    @Test
    fun checkAdbCommands() {
        run {
            device.uiDevice.setOrientationRight()
            Thread.sleep(3000)
            val actual = device.uiDevice.getDisplayRotation()
            val expected = Surface.ROTATION_270
            Assert.assertEquals(expected, actual)

            repeat(3) {
                device.uiDevice.setOrientationRight()
                Thread.sleep(3000)
                device.uiDevice.setOrientationNatural()
                Thread.sleep(3000)
            }
        }
    }


    @Test
    fun preAndPostScenarioTest() {
        before("Название теста") {
            adbServer.performAdb("shell svc data disable")
            adbServer.performAdb("shell svc wifi disable")
        }.after {
            adbServer.performAdb("shell svc data enable")
            adbServer.performAdb("shell svc wifi enable")
        }.run {
            OnboardingScreen.skipButton.click()
            Thread.sleep(10000)
        }
    }
}
