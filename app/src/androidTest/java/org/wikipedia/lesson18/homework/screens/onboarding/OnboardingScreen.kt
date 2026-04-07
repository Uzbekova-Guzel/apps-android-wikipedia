package org.wikipedia.lesson18.homework.screens.onboarding

import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.invokeByIndex
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen

object OnboardingScreen : NamedScreen<OnboardingScreen>() {

    override val screenName = "Экран Onboarding"
    override val layoutId = null
    override val viewClass = null

    val skipButton by lazy {
        KButton {
            withId(R.id.fragment_onboarding_skip_button)
        }.name(withParent("Кнопка Skip"))
    }
    val continueButton by lazy {
        KButton {
            withId(R.id.fragment_onboarding_forward_button)
        }.name(withParent("Кнопка Continue"))
    }
    val getStarted by lazy {
        KButton {
            withId(R.id.fragment_onboarding_done_button)
        }.name(withParent("Кнопка Get started"))
    }
    val pager by lazy {
        KViewPager2(
            builder = {
                withId(R.id.fragment_pager)
            },
            itemTypeBuilder = {
                itemType(::PagerItem)
            }
        ).name(withParent("Слайдер"))
    }

    fun page(index: Int, fnc: PagerItem.() -> Unit) {
        pager.invokeByIndex(index, fnc)
    }
}