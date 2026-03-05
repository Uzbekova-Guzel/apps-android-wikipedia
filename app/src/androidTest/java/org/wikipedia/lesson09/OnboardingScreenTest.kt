package org.wikipedia.lesson09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.news.NewsCardView
import org.wikipedia.lesson08.LanguageItem
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.lesson08.PagerItem
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.lesson08.homework.InTheNewsItem
import org.wikipedia.lesson08.homework.InTheNewsPager
import org.wikipedia.main.MainActivity

class OnboardingScreenTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkOnboardingScreen() {
        run("Кнопка Skip отображается на экране онбординга") {
            OnboardingScreen {
                step("Проверяет что кнопка Skip отображается") {
                    skipButton.isDisplayed()
                }
                step("Нажимает на кнопку Continue") {
                    continueButton.click()
                }
                step("Проверяет что кнопка Skip отображается") {
                    skipButton.isDisplayed()
                }
            }
        }
    }

    @Test
    fun checkPagerRow() {
        run {
            OnboardingScreen.pager {
                childAt<PagerItem>(0) {
                    image.isDisplayed()
                    languages.childWith<LanguageItem> {
                        containsText("Eng")
                    }.perform {
                        isDisplayed()
                        hasText("1.\t\tEnglish")
                    }
                }
                childAt<PagerItem>(1) {
                    title.containsText("explore")
                }
                childAt<PagerItem>(3) {
                    image.isDisplayed()
                    title.containsText("Data")
                }
            }
        }
    }

    @Test
    fun exploreTest() {
        run("") {
           OnboardingScreen {
               step("Нажимает кнопку Skip") {
                   skipButton.click()
               }
           }
            ExploreScreen.items.childWith<InTheNewsItem> {
                IsInstanceOf(NewsCardView::class.java)
            } perform {
//                header.hasText("In the news")
                pager.childAt<InTheNewsPager>(2) {
                    image.isDisplayed()
                }
            }
        }
    }

}