package org.wikipedia.lesson18.homework.screens.customize

import androidx.appcompat.widget.AppCompatImageButton
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen

object CustomizeScreen : NamedScreen<CustomizeScreen>() {

    override val screenName = "Экран Customize"
    override val layoutId = null
    override val viewClass = null

    val toolbar by lazy {
        KToolbar {
            withId(R.id.toolbar)
        }.name(withParent("Тулбар"))
    }
    val backButton by lazy {
        KImageView {
            withParent {
                withId(R.id.toolbar)
            }
            isInstanceOf(AppCompatImageButton::class.java)
        }.name(withParent("Кнопка Back"))
    }
    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.content_types_recycler)
            },
            itemTypeBuilder = {
                itemType(::CustomizeRecycler)
            }
        ).name(withParent("Список"))
    }
}
