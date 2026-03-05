package org.wikipedia.lesson09.homework

import androidx.test.espresso.action.GeneralLocation
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.announcement.AnnouncementCardView
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.lesson08.homework.CustomizeItem
import org.wikipedia.lesson08.homework.CustomizeRecycler
import org.wikipedia.lesson08.homework.CustomizeScreen
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.lesson08.homework.FeaturedArticleItem
import org.wikipedia.main.MainActivity

class FeaturedArticleTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun hideFeaturedArticleTest() {
        run("Проверка функционала скрытия блока Featured Article") {
            OnboardingScreen {
                step("Нажимает Skip на экране онбординга") {
                    skipButton.click()
                }
            }
            ExploreScreen.items {
                childWith<FeaturedArticleItem> {
                    IsInstanceOf(FeaturedArticleCardView::class.java)
                } perform {
                    step("Проверяет отображение блока Featured Article экрана Explore") {
                        menuHeader.hasText("Featured article")
                    }
                }
                childWith<CustomizeItem> {
                    IsInstanceOf(AnnouncementCardView::class.java)
                } perform {
                    step("Нажимает на кнопку Customize в блоке Customize your Explore feed экрана Explore") {
                        customizeButton.click()
                    }
                }
            }
            CustomizeScreen {
                items {
                    childAt<CustomizeRecycler>(1) {
                        step("Отключает тогл Featured Article") {
                            checkbox.click()
                            checkbox.isNotChecked()
                        }
                    }
                }
                step("Нажимает стрелку назад в верхнем тулбаре") {
                    toolbar.click(GeneralLocation.CENTER_LEFT)
                }
            }
            ExploreScreen {
                step("Проверяет, что блок Featured Article не отображается на экране Explore") {
                    logo.isDisplayed()
                    featuredArticleCard.doesNotExist()
                }
            }
        }
    }
}
