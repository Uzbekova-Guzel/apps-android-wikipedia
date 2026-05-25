package org.wikipedia.lesson19.homework.screens

import io.github.kakaocup.kakao.edit.KEditText
import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen
import org.wikipedia.R

object SearchScreen : NamedScreen<SearchScreen>() {

    override val screenName = "Экран Search"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val backButton by lazy {
        KButton {
            withParent {
                withId(R.id.search_toolbar)
            }
            isInstanceOf(AppCompatImageView::class.java)
        }.name(withParent("Кнопка Back"))
    }

    val searchText by lazy {
        KEditText {
            withId(androidx.appcompat.R.id.search_src_text)
        }.name(withParent("Блок ввода текста"))
    }

    val searchResults by lazy {
        KView{
            withId(R.id.fragment_search_results)
        }.name(withParent("Контейнер результатов"))
    }


    val noResults by lazy {
        KTextView() {
            withId(R.id.search_empty_message)
        }.name(withParent("Текст не найдено"))
    }
}