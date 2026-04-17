package org.wikipedia.lesson20.homework.extentions

import io.github.kakaocup.kakao.common.views.KBaseView
import org.wikipedia.lesson20.homework.utils.MultiAction

fun KBaseView<*>.multiAction() {
    view.perform(MultiAction("On"))
}

fun KBaseView<*>.multiAction(text: String) {
    view.perform(MultiAction(text))
}