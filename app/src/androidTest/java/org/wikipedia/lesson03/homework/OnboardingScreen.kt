package org.wikipedia.lesson03.homework

import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import org.wikipedia.R
import org.wikipedia.views.AppTextView

val onboardingScreen = listOf(
    FrameLayout::class.java,
    R.id.fragment_onboarding_pager_container
)
val globusImage = listOf(
    AppCompatImageView::class.java,
    R.id.imageViewCentered
)
val primaryText = listOf(
    AppTextView::class.java,
    R.id.primaryTextView,
    R.string.onboarding_welcome_title_v2
)
val secondaryText = listOf(
    AppTextView::class.java,
    R.id.secondaryTextView
)
val languageListVContainer = listOf(
    LinearLayout::class.java,
    R.id.languageListContainer
)
val languageItemLabel = listOf(
    AppTextView::class.java,
    R.id.option_label
)
val addLanguageButton = listOf(
    MaterialButton::class.java,
    R.id.addLanguageButton,
    R.string.onboarding_multilingual_add_language_text
)

val pageIndicator = listOf(
    TabLayout::class.java,
    R.id.view_onboarding_page_indicator
)
val skipButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_skip_button,
    R.string.onboarding_skip
)
val continueButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_forward_button,
    R.string.onboarding_continue
)
