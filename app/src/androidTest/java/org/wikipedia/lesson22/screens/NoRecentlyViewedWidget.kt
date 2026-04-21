package org.wikipedia.lesson22.screens

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.extentions.withParent
import org.wikipedia.lesson22.utils.KWidget

class NoRecentlyViewedWidget(builder: ViewBuilder.() -> Unit) :
    KWidget<NoRecentlyViewedWidget>(builder) {

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.history_empty_image)
        }.name(withParent("Картинка"))
    }

    val title by lazy {
        KTextView(matcher) {
            withId(R.id.history_empty_title)
        }.name(withParent("Заголовок"))
    }

    val text by lazy {
        KTextView(matcher) {
            withId(R.id.history_empty_message)
        }.name(withParent("Текст"))
    }
}