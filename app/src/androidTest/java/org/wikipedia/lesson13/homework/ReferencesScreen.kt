package org.wikipedia.lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ReferencesScreen : KScreen<ReferencesScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val title = KTextView() {
        withId(R.id.reference_title_text)
    }

    val referenceId = KTextView(){
        withId(R.id.reference_id)
    }

    val referenceText = KTextView(){
        withId(R.id.reference_text)
    }
}