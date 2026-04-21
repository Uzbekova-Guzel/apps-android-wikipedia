package org.wikipedia.lesson22.screens.theme

import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen

object ThemeBottomsheetScreen : NamedScreen<ThemeBottomsheetScreen>() {

    override val screenName = "Боттомшит Theme"
    override val layoutId = null
    override val viewClass = null

    val readingTitle by lazy {
        KTextView {
            withId(R.id.textSettingsCategory)
        }.name(withParent("Заголовок Reading"))
    }

    val sizePercentText by lazy {
        KTextView {
            withId(R.id.text_size_percent)
        }.name(withParent("Процент размера текста"))
    }

    val themeTextSizeWidget by lazy {
        ThemeTextSizeWidget {
//            withId(R.id.readingFocusModeContainer)
        }.name(withParent("Виджет изменения размера шрифта"))
    }

    val serifButton by lazy {
        KButton {
            withId(R.id.button_font_family_serif)
        }.name(withParent("Кнопка serif"))
    }

    val sansSerifButton by lazy {
        KButton {
            withId(R.id.button_font_family_sans_serif)
        }.name(withParent("Кнопка sans-serif"))
    }

    val readingFocusModeWidget by lazy {
        ReadingFocusModeWidget {
            withId(R.id.readingFocusModeContainer)
        }.name(withParent("Виджет Reading focus mode"))
    }

    val focusModeDescription by lazy {
        KTextView {
            withId(R.id.theme_chooser_reading_focus_mode_description)
        }.name(withParent("Описание Reading focus mode"))
    }

    val themeTitle by lazy {
        KTextView {
            withText("Theme")
            isInstanceOf(MaterialTextView::class.java)
        }.name(withParent("Заголовок Theme"))
    }

    val themeButtonsWidget by lazy {
        ThemeButtonsWidget {
//            withId(R.id.readingFocusModeContainer)
        }.name(withParent("Виджет Theme buttons"))
    }

    val matchSystemThemeSwitch by lazy {
        KCheckBox {
            withId(R.id.theme_chooser_match_system_theme_switch)
        }.name(withParent("Переключатель Match System theme"))
    }

    val imageDimmingSwitch by lazy {
        KCheckBox {
            withId(R.id.theme_chooser_dark_mode_dim_images_switch)
        }.name(withParent("Переключатель Image dimming"))
    }
}