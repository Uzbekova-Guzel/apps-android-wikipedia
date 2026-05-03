package org.wikipedia.lesson24.screens

import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import org.wikipedia.compose.uitests.Tags.CANONICAL_LANGUAGE_NAME
import org.wikipedia.compose.uitests.Tags.LOCALIZED_LANGUAGE_NAME
import org.wikipedia.lesson24.extentions.name
import org.wikipedia.lesson24.extentions.withParent

class LanguageItem(
    semanticNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider? = null
) : KLazyListItemNode<LanguageItem>(semanticNode, semanticsProvider) {

    val localizedName by lazy {
        child<KNode> {
            hasTestTag(LOCALIZED_LANGUAGE_NAME)
        }.name(withParent("Local name"))
    }

    val canonicalName by lazy {
        child<KNode> {
            hasTestTag(CANONICAL_LANGUAGE_NAME)
        }.name(withParent("Canonic name"))
    }
}