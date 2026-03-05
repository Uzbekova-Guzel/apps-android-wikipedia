package org.wikipedia.lesson08

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.onboarding.OnboardingPageView

object OnboardingScreen : KScreen<OnboardingScreen>() {
    override val layoutId = R.layout.fragment_onboarding_pager
    override val viewClass = OnboardingPageView::class.java

    val pager = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::PagerItem)
        }
    )

    val continueButton = KButton {
        withId(R.id.fragment_onboarding_forward_button)
    }

    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }
}
