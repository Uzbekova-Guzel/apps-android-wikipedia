package org.wikipedia.lesson22.screens.theme

import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.withParent
import org.wikipedia.lesson22.utils.KWidget

class ThemeButtonsWidget(builder: ViewBuilder.() -> Unit) : KWidget<ThemeButtonsWidget>(builder) {

    val title by lazy {
        KTextView(matcher) {
            withText("Theme")
            isInstanceOf(MaterialTextView::class.java)
        }.name(withParent("Заголовок Theme"))
    }

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

    val matchSystemThemeSwitch by lazy {
        KCheckBox(matcher) {
            withId(R.id.theme_chooser_match_system_theme_switch)
        }.name(withParent("Переключатель Match System theme"))
    }

    val imageDimmingSwitch by lazy {
        KCheckBox(matcher) {
            withId(R.id.theme_chooser_dark_mode_dim_images_switch)
        }.name(withParent("Переключатель Image dimming"))
    }
}