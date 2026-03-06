package org.wikipedia.lesson10.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.kautomator.component.switch.UiSwitchableActions
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson08.homework.ExploreScreen
import org.wikipedia.main.MainActivity

class OnboardingUITest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkOnboardingPagesScreen() {
        run("Проверка отображения всех элементов на страницах  Onboarding") {
            OnboardingUiScreen {
                step("Проверяет отображение элементов на первой странице") {
                    image.isDisplayed()
                    primaryText.containsText("The Free Encyclopedia")
                    secondaryText.containsText("We’ve found the following on your device:")
                    language.containsText("English")
                    addLanguageButton.isDisplayed()
                    skipButton.isDisplayed()
                    pageIndicator.isDisplayed()
                    continueButton.isDisplayed()
                }
                step("Переходит по свайпу на вторую страницу") {
                    swipe.swipeSwitchThumb(UiSwitchableActions.Direction.LEFT)
                }
                step("Проверяет отображение элементов на второй странице") {
                    image.isDisplayed()
                    primaryText.containsText("New ways to explore")
                    secondaryText.containsText("Dive down the Wikipedia")
                    skipButton.isDisplayed()
                    pageIndicator.isDisplayed()
                    continueButton.isDisplayed()
                }
                step("Переходит по клику на Continue на третью страницу") {
                    continueButton.click()
                }
                step("Проверяет отображение элементов на третьей странице") {
                    image.isDisplayed()
                    primaryText.containsText("Reading lists with sync")
                    secondaryText.containsText("Join Wikipedia")
                    skipButton.isDisplayed()
                    pageIndicator.isDisplayed()
                    continueButton.isDisplayed()
                }
                step("Переходит по клику на Continue на последнюю страницу") {
                    continueButton.click()
                }
                step("Проверяет отображение элементов на последней странице") {
                    image.isDisplayed()
                    primaryText.containsText("Data & Privacy")
                    secondaryText.containsText("We believe")
                    skipButton.isDisplayed() //Why?
                    pageIndicator.isDisplayed()
                    getStartedButton.isDisplayed()
                }
            }
        }
    }

    @Test
    fun checkSkipOnOnboardingScreen() {
        run("Проверка скрытия экрана Onboarding по кнопке Skip") {
            step("Нажимает на кнопку Skip") {
                OnboardingUiScreen.skipButton.click()
            }
            step("Проверяет отображение экрана Explore") {
                ExploreScreen.logo.isDisplayed()
            }
        }
    }

    @Test
    fun checkPositiveOnboarding() {
        run("Проверка кнопки Get Started на экране Onboarding") {
            OnboardingUiScreen {
                step("Переходит на последнюю страницу") {
                    continueButton.click()
                    continueButton.click()
                    continueButton.click()
                }
                step("Проверяет отображение кнопки Get Started") {
                    getStartedButton.isDisplayed()
                }
                step("Нажимает кнопку Get Started") {
                    getStartedButton.click()
                }
            }
            step("Проверяет отображение экрана Explore") {
                ExploreScreen.logo.isDisplayed()
            }
        }
    }

    @Test
    fun checkSwipesOnOnboardingscreen() {
        run("Проверка перехода между страницами экрана Onboarding") {
            OnboardingUiScreen {
                step("Переходит по свайпу на вторую страницу") {
                    swipe.swipeSwitchThumb(UiSwitchableActions.Direction.LEFT)
                }
                step("Проверяет отображение заголовка и текста второй страницы") {
                    primaryText.containsText("New ways to explore")
                    secondaryText.containsText("Dive down the Wikipedia")
                }
                step("Переходит по клику на Continue на третью страницу") {
                    continueButton.click()
                }
                step("Проверяет отображение заголовка и текста третьей страницы") {
                    primaryText.containsText("Reading lists with sync")
                    secondaryText.containsText("Join Wikipedia")
                }
                step("Переходит по свайпу на вторую страницу") {
                    swipe.swipeSwitchThumb(UiSwitchableActions.Direction.RIGHT)
                }
                step("Проверяет отображение заголовка и текста второй страницы") {
                    primaryText.containsText("New ways to explore")
                    secondaryText.containsText("Dive down the Wikipedia")
                }
            }
        }
    }
}
