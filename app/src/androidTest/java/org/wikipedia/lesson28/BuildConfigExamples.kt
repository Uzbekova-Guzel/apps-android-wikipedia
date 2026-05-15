package org.wikipedia.lesson28

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import io.github.kakaocup.compose.rule.KakaoComposeTestRule
import org.junit.Rule
import org.junit.Test
import org.wikipedia.BuildConfig
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson18.homework.screens.onboarding.WikipediaLanguagesScreen
import org.wikipedia.lesson19.homework.extentions.action
import org.wikipedia.lesson19.homework.extentions.verify
import org.wikipedia.lesson19.homework.utils.BaseTest
import org.wikipedia.lesson24.screens.AddLanguageScreen
import org.wikipedia.main.MainActivity

val testValue = BuildConfig.DEFAULT_RESTBASE_URI_FORMAT

class ExampleTests : BaseTest() {

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
                itemWithText(BuildConfig.LOCALIZED_LANGUAGE) {
                    verify.assertTrimmedTextIsEquals(canonicalName, BuildConfig.CANONICAL_LANGUAGE)
                    verify.assertTrimmedTextIsEquals(localizedName, BuildConfig.LOCALIZED_LANGUAGE)
                    action.clickIfEnabled(canonicalName)
                }
            }
            action.click(WikipediaLanguagesScreen.backButton)
            OnboardingScreen.page(0) {
                languagesByIndex(1) {
                    verify.containsText(this, BuildConfig.LOCALIZED_LANGUAGE)
                }
            }
        }
    }
}