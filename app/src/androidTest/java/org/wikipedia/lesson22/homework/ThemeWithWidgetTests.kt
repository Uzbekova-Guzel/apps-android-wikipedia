package org.wikipedia.lesson22.homework

import org.junit.Test
import org.wikipedia.lesson18.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.extentions.action
import org.wikipedia.lesson19.homework.extentions.verify
import org.wikipedia.lesson19.homework.utils.BaseTest
import org.wikipedia.lesson22.screens.navbars.ArticleNavBar
import org.wikipedia.lesson22.screens.theme.ThemeBottomsheetScreen

class ThemeWithWidgetTests : BaseTest() {

    @Test
    fun textSizeChangeTest() {
        run {
            action.click(OnboardingScreen.skipButton)
            try {
                action.click(ExploreScreen.closeButton)
            } catch (_: Exception) {
            }
            ExploreScreen.topReadBlock {
                verify.isDisplayed(this)
                item(0) {
                    action.click(this)
                }
            }
            try {
                action.click(ExploreScreen.closeButton)
            } catch (_: Exception) {
            }
            action.click(ArticleNavBar.themeTab)
            ThemeBottomsheetScreen {
                verify.isDisplayed(readingTitle)
            }
        }
    }
}