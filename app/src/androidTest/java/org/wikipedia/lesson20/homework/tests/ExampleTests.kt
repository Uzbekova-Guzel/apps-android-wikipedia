package org.wikipedia.lesson20.homework.tests

import org.junit.Test
import org.wikipedia.lesson18.homework.screens.onboarding.OnboardingScreen
import org.wikipedia.lesson19.homework.screens.MoreMenuScreen
import org.wikipedia.lesson19.homework.screens.SettingsScreen
import org.wikipedia.lesson19.homework.utils.BaseTest
import org.wikipedia.lesson20.homework.extentions.equalsWithTrim
import org.wikipedia.lesson20.homework.extentions.multiAction
import org.wikipedia.lesson22.screens.navbars.MainNavBar

class ExampleTests : BaseTest() {

    @Test
    fun multiActionTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
        }
    }

    @Test
    fun assertionTest() {
        run {
            OnboardingScreen.page(1) {
                title.equalsWithTrim("New ways to explore")
            }
        }
    }

    @Test
    fun hwTests() {
        run {
            OnboardingScreen.skipButton.multiAction()
//            ExploreScreen.searchBlock{
//                searchIcon.multiAction()
//            }
//            SearchScreen.searchText {
//                multiAction("Kotlin")
//                equalsWithTrim("Kotlin")
//            }
//            device.uiDevice.pressBack()
//            device.uiDevice.pressBack()
            MainNavBar.moreTab.multiAction()
            MoreMenuScreen.settingsButton.multiAction()
            SettingsScreen.downloadOnlyOverWiFi{
                switchWidget.multiAction()
                switchWidget.isChecked()
            }
        }
    }
}