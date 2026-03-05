package org.wikipedia.lesson08

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class PagerItem(matcher: Matcher<View>) : KViewPagerItem<PagerItem>(matcher) {
    val image = KImageView(matcher) {
        withId(R.id.imageViewCentered)
    }
    val title = KTextView(matcher) {
        withId(R.id.primaryTextView)
    }

    val languages = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.languageList)
        },
        itemTypeBuilder = {
            itemType(::LanguageItem)
        }
    )

    val addLanguageButton = KButton(matcher) {
        withId(R.id.addLanguageButton)
    }
}