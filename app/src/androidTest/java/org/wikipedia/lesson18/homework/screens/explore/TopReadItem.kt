package org.wikipedia.lesson18.homework.screens.explore

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson08.homework.TopReadRecycler
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.extentions.withParent

class TopReadItem(matcher: Matcher<View>) : KRecyclerItem<TopReadItem>(matcher) {

    val menuHeader by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Заголовок"))
    }
    val headerIcon by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Иконка"))
    }
    val items by lazy {
        KRecyclerView(
            parent = matcher,
            builder = { withId(R.id.view_list_card_list) },
            itemTypeBuilder = {
                itemType(::TopReadRecycler)
            }
        ).name(withParent("Список статей"))
    }
    val moreLink by lazy {
        KTextView(matcher) {
            withId(R.id.footerActionButton)
        }.name(withParent("Кнопка More link"))
    }
}