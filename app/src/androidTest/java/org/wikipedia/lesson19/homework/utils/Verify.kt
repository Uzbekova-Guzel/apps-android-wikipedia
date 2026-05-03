package org.wikipedia.lesson19.homework.utils

import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.compose.node.assertion.NodeAssertions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson18.homework.extentions.getName
import org.wikipedia.lesson23.utils.KWebViewElement
import org.wikipedia.lesson24.extentions.getName

// Шаги проверок
class Verify(private val steps: StepDefinitions) : StepsDsl<Verify>() {

    override val self = this

    fun isDisplayed(element: BaseAssertions) {
        steps.isDisplayed(
            "Проверяет, что отображается '${(element as BaseActions).getName()}'",
            element
        )
    }

    fun hasText(element: TextViewAssertions, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${(element as BaseActions).getName()}' эквивалентен '$text'",
            element,
            text,
            false
        )
    }

    fun containsText(element: TextViewAssertions, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${(element as BaseActions).getName()}' содержит подстроку '$text'",
            element,
            text,
            true
        )
    }

    fun doesNotExist(element: BaseAssertions) {
        steps.doesNotExist(
            "Проверяет, что элемент '${(element as BaseActions).getName()}' отсутствует",
            element
        )
    }

    fun isChecked(element: CheckableAssertions) {
        steps.isChecked(
            "Проверяет, что элемент '${(element as BaseActions).getName()}' включен",
            element
        )
    }

    fun isNotChecked(element: CheckableAssertions) {
        steps.isNotChecked(
            "Проверяет, что элемент '${(element as BaseActions).getName()}' выключен",
            element
        )
    }

    fun isEnabled(element: BaseAssertions) {
        steps.isEnabled(
            "Проверяет, что элемент '${(element as BaseActions).getName()}' в состоянии Enabled",
            element
        )
    }

    fun isDisabled(element: BaseAssertions) {
        steps.isDisabled(
            "Проверяет, что элемент '${(element as BaseActions).getName()}' в состоянии Disabled",
            element
        )
    }

    fun isDisplayed(element: KWebViewElement) {
        steps.isDisplayed(
            "Проверяет, что отображается '${element.getName()}'",
            element
        )
    }

    fun hasText(element: KWebViewElement, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${element.getName()}' эквивалентен '$text'",
            element,
            text,
            false
        )
    }

    fun containsText(element: KWebViewElement, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${element.getName()}' содержит подстроку '$text'",
            element,
            text,
            true
        )
    }

    fun assertTrimmedTextIsEquals(element: NodeAssertions, text: String) {
        steps.assertTrimmedTextIsEquals(
            "Проверяет что текст в элементе '${(element as NodeActions).getName()}' эквивалентен '$text'",
            element,
            text
        )
    }
}