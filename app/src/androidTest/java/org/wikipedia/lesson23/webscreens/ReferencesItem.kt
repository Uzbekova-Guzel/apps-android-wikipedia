package org.wikipedia.lesson23.webscreens

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.lesson23.utils.KWebViewItem
import org.wikipedia.lesson23.webscreens.ArticleScreen.referencesList

class ReferencesItem(kWebView: KWebView, listContainerXpath: String) :
    KWebViewItem(kWebView, listContainerXpath) {
    override val self: KWebViewItem = this

    val index by lazy {
        child("//a[@class='pcs-ref-back-link']")
            .name(withParent("Индекс"))
    }

    val text by lazy {
        child("//div[@class='pcs-ref-body']")
            .name(withParent("Текст"))
    }

    fun item(index: Int, fnc: ReferencesItem.() -> Unit) {
        referencesList.childAt(index, fnc)
    }
}