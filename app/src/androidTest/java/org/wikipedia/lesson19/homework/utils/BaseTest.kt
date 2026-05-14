package org.wikipedia.lesson19.homework.utils

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.components.composesupport.config.ComposeConfig
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.wikipedia.lesson27.ExampleRule
import org.wikipedia.main.MainActivity

abstract class BaseTest : TestCase(
    Kaspresso.Builder.withForcedAllureSupport().apply {
        ComposeConfig.Builder.default(this) {}
    }
) {
    @get:Rule
    val baseRule = ExampleRule()

    @get:Rule(order = 1)
    val testRule = ActivityScenarioRule(MainActivity::class.java)
}