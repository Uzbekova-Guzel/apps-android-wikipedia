package org.wikipedia.lesson24.homework

import org.junit.Test
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.extentions.action
import org.wikipedia.lesson19.homework.utils.BaseTest

class ComposeExampleTests : BaseTest() {

    @Test
    fun newLanguageCanBeAddedTest() {
        run {
            OnboardingScreen.page(0) {
                action.click(addLanguageButton)
            }
        }
    }
}