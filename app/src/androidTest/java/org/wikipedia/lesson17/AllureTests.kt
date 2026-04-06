package org.wikipedia.lesson17

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.main.MainActivity

class AllureTests : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun allurePassedTests() {
        run("Проверка экрана Onboarding с использованием Allure") {
            step("Проверяет что кнопка Skip отображается") {
                OnboardingScreen.skipButton.isDisplayed()
            }
            step("Проверяет что кнопка Continue имеет текст Continue") {
                OnboardingScreen.continueButton.hasText("Continue")
            }
        }
    }

    @Test
    fun allureFailedTests() {
        run("Проверка экрана Onboarding с использованием Allure") {
            step("Проверяет что кнопка Skip отображается") {
                OnboardingScreen.skipButton.isDisplayed()
            }
            step("Проверяет что кнопка Continue имеет текст Далее") {
                OnboardingScreen.continueButton.hasText("Далее")
            }
        }
    }
}