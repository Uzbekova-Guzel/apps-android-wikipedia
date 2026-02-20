package org.wikipedia.lesson06.homework

import androidx.appcompat.widget.AppCompatImageView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ThemeBottomSheet : KScreen<ThemeBottomSheet>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val settingTitle = KTextView {
        withId(R.id.textSettingsCategory)
    }
    val sizePercentText = KTextView {
        containsText("%")
    }
    val decreaseSizeButton = KTextView {
        withContentDescription(R.string.text_size_decrease)
    }
    val increaseSizeButton = KTextView {
        withContentDescription("Increase text size")
    }
    val textSizeSeekBar = KSeekBar {
        withId(R.id.text_size_seek_bar)
    }
    val serifButton = KButton {
        withId(R.id.button_font_family_serif)
    }
    val sansSerifButton = KButton {
        withTag("sans-serif")
    }
    val glassImage = KImageView {
        withParent {
            withId(R.id.readingFocusModeContainer)
        }
        isInstanceOf(AppCompatImageView::class.java)
    }
    val readingFocusModeSwitch = KSwitch {
        containsText("focus mode")
    }
    val readingFocusModeDescription = KTextView {
        withId(R.id.theme_chooser_reading_focus_mode_description)
    }
    val themeTitle = KTextView {
        withText(R.string.color_theme_select)
    }
    val lightThemeButton = KButton {
        withId(R.id.button_theme_light)
        withBackgroundColor("white")
    }
    val sepiaThemeButton = KButton {
        withBackgroundColor(R.color.beige300)
    }
    val darkThemeButton = KButton {
        withId(R.id.button_theme_dark)
        withBackgroundColor(R.color.gray700)
    }
    val blackThemeButton = KButton {
        withId(R.id.button_theme_black)
        withBackgroundColor("black")
    }
    val systemThemeSwitch = KSwitch {
        withId(R.id.theme_chooser_match_system_theme_switch)
    }
    val imageDimmingSwitch = KSwitch {
        withId(R.string.theme_chooser_dialog_image_dimming_switch_label)
    }
}
