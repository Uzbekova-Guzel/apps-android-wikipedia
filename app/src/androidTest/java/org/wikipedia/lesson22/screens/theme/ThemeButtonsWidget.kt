package org.wikipedia.lesson22.screens.theme

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.withParent
import org.wikipedia.lesson22.utils.KWidget

class ThemeButtonsWidget(builder: ViewBuilder.() -> Unit) : KWidget<ThemeButtonsWidget>(builder) {

    val lightThemeButton by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_light)
        }.name(withParent("Кнопка Light theme"))
    }

    val sepiaThemeButton by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_sepia)
        }.name(withParent("Кнопка Sepia theme"))
    }

    val darkThemeButton by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_dark)
        }.name(withParent("Кнопка Dark theme"))
    }

    val blackThemeButton by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_black)
        }.name(withParent("Кнопка Black theme"))
    }
}