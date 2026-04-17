package org.wikipedia.lesson19.homework.screens

import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen
import org.wikipedia.R

object MoreMenuScreen : NamedScreen<MoreMenuScreen>() {

    override val screenName = "Меню More"
    override val layoutId = null
    override val viewClass = null

    val settingsButton by lazy {
        KView {
            withId(R.id.main_drawer_settings_container)
        }.name(withParent("Кнопка Settings"))
    }
}