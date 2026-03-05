package org.wikipedia.lesson08

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher
import org.wikipedia.R

class LanguageItem(matcher: Matcher<View>) : KRecyclerItem<LanguageItem>(matcher),
    TextViewAssertions {
    val languageText = KTextView(matcher) {
        withId(R.id.option_label)
    }
}