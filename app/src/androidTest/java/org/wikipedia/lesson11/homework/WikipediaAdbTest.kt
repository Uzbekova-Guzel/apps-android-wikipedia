package org.wikipedia.lesson11.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.announcement.AnnouncementCardView
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.lesson08.homework.CustomizeItem
import org.wikipedia.lesson08.homework.CustomizeScreen.backButton
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.main.MainActivity
import java.util.Locale

class WikipediaAdbTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkOrientationTest() {
        run("Проверка поворота экрана") {
            step("Повернуть экран направо") {
                device.uiDevice.setOrientationRight()
                Thread.sleep(3000)
            }
            step("Повернуть экран налево") {
                device.uiDevice.setOrientationLeft()
                Thread.sleep(3000)
            }
            step("Установить портретный формат экрана") {
                device.uiDevice.setOrientationNatural()
                Thread.sleep(3000)
            }
            step("Проверить что отображается портретная ориентация") {
                device.uiDevice.isNaturalOrientation
            }
        }
    }

    @Test
    fun checkTurnOffScreenTest() {
        run("Проверка отображения элемента экрана после выключения экрана") {
            step("Проверить отображение кнопки Skip") {
                OnboardingScreen.skipButton.isDisplayed()
            }
            step("Выключить экран") {
                device.uiDevice.sleep()
                Thread.sleep(100)
            }
            step("Включить экран") {
                device.uiDevice.wakeUp()
                Thread.sleep(100)
            }
            step("Проверить отображение кнопки Skip") {
                OnboardingScreen.skipButton.isDisplayed()
            }
        }
    }

    @Test
    fun checkRecoveryAfterCollapseTest() {
        run("Проверка отображения элемента экрана после сворачивания экрана") {
            step("Проверить отображение кнопки Skip") {
                OnboardingScreen.skipButton.isDisplayed()
            }
            step("Свернуть приложение по кнопке Home") {
                device.uiDevice.pressHome()
            }
            step("Развернуть приложение") {
                repeat(2) {
                    device.uiDevice.pressRecentApps()
                    Thread.sleep(300)
                }
            }
            step("Проверить отображение кнопки Skip") {
                OnboardingScreen.skipButton.isDisplayed()
            }
        }
    }

    @Test
    fun checkTurnOfInternetTest() {
        before("Проверка отображения экрана ошибки при отсутствии интернета") {
            adbServer.performAdb("shell svc data disable")
            adbServer.performAdb("shell svc wifi disable")
        }.after {
            adbServer.performAdb("shell svc data enable")
            adbServer.performAdb("shell svc wifi enable")
        }.run {
            step("Кликнуть на кнопку Skip") {
                OnboardingScreen.skipButton.click()
            }
            ExploreScreen {
                items.childWith<CustomizeItem> {
                    isInstanceOf(AnnouncementCardView::class.java)
                } perform {
                    step("Нажимает на кнопку Customize в блоке Customize your Explore feed экрана Explore") {
                        customizeButton.click()
                    }
                    step("Нажимает стрелку назад в верхнем тулбаре") {
                        backButton.click()
                    }
                }
            }
        }
    }

    @Test
    fun checkLanguageChangeTest() {
        before("Проверка перевода кнопки Skip на немецкий язык") {
            device.language.switchInApp(Locale.GERMAN)
        }.after {
            device.language.switchInApp(Locale.ENGLISH)
        }.run {
            step("Проверить текст кнопки Skip") {
                OnboardingScreen.skipButton.hasText("Überspringen")
            }
        }
    }

    @Test
    fun checkActivityTest() {
        run("Проверка активити MainActivity") {
            step("Кликнуть на кнопку Skip") {
                OnboardingScreen.skipButton.click()
            }
            step("Проверяет MainActivity активна") {
                device.activities.isCurrent(MainActivity::class.java)
            }
        }
    }
}
