package org.wikipedia.lesson22.screens.theme

import com.google.android.material.R as MaterialR
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen

object ThemeBottomsheetScreen : NamedScreen<ThemeBottomsheetScreen>() {

    override val screenName = "Боттомшит Theme"
    override val layoutId = null
    override val viewClass = null

    val themeTextSizeWidget by lazy {
        ThemeTextSizeWidget {
            withId(MaterialR.id.design_bottom_sheet)
        }.name(withParent("Виджет изменения размера шрифта"))
    }

    val readingFocusModeWidget by lazy {
        ReadingFocusModeWidget {
            withId(MaterialR.id.design_bottom_sheet)
        }.name(withParent("Виджет Reading focus mode"))
    }

    val themeButtonsWidget by lazy {
        ThemeButtonsWidget {
            withId(MaterialR.id.design_bottom_sheet)
        }.name(withParent("Виджет Theme buttons"))
    }
}