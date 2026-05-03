package org.wikipedia.lesson19.homework.utils

import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.common.actions.BaseActions
import org.wikipedia.lesson18.homework.extentions.getName
import org.wikipedia.lesson23.utils.KWebViewElement
import org.wikipedia.lesson24.extentions.getName

// Шаги действий
class Actions(private val steps: StepDefinitions) : StepsDsl<Actions>() {

    override val self = this

    fun click(element: BaseActions) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }

    fun setState(element: CheckableActions, state: Boolean) {
        steps.setState("Переключает тогл '${element.getName()}' на $state", element, state)
    }

    fun click(element: KWebViewElement) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }

    fun clickIfEnabled(element: NodeActions) {
        steps.clickIfEnabled("Нажимает на '${element.getName()}'", element)
    }
}