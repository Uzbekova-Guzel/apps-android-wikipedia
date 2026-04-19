package org.wikipedia.lesson19.homework.screens

import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.invokeWithText
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen
import org.wikipedia.lesson21.homework.extentions.invokeAtIndexAndId

object SettingsScreen : NamedScreen<SettingsScreen>() {

    override val screenName = "Экран Settings"
    override val layoutId = null
    override val viewClass = null

    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.recycler_view)
            },
            itemTypeBuilder = {
                itemType(::SettingsItem)
            }
        ).name(withParent("Список настроек"))
    }

    fun showLinkPreviews(fnc: SettingsItem.() -> Unit) {
        items.invokeWithText("Show link previews", fnc)
    }

    fun downloadOnlyOverWiFi(fnc: SettingsItem.() -> Unit) {
        items.invokeWithText("Download only over Wi-Fi", fnc)
    }

    fun switchAtIndex(index: Int, fnc: SettingsItem.() -> Unit) {
        items.invokeAtIndexAndId(
            index,
            0,
            10,
            R.id.switchWidget,
            "$index переключатель",
            fnc
        )
    }
}
