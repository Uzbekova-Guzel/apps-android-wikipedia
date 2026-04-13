package org.wikipedia.lesson18.homework.screens.explore

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.lesson18.homework.extentions.invokeWithText
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen

object ExploreScreen : NamedScreen<ExploreScreen>() {

    override val screenName = "Экран Explore"
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val logoIcon by lazy {
        KImageView {
            withId(R.id.main_toolbar_wordmark)
        }.name(withParent("Иконка лого"))
    }
    val retryButton by lazy {
        KButton {
            withId(R.id.view_card_offline_button_retry)
        }.name(withParent("Кнопка Retry"))
    }
    val closeButton by lazy {
        KButton {
            withId(R.id.closeButton)
        }.name(withParent("Кнопка Close"))
    }
    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.feed_view)
            },
            itemTypeBuilder = {
                itemType(::SearchItem)
                itemType(::CustomizeItem)
                itemType(::DayItem)
                itemType(::TopReadItem)
                itemType(::InTheNewsItem)
                itemType(::FeaturedArticleItem)
            }
        ).name(withParent("Список блоков"))
    }

    fun customizeBlock(fnc: CustomizeItem.() -> Unit) {
        items.invokeWithText("Customize", fnc)
    }

    fun topReadBlock(fnc: TopReadItem.() -> Unit) {
        items.invokeWithText("Top read", fnc)
    }
}