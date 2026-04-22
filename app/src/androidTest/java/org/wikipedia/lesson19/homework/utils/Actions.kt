package org.wikipedia.lesson19.homework.utils

import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.common.actions.BaseActions
import org.wikipedia.lesson18.homework.extentions.getName

// Шаги действий
class Actions(private val steps: StepDefinitions) : StepsDsl<Actions>() {

    override val self = this

    fun click(element: BaseActions) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }

    fun setState(element: CheckableActions, state: Boolean) {
        steps.setState("Переключает тогл '${element.getName()}' на $state", element, state)
    }
}