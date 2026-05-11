package org.wikipedia.lesson26

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.interceptors.step.ScreenshotStepInterceptor
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.device.screenshots.Screenshots
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.main.MainActivity

class SampleTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        stepWatcherInterceptors.removeIf {
            it is ScreenshotStepInterceptor
        }
        stepWatcherInterceptors.add(MyScreenshotStepOnlyFailInterceptor(screenshots))
    }
) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun simpleTest() {
        run {
            step("test") {
                OnboardingScreen.continueButton {
                    isDisplayed()
                    click()
                }
            }
            step("fail") {
                ExploreScreen.items.isDisplayed()
            }
        }
    }
}