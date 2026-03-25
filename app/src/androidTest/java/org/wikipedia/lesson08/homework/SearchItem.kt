package org.wikipedia.lesson08.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class SearchItem(matcher: Matcher<View>) : KRecyclerItem<SearchItem>(matcher) {
    val searchIcon = KImageView(matcher) {
        withIndex(0) {
            isInstanceOf(AppCompatImageView::class.java)
        }
    }
    val text = KTextView(matcher) {
        withText("Search Wikipedia")
        isInstanceOf(MaterialTextView::class.java)
    }
    val writeTextSearch = KEditText() {
        withId(androidx.appcompat.R.id.search_src_text)
    }
    val voiceIcon = KImageView(matcher) {
        withId(R.id.voice_search_button)
    }
}
