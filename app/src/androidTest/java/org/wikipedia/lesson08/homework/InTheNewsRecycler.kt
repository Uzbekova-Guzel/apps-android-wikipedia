package org.wikipedia.lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher
import org.wikipedia.R

class InTheNewsRecycler(matcher: Matcher<View>) : KRecyclerItem<InTheNewsRecycler>(matcher),TextViewAssertions {
    val image = KImageView(matcher) {
        withId(R.id.horizontal_scroll_list_item_image)
    }
    val text = KTextView(matcher) {
        withId(R.id.horizontal_scroll_list_item_text)
    }
}
