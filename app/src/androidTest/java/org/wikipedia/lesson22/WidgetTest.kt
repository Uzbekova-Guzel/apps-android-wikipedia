package org.wikipedia.lesson22

import org.junit.Test
import org.wikipedia.lesson18.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.extentions.action
import org.wikipedia.lesson19.homework.extentions.verify
import org.wikipedia.lesson19.homework.utils.BaseTest

class WidgetTest : BaseTest() {

    @Test
    fun searchWidgetTest() {
        run {
            action.click(OnboardingScreen.skipButton)
            verify {
                ExploreScreen.searchWidget {
                    isDisplayed(this)
                    isDisplayed(magnifyIcon)
                    hasText(text, "Search Wikipedia")
                    isDisplayed(micIcon)
                }
            }
        }
    }
}