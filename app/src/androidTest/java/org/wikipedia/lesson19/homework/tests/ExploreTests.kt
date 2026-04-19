package org.wikipedia.lesson19.homework.tests

import org.junit.Test
import org.wikipedia.lesson18.homework.screens.explore.ExploreScreen
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.extentions.action
import org.wikipedia.lesson19.homework.extentions.verify
import org.wikipedia.lesson19.homework.screens.MoreMenuScreen
import org.wikipedia.lesson19.homework.screens.SettingsScreen
import org.wikipedia.lesson19.homework.utils.BaseTest

class ExploreTests : BaseTest() {

    @Test
    fun checkTopReadTest() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                verify.isDisplayed(this)
                item(2) {
                    verify.isDisplayed(image)
                }
            }
        }
    }

    @Test
    fun checkShowLinkPreviewsToggleTest() {
        run {
            action.click(OnboardingScreen.skipButton)
            action.click(ExploreScreen.moreTab)
            action.click(MoreMenuScreen.settingsButton)
            SettingsScreen.showLinkPreviews {
                action.setChecked(switchWidget, false)
                verify.isNotChecked(switchWidget)
            }
        }
    }
}