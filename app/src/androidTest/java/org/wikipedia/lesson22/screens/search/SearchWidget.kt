package org.wikipedia.lesson22.screens.search

import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.withParent
import org.wikipedia.lesson22.utils.KWidget

class SearchWidget(builder: ViewBuilder.() -> Unit) : KWidget<SearchWidget>(builder) {

    val magnifyIcon by lazy {
        KImageView(matcher) {
            withContentDescription("Search Wikipedia")
        }.name(withParent("Иконка лупы"))
    }

    val text by lazy {
        KTextView(matcher) {
            isInstanceOf(MaterialTextView::class.java)
        }.name(withParent("Текс поиска"))
    }

    val micIcon by lazy {
        KImageView(matcher) {
            withId(R.id.voice_search_button)
        }.name(withParent("Иконка микрофона"))
    }
}