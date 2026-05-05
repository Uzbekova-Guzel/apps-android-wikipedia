package org.wikipedia.lesson25.tests

import org.junit.Test
import org.wikipedia.lesson18.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.extentions.action
import org.wikipedia.lesson19.homework.extentions.verify
import org.wikipedia.lesson19.homework.utils.BaseTest
import org.wikipedia.lesson22.screens.navbars.ArticleNavBar
import org.wikipedia.lesson22.screens.theme.ThemeBottomsheetScreen

class CloseBannersTest : BaseTest() {

    @Test
    fun closeBannersTest() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                verify.isDisplayed(this)
                item(0) {
                    action.click(this)
                }
            }
            action.click(ArticleNavBar.themeTab)
            ThemeBottomsheetScreen.themeTextSizeWidget {
                verify.isDisplayed(this)
                action.click(increaseSizeButton)
                verify.hasText(sizePercentText, "110%")
                action.click(decreaseSizeButton)
                action.click(decreaseSizeButton)
                verify.hasText(sizePercentText, "90%")
            }
        }
    }
}