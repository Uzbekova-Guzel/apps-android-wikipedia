package org.wikipedia.lesson18.homework.screens.explore

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.extentions.withParent

class DayItem(matcher: Matcher<View>) : KRecyclerItem<DayItem>(matcher) {

    val title by lazy {
        KTextView(matcher) {
            withId(R.id.day_header_text)
        }.name(withParent("Заголовок"))
    }
}