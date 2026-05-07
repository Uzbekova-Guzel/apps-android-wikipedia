package org.wikipedia.lesson24.homework

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import io.github.kakaocup.compose.rule.KakaoComposeTestRule
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson18.homework.screens.onboarding.WikipediaLanguagesScreen
import org.wikipedia.lesson19.homework.extentions.action
import org.wikipedia.lesson19.homework.extentions.verify
import org.wikipedia.lesson19.homework.utils.BaseTest
import org.wikipedia.lesson24.screens.AddLanguageScreen
import org.wikipedia.main.MainActivity

class ComposeExampleTests : BaseTest() {

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @get:Rule(order = 2)
    val kakaoRule = KakaoComposeTestRule(composeTestRule, true)

    @Test
    fun newLanguageCanBeAddedTest() {
        run {
            OnboardingScreen.page(0) {
                action.click(addLanguageButton)
            }
            WikipediaLanguagesScreen {
                verify.hasText(title, "Wikipedia languages")
                action.click(addLanguageButton)
            }
            AddLanguageScreen {
                itemWithText("Español") {
                    verify.assertTrimmedTextIsEquals(canonicalName, "Spanish")
                    verify.assertTrimmedTextIsEquals(localizedName, "Español")
                    action.clickIfEnabled(canonicalName)
                }
            }
            action.click(WikipediaLanguagesScreen.backButton)
            OnboardingScreen.page(0) {
                languagesByIndex(2) {
                    verify.containsText(this, "Español")
                }
            }
        }
    }
}