package org.wikipedia.lesson18.homework.screens.explore

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.extentions.withParent

class TopReadRecycler(matcher: Matcher<View>) : KRecyclerItem<TopReadRecycler>(matcher),
    TextViewAssertions {

    val number by lazy {
        KTextView(matcher) {
            withId(R.id.numberView)
        }.name(withParent("Номер"))
    }
    val title by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_title)
        }.name(withParent("Заголовок"))
    }
    val subtitle by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_subtitle)
        }.name(withParent("Подзаголовок"))
    }
    val graph by lazy {
        KView(matcher) {
            withId(R.id.view_list_card_item_graph)
        }.name(withParent("Граф"))
    }
    val pageViews by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_pageviews)
        }.name(withParent("Page views"))
    }
    val image by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_image)
        }.name(withParent("Картинка"))
    }
}