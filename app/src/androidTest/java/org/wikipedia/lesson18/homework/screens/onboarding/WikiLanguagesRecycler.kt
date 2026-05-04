package org.wikipedia.lesson18.homework.screens.onboarding

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.invokeAtIndex
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.extentions.withParent
import org.wikipedia.settings.languages.WikipediaLanguagesItemView

class WikiLanguagesRecycler(matcher: Matcher<View>) : KRecyclerItem<WikiLanguagesRecycler>(matcher),
    TextViewAssertions {

    val title by lazy {
        KTextView(matcher) {
            withId(R.id.section_header_text)
        }.name(withParent("Заголовок"))
    }

    val items by lazy {
        KRecyclerView(
            parent = matcher,
            builder = { isInstanceOf(WikipediaLanguagesItemView::class.java) },
            itemTypeBuilder = {
                itemType(::WikiLanguageItem)
            }
        ).name(withParent("Список добавленных языков"))
    }

    val plusImage by lazy {
        KTextView(matcher) {
            isInstanceOf(AppCompatImageView::class.java)
        }.name(withParent("Картинка Plus"))
    }

    val addLanguageText by lazy {
        KTextView(matcher) {
            withId(R.id.wiki_language_title)
        }.name(withParent("Текст Add language"))
    }

    fun item(index: Int, fnc: WikiLanguageItem.() -> Unit) {
        items.invokeAtIndex(index, fnc)
    }
}