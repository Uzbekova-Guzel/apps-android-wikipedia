package org.wikipedia.lesson24.screens

import org.wikipedia.compose.uitests.Tags.LANGUAGE_LIST
import org.wikipedia.lesson24.extentions.createLazyList
import org.wikipedia.lesson24.extentions.invokeWithText
import org.wikipedia.lesson24.utils.ComposeNamedScreen

object AddLanguageScreen : ComposeNamedScreen<AddLanguageScreen>() {
    override val screenName = "Экран Add a language"

    val items by lazy {
        createLazyList(
            viewBuilderAction = {
                hasTestTag(LANGUAGE_LIST)
            },
            itemTypeBuilder = {
                itemType(::LanguageItem)
            }
        )
    }

    fun itemWithText(text: String, fnc: LanguageItem.() -> Unit) {
        items.invokeWithText<LanguageItem>(text, fnc)
    }
}