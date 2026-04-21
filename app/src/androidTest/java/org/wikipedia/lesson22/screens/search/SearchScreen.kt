package org.wikipedia.lesson22.screens.search

import androidx.appcompat.widget.AppCompatTextView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.lesson18.homework.utils.NamedScreen
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson22.screens.search.NoRecentlyViewedWidget

object SearchScreen : NamedScreen<SearchScreen>() {

    override val screenName = "Экран Search"
    override val layoutId = null
    override val viewClass = null

    val searchTitle by lazy {
        KTextView {
            withText("Search")
            isInstanceOf(AppCompatTextView::class.java)
        }.name(withParent("Заголовок поиска"))
    }

    val searchWidget by lazy {
        SearchWidget {
            withId(R.id.search_card)
        }.name(withParent("Виджет поиска"))
    }

    val historyTitle by lazy {
        KTextView {
            withId(R.id.history_title)
        }.name(withParent("Заголовок истории"))
    }

    val noRecentlyWidget by lazy {
        NoRecentlyViewedWidget {
            withId(R.id.history_empty_container)
        }.name(withParent("Виджет пустой истории"))
    }
}