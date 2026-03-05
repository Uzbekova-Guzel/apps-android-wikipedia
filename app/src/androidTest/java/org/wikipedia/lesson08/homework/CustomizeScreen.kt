package org.wikipedia.lesson08.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.R

object CustomizeScreen : KScreen<CustomizeScreen>() {
    override val layoutId = null
    override val viewClass = null

    val toolbar = KToolbar {
        withId(R.id.toolbar)
    }

    val items = KRecyclerView(
        builder = {
            withId(R.id.content_types_recycler)
        },
        itemTypeBuilder = {
            itemType(::CustomizeRecycler)
        }
    )
}
