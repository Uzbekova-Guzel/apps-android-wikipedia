package org.wikipedia.lesson21.homework

import org.junit.Test
import org.wikipedia.lesson18.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.extentions.verify
import org.wikipedia.lesson19.homework.screens.MoreMenuScreen
import org.wikipedia.lesson19.homework.screens.SettingsScreen
import org.wikipedia.lesson19.homework.utils.BaseTest
import org.wikipedia.lesson20.homework.extentions.equalsWithTrim
import org.wikipedia.lesson20.homework.extentions.multiAction
import org.wikipedia.lesson22.screens.navbars.MainNavBar

class ExampleTests : BaseTest() {

    @Test
    fun invokeAtIndexAndClassTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
            ExploreScreen.featuredArticle(1) { verify.isDisplayed(this) }
        }
    }

    @Test
    fun invokeAtIndexAndIdTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
            MainNavBar.moreTab.multiAction()
            MoreMenuScreen.settingsButton.multiAction()
            SettingsScreen.switchAtIndex(0) {
                switchWidget.multiAction()
                switchWidget.isChecked()
            }
            SettingsScreen.switchAtIndex(1) {
                titleText.equalsWithTrim("Collapse tables")
            }
        }
    }
}