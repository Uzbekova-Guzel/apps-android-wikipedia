package org.wikipedia.lesson20.homework.extentions

import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson20.homework.utils.EqualsWithTrimAssertion

fun TextViewAssertions.equalsWithTrim(expected: String) {
    view.check(EqualsWithTrimAssertion(expected))
}