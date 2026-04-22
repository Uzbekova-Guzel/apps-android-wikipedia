package org.wikipedia.lesson19.homework.utils

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.text.TextViewAssertions

class StepDefinitions(private val testContext: TestContext<*>) {

    fun click(step: String, element: BaseActions) {
        execute(step) {
            element.click()
        }
    }

    fun setState(step: String, element: CheckableActions, state: Boolean) {
        execute(step) {
            element.setChecked(state)
        }
    }

    fun isDisplayed(step: String, element: BaseAssertions) {
        execute(step) {
            element.isDisplayed()
        }
    }

    fun hasText(step: String, element: TextViewAssertions, text: String, isSubstring: Boolean) {
        execute(step) {
            if (isSubstring) {
                element.containsText(text)
            } else {
                element.hasText(text)
            }
        }
    }

    fun doesNotExist(step: String, element: BaseAssertions) {
        execute(step) {
            element.doesNotExist()
        }
    }

    fun isEnabled(step: String, element: BaseAssertions) {
        execute(step) {
            element.isEnabled()
        }
    }

    fun isDisabled(step: String, element: BaseAssertions) {
        execute(step) {
            element.isDisabled()
        }
    }

    fun isChecked(step: String, element: CheckableAssertions) {
        execute(step) {
            element.isChecked()
        }
    }

    fun isNotChecked(step: String, element: CheckableAssertions) {
        execute(step) {
            element.isNotChecked()
        }
    }

    private fun execute(step: String, fnc: () -> Unit) {
        testContext.step(step) {
            fnc()
        }
    }
}