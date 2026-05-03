package org.wikipedia.lesson24.extentions

import io.github.kakaocup.compose.node.action.NodeActions
import org.wikipedia.lesson18.homework.utils.NameHierarchy
import org.wikipedia.lesson24.utils.ClickIfEnabledAction

private val elements = mutableMapOf<NodeActions, NameHierarchy>()

fun <T : NodeActions> T.name(nameHierarchy: NameHierarchy): T {
    elements[this] = nameHierarchy
    return this
}

fun <T : NodeActions> T.getName(): NameHierarchy {
    return elements[this] ?: NameHierarchy("NO_LABEL", null)
}

fun <T : NodeActions> T.withParent(name: String): NameHierarchy {
    return getName().withParent(name)
}

fun NodeActions.clickIfEnabled() {
    delegate.perform(ClickIfEnabledAction())
}