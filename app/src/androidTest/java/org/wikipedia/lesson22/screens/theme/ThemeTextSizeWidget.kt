package org.wikipedia.lesson22.screens.theme

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.withParent
import org.wikipedia.lesson22.utils.KWidget

class ThemeTextSizeWidget(builder: ViewBuilder.() -> Unit) : KWidget<ThemeTextSizeWidget>(builder) {

    val decreaseSizeButton by lazy {
        KTextView {
            withId(R.id.buttonDecreaseTextSize)
        }.name(withParent("Кнопка уменьшения размера шрифта"))
    }

    val textSizeSeekBar by lazy {
        KSeekBar {
            withId(R.id.text_size_seek_bar)
        }.name(withParent("Бар изменения размера шрифта"))
    }

    val increaseSizeButton by lazy {
        KTextView {
            withId(R.id.buttonIncreaseTextSize)
        }.name(withParent("Кнопка увеличения размера шрифта"))
    }
}
