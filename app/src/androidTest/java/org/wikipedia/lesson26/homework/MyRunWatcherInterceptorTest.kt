package org.wikipedia.lesson26.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.interceptors.watcher.testcase.impl.logging.TestRunLoggerWatcherInterceptor
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.main.MainActivity

class MyRunWatcherInterceptorTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        testRunWatcherInterceptors.removeIf {
            it is TestRunLoggerWatcherInterceptor
        }
        testRunWatcherInterceptors.add(MyTestRunWatcherInterceptor(testLogger))
    }
) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun simpleTest() {
        before {
            OnboardingScreen.continueButton.isDisplayed()
        }.after {
            ExploreScreen.logo.isDisplayed()
        }.run {
            step("Click skip button") {
                OnboardingScreen.skipButton.click()
            }
        }
    }
}