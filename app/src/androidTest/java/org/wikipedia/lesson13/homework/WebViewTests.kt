package org.wikipedia.lesson13.homework

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.lesson08.homework.FeaturedArticleItem
import org.wikipedia.main.MainActivity

class WebViewTests : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest() {
        run("Проверка WebView") {
            step("Нажимает Skip на экране онбординга") {
                OnboardingScreen.skipButton.click()
            }
            ExploreScreen.items {
                childWith<FeaturedArticleItem> {
                    isInstanceOf(FeaturedArticleCardView::class.java)
                } perform {
                    step("Переходит к статье из блока Featured Article экрана Explore") {
                        articleTitle.click()
                    }
                }
            }
            ArticleScreen {
                webView {
                    step("Проверяет отображение текста заголовка статьи") {
                        withElement(Locator.CLASS_NAME, "mw-page-title-main") {
                            scroll()
                            hasText("Ethan Hawke")
                        }
                    }
                    step("Скроллить до References и проверяет его текст") {
                        withElement(Locator.ID, "References") {
                            scroll()
                            hasText("References")
                        }
                    }
//                    withElement(Locator.XPATH, "(//img)[1]") {
//                        scroll()
//                        click()
//                    }
                }
            }
        }
    }
}
