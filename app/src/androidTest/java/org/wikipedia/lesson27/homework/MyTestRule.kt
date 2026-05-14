package org.wikipedia.lesson27.homework

import org.junit.AssumptionViolatedException
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.wikipedia.lesson19.homework.utils.BaseTest

class MyTestRule : TestRule {
    override fun apply(
        base: Statement?,
        description: Description?
    ): Statement? {
        return object : Statement() { // анонимный класс
            override fun evaluate() {
                val deprecated = description?.getAnnotation<Deprecated>(Deprecated::class.java)
                if (deprecated != null) throw AssumptionViolatedException("Test deprecated")
                base?.evaluate()
            }
        }
    }
}

class MyTest() : BaseTest() {

    @Test
    fun firstExampleTest() {}

    @Test
    @Deprecated("Flaky test")
    fun secondExampleTest() {}

    @Test
    fun thirdExampleTest() {}
}