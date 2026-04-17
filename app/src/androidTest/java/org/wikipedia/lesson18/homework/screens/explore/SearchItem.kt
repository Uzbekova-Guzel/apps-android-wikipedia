package org.wikipedia.lesson18.homework.screens.explore

import android.view.View
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.extentions.withParent

class SearchItem(matcher: Matcher<View>) : KRecyclerItem<SearchItem>(matcher) {

    val searchIcon by lazy {
        KView(matcher) {
            withId(R.id.search_container)
        }.name(withParent("Иконка поиска"))
    }
    val text by lazy {
        KTextView(matcher) {
            withText("Search Wikipedia")
            isInstanceOf(MaterialTextView::class.java)
        }.name(withParent("Текст"))
    }
    val voiceIcon by lazy {
        KImageView(matcher) {
            withId(R.id.voice_search_button)
        }.name(withParent("Иконка микрофона"))
    }
}