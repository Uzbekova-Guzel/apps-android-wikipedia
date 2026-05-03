package org.wikipedia.lesson24.extentions

import io.github.kakaocup.compose.node.assertion.NodeAssertions
import org.wikipedia.lesson24.utils.TrimmedTextAssertions

fun NodeAssertions.assertTrimmedTextIsEquals(expected: String) {
    delegate.check(TrimmedTextAssertions(expected))
}