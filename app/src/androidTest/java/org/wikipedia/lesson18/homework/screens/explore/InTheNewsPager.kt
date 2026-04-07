package org.wikipedia.lesson18.homework.screens.explore

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.extentions.withParent

class InTheNewsPager(matcher: Matcher<View>) : KRecyclerItem<InTheNewsPager>(matcher),
    TextViewAssertions {

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.horizontal_scroll_list_item_image)
        }.name(withParent("Картинка"))
    }
    val text by lazy {
        KTextView(matcher) {
            withId(R.id.horizontal_scroll_list_item_text)
        }.name(withParent("Текст"))
    }
}
