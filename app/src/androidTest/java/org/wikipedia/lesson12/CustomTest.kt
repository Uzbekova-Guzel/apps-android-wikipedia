package org.wikipedia.lesson12

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.FlakySafetyParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.main.MainActivity

//https://kasperskylab.github.io/Kaspresso/ru/Wiki/Kaspresso_configuration/
abstract class CustomTest(
    kaspressoBuilder: Kaspresso.Builder = Kaspresso.Builder.simple {
        flakySafetyParams = FlakySafetyParams.custom(30000)
    }.apply {
        stepWatcherInterceptors.clear()
//        stepWatcherInterceptors.add()
    }
) : TestCase(kaspressoBuilder) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun verifyConfig() {
        run {
            OnboardingScreen.skipButton.hasText("Continue")
        }
    }
}

class ConfigurationTest : CustomTest(
    Kaspresso.Builder.simple {
        flakySafetyParams = FlakySafetyParams.custom(80000)
    }
)
