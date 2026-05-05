package org.wikipedia.lesson19.homework.utils

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.compose.node.assertion.NodeAssertions
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.text.TextViewActions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson23.utils.KWebViewElement
import org.wikipedia.lesson24.extentions.assertTrimmedTextIsEquals
import org.wikipedia.lesson24.extentions.clickIfEnabled
import org.wikipedia.lesson25.closebanners.CloseGotIt
import org.wikipedia.lesson25.closebanners.ClosePlayTodayGame
import org.wikipedia.lesson25.utils.PassInterferingScreens

class StepDefinitions(private val testContext: TestContext<*>) {

    private val passInterferingScreens = PassInterferingScreens(
        listOf(
            ClosePlayTodayGame(testContext),
            CloseGotIt(testContext)
        )
    )

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

    fun click(step: String, element: KWebViewElement) {
        execute(step) {
            element.performWebViewAction {
                scroll()
                click()
            }
        }
    }

    fun isDisplayed(step: String, element: KWebViewElement) {
        execute(step) {
            element.performWebViewAction {
                scroll()
            }
        }
    }

    fun hasText(step: String, element: KWebViewElement, text: String, isSubstring: Boolean) {
        execute(step) {
            if (isSubstring) {
                element.performWebViewAction {
                    containsText(text)
                }
            } else {
                element.performWebViewAction {
                    hasText(text)
                }
            }
        }
    }

    fun clickIfEnabled(step: String, element: NodeActions) {
        execute(step) {
            element.clickIfEnabled()
        }
    }

    fun assertTrimmedTextIsEquals(step: String, element: NodeAssertions, expected: String) {
        execute(step) {
            element.assertTrimmedTextIsEquals(expected)
        }
    }

    fun click(step: String, element: TextViewActions, text: String) {
        execute(step) {
            element.clickSpanWithText(text)
        }
    }

    private fun execute(step: String, fnc: () -> Unit) {
        testContext.step(step) {
            try {
                fnc()
            } catch (_: Throwable) {
                passInterferingScreens.execute()
                fnc()
            }
        }
    }
}