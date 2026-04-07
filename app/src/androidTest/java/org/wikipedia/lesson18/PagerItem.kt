package org.wikipedia.lesson18

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.extentions.name
import org.wikipedia.lesson18.extentions.withParent

class PagerItem(matcher: Matcher<View>) : KViewPagerItem<PagerItem>(matcher) {

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.imageViewCentered)
        }.name(withParent("Картинка"))
    }
    val title by lazy {
        KTextView(matcher) {
            withId(R.id.primaryTextView)
        }.name(withParent("Заголовок"))
    }

    val addLanguageButton by lazy {
        KButton {
            withId(R.id.addLanguageButton)
        }.name(withParent("Кнопка добавления языка"))
    }

    val languages by lazy {
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.languagesList)
            },
            itemTypeBuilder = {
                itemType(::LanguageItem)
            }
        ).name(withParent("Список языков"))
    }
}