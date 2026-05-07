package org.wikipedia.lesson18.homework.screens.onboarding

import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.invokeAtIndex
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen
import org.wikipedia.settings.languages.WikipediaLanguagesItemView

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

    val languageListTitle by lazy {
        KTextView() {
            withId(R.id.section_header_text)
        }.name(withParent("Заголовок"))
    }

    val items by lazy {
        KRecyclerView(
            builder = { isInstanceOf(WikipediaLanguagesItemView::class.java) },
            itemTypeBuilder = {
                itemType(::WikiLanguageItem)
            }
        ).name(withParent("Список добавленных языков"))
    }

    val plusImage by lazy {
        KImageView() {
            isInstanceOf(AppCompatImageView::class.java)
        }.name(withParent("Картинка Plus"))
    }

    val addLanguageButton by lazy {
        KButton() {
            withText("Add language")
        }.name(withParent("Кнопка Add language"))
    }

    fun item(index: Int, fnc: WikiLanguageItem.() -> Unit) {
        items.invokeAtIndex(index, fnc)
    }
}