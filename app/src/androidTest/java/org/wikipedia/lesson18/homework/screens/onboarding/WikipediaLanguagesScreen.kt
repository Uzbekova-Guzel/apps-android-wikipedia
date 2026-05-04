package org.wikipedia.lesson18.homework.screens.onboarding

import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.screens.customize.CustomizeRecycler
import org.wikipedia.lesson18.homework.utils.NamedScreen

object WikipediaLanguagesScreen : NamedScreen<WikipediaLanguagesScreen>() {

    override val screenName = "Экран Wikipedia Languages"
    override val layoutId = null
    override val viewClass = null

    val backButton by lazy {
        KButton {
            isInstanceOf(AppCompatImageButton::class.java)
        }.name(withParent("Кнопка Back"))
    }

    val title by lazy {
        KTextView {
            withText("Wikipedia languages")
            isInstanceOf(AppCompatTextView::class.java)
        }.name(withParent("Заголовок"))
    }

    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.wikipedia_languages_recycler)
            },
            itemTypeBuilder = {
                itemType(::WikiLanguagesRecycler)
            }
        ).name(withParent("Список добавленных языков"))
    }
}