package org.wikipedia.lesson28.homework

import io.qameta.allure.kotlin.Description
import org.junit.rules.TestRule
import org.junit.runner.Description as JUnitDescription
import org.junit.runners.model.Statement
import org.wikipedia.BuildConfig

class CustomTestRule : TestRule {
    lateinit var testData: String
    override fun apply(
        base: Statement?,
        description: JUnitDescription?
    ): Statement? {
        return object : Statement() {
            override fun evaluate() {
                val descriptionValue = description?.getAnnotation(Description::class.java)?.value
                testData = if (descriptionValue == "valid") BuildConfig.VALID_QUERY else BuildConfig.INVALID_QUERY
                base?.evaluate()
            }
        }
    }
}