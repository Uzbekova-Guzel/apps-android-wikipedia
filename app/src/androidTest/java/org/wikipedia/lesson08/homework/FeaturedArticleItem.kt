package org.wikipedia.lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class FeaturedArticleItem(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticleItem>(matcher) {
    val menuHeader = KTextView(matcher) {
        withId(R.id.view_card_header_title)
        withText("Featured article")
    }
    val headerIcon = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }
    val articleTitle = KTextView(matcher) {
        withId(R.id.articleTitle)
    }
    val items = KRecyclerView(
        parent = matcher,
        builder = { withId(R.id.view_list_card_list) },
        itemTypeBuilder = {
            itemType(::TopReadRecycler)
        }
    )
    val moreLink = KTextView(matcher) {
        withId(R.id.footerActionButton)
    }
}
