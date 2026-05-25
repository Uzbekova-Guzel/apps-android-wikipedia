package org.wikipedia.lesson28.homework

import io.qameta.allure.kotlin.Description
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.extentions.action
import org.wikipedia.lesson19.homework.extentions.verify
import org.wikipedia.lesson19.homework.screens.SearchScreen
import org.wikipedia.lesson19.homework.utils.BaseTest
import org.wikipedia.lesson20.homework.extentions.multiAction

class BuildConfigTest : BaseTest() {

    @get:Rule
    val customRule = CustomTestRule()

    private fun verifyValidSearch() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen {
                verify.isDisplayed(searchWidget)
                action.click(searchWidget)

            }
            SearchScreen.searchText {
                multiAction(customRule.testData)
            }
            verify.isDisplayed(SearchScreen.searchResults)
        }
    }

    private fun verifyInvalidSearch() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen {
                verify.isDisplayed(searchWidget)
                action.click(searchWidget)

            }
            SearchScreen.searchText {
                multiAction(customRule.testData)
            }
            verify.isDisplayed(SearchScreen.noResults)

        }
    }

    @Test
    @Description("valid")
    fun validSearchTest() {
        verifyValidSearch()
    }

    @Test
    @Description("gfdtrh")
    fun invalidSearchTest() {
        verifyInvalidSearch()
    }
}