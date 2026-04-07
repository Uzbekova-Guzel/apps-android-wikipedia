package org.wikipedia.lesson18.homework.screens.onboarding

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.extentions.withParent

class LanguageItem(matcher: Matcher<View>) : KRecyclerItem<PagerItem>(matcher), TextViewAssertions {

    val languageText by lazy {
        KTextView(matcher) {
            withId(R.id.option_label)
        }.name(withParent("Текст языка"))
    }
}