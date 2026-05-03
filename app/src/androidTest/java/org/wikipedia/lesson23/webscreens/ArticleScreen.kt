package org.wikipedia.lesson23.webscreens

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.lesson18.homework.utils.NamedScreen
import org.wikipedia.R
import org.wikipedia.lesson23.utils.KWebViewList
import org.wikipedia.lesson23.extentions.withXPath

object ArticleScreen : NamedScreen<ArticleScreen>() {

    override val screenName = "Экран статьи"
    override val layoutId = null
    override val viewClass = null

    val webView by lazy {
        KWebView {
            withId(R.id.page_web_view)
        }
    }

    val title by lazy {
        webView.withXPath("//h1")
            .name(withParent("Заголовок"))
    }

    val references by lazy {
        webView.withXPath("//*[@id=\"References\"]")
            .name(withParent("References"))
    }

    val referencesList by lazy {
        KWebViewList(webView, "//ol")
            .name(withParent("Список"))
    }
}