package org.wikipedia.lesson22.screens.theme

import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.withParent
import org.wikipedia.lesson22.utils.KWidget

class ReadingFocusModeWidget(builder: ViewBuilder.() -> Unit) : KWidget<ReadingFocusModeWidget>(builder) {

    val icon by lazy {
        KImageView(matcher) {
            isInstanceOf(AppCompatImageView::class.java)
        }.name(withParent("Иконка очков"))
    }

    val switch by lazy {
        KCheckBox(matcher) {
            withId(R.id.theme_chooser_reading_focus_mode_switch)
        }.name(withParent("Переключатель"))
    }
}