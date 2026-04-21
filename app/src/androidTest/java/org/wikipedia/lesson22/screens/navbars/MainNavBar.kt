package org.wikipedia.lesson22.screens.navbars

import io.github.kakaocup.kakao.tabs.KTabLayout
import org.wikipedia.R
import org.wikipedia.lesson18.homework.extentions.name
import org.wikipedia.lesson18.homework.utils.NamedScreen

object MainNavBar : NamedScreen<MainNavBar>() {

    override val screenName = "Нав бар"
    override val layoutId = null
    override val viewClass = null

    val exploreTab by lazy {
        KTabLayout {
            withId(R.id.nav_tab_explore)
        }.name(withParent("Таб Explore"))
    }

    val savedTab by lazy {
        KTabLayout {
            withId(R.id.nav_tab_reading_lists)
        }.name(withParent("Таб Saved"))
    }

    val searchTab by lazy {
        KTabLayout {
            withId(R.id.nav_tab_search)
        }.name(withParent("Таб Search"))
    }

    val activityTab by lazy {
        KTabLayout {
            withId(R.id.nav_tab_edits)
        }.name(withParent("Таб Activity"))
    }

    val moreTab by lazy {
        KTabLayout {
            withId(R.id.nav_tab_more)
        }.name(withParent("Таб More"))
    }
}