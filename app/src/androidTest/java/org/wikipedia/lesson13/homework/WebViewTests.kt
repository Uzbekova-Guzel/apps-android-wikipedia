package org.wikipedia.lesson13.homework

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.OnboardingScreen
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.lesson08.homework.SearchItem
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
            step("Переходит на экран поиска") {
                ExploreScreen.items {
                    childWith<SearchItem> {
                        withDescendant { withContentDescription("Search Wikipedia") }
                    } perform {
                        text.click()
                    }
                }
            }
            step("Ищет в поиске 'kotlin island'") {
//                SearchScreen.searchText.typeText("kotlin island")
            }
            step("Тап по первой статье") {
                device.uiDevice.findObject(UiSelector().text("Kotlin Island")).click()
            }
            step("Закрывает диалог Wiki Games") {
                ExploreScreen.closeButton.click()
            }
            ArticleScreen {
                webView {
                    step("Проверяет отображение текста заголовка статьи") {
                        withElement(Locator.CLASS_NAME, "mw-page-title-main") {
                            scroll()
                            hasText("Kotlin Island")
                        }
                    }
                    step("Скроллит до References, проверяет его текст и разворачивает его") {
                        withElement(Locator.ID, "References") {
                            scroll()
                            hasText("References")
                            click()
                        }
                    }
                    step("Скроллит до 5й ссылки и кликает") {
                        withElement(
                            Locator.XPATH,
                            "//*[@id=\"cite_ref-FOOTNOTEMurray202024-29_5-0\"]/a/span"
                        ) {
                            scroll()
                            click()
                            Thread.sleep(3000)
                        }
                    }
                    step("Проверяет заголовок") {
                        ReferencesScreen.title.hasText("Reference ")
                    }
                    step("Проверяет что ссылка под номером 5") {
                        ReferencesScreen.referenceId.hasText("5.")
                    }
                    step("Выходит на предыдущий экран") {
                        device.uiDevice.pressBack()
                    }
                }
            }
        }
    }
}
