package org.wikipedia.lesson22.screens.navbars

import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen

object ArticleNavBar : NamedScreen<ArticleNavBar>() {

    override val screenName = " Нав бар статьи"
    override val layoutId = null
    override val viewClass = null

    val saveTab by lazy {
        KTextView {
            withId(R.id.page_save)
        }.name(withParent("Таб Save"))
    }

    val languageTab by lazy {
        KTextView {
            withId(R.id.page_language)
        }.name(withParent("Таб Language"))
    }

    val findInArticleTab by lazy {
        KTextView {
            withId(R.id.page_find_in_article)
        }.name(withParent("Таб Find in article"))
    }

    val themeTab by lazy {
        KTextView {
            withId(R.id.page_theme)
        }.name(withParent("Таб Theme"))
    }

    val contentsTab by lazy {
        KTextView {
            withId(R.id.page_contents)
        }.name(withParent("Таб Contents"))
    }
}