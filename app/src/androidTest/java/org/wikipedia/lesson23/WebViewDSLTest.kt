package org.wikipedia.lesson23

import org.junit.Test
import org.wikipedia.lesson18.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.extentions.action
import org.wikipedia.lesson19.homework.extentions.verify
import org.wikipedia.lesson19.homework.utils.BaseTest
import org.wikipedia.lesson23.webscreens.ArticleScreen

class WebViewDSLTest : BaseTest() {

    @Test
    fun webViewDSLSampleTest() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                verify.isDisplayed(this)
                item(0) {
                    action.click(this)
                    Thread.sleep(3000)
                }
            }
            try {
                action.click(ExploreScreen.closeButton)
            } catch (_: Exception) {
            }
            ArticleScreen {
                verify.isDisplayed(title)
                action.click(references)
                verify.hasText(references, "References")
                referencesItem(2) {
                    verify.hasText(index, "[2]")
                }

            }
        }
    }
}