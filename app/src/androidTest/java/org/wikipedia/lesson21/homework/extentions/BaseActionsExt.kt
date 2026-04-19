package org.wikipedia.lesson21.homework.extentions

import android.view.View
import io.github.kakaocup.kakao.common.actions.BaseActions
import org.wikipedia.lesson21.homework.utils.HasClassOrChildWithClass
import org.wikipedia.lesson21.homework.utils.HasIdOrChildWithIdAction

fun BaseActions.hasIdOrChildWithId(resourceId: Int): Boolean {
    val hasIdOrChildWithIdIdAction = HasIdOrChildWithIdAction(resourceId)
    view.perform(hasIdOrChildWithIdIdAction)
    return hasIdOrChildWithIdIdAction.getResult()
}

fun BaseActions.hasClassOrChildWithClass(clazz: Class<out View>): Boolean {
    val hasClassOrChildWithClass = HasClassOrChildWithClass(clazz)
    view.perform(hasClassOrChildWithClass)
    return hasClassOrChildWithClass.getResult()
}