package org.wikipedia.lesson21

import org.junit.Test
import org.wikipedia.lesson18.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.extentions.verify
import org.wikipedia.lesson19.homework.utils.BaseTest
import org.wikipedia.lesson20.homework.extentions.multiAction

class ExampleTests : BaseTest() {

    @Test
    fun exampleTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
            ExploreScreen.featuredArticle(1) { verify.isDisplayed(this) }
        }
    }
}