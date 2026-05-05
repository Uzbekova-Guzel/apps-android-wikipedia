package org.wikipedia.lesson25.closebanners

import com.kaspersky.kaspresso.testcases.core.testcontext.BaseTestContext
import io.qameta.allure.kotlin.Allure
import org.wikipedia.lesson25.utils.ScreenBehaviorBase

class CloseGotIt(testContext: BaseTestContext) : ScreenBehaviorBase(testContext) {

    override val step = "Закрывает блок Got it"
    override val action: Allure.StepContext.() -> Unit = {
        getElementByText("Got it").click()
    }

    override fun isConditionMet(): Boolean {
        return checkScreenByText("Got it")
    }
}