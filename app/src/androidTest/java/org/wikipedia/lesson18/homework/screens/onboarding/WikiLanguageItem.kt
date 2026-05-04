package org.wikipedia.lesson18.homework.screens.onboarding

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.extentions.withParent

class WikiLanguageItem(matcher: Matcher<View>) : KRecyclerItem<WikiLanguageItem>(matcher),
    TextViewAssertions {

    val languageOrder by lazy {
        KTextView(matcher) {
            withId(R.id.wiki_language_order)
        }.name(withParent("Номер в списке"))
    }

    val languageCode by lazy {
        KTextView(matcher) {
            withId(R.id.langCodeText)
        }.name(withParent("Код языка"))
    }

    val languageText by lazy {
        KTextView(matcher) {
            withId(R.id.wiki_language_title)
        }.name(withParent("Текст языка"))
    }
}