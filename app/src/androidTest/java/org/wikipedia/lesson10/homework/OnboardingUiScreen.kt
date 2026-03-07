package org.wikipedia.lesson10.homework

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUiScreen : UiScreen<OnboardingUiScreen>() {

    override val packageName = "org.wikipedia.alpha"

    val pager = UiScrollView {
        withId(this@OnboardingUiScreen.packageName, "fragment_pager")
    }
    val image = UiView {
        withId(this@OnboardingUiScreen.packageName, "imageViewCentered")
    }
    val primaryText = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "primaryTextView")
    }
    val secondaryText = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "secondaryTextView")
    }
    val language = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "option_label")
    }
    val addLanguageButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "addLanguageButton")
    }
    val pageIndicator = UiView {
        withId(this@OnboardingUiScreen.packageName, "view_onboarding_page_indicator")
    }
    val continueButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_forward_button")
    }
    val skipButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_skip_button")
    }
    val getStartedButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_done_button")
    }
}
