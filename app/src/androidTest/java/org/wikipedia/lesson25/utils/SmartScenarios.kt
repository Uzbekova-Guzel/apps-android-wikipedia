package org.wikipedia.lesson25.utils

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.wikipedia.lesson25.closebanners.CloseGotIt
import org.wikipedia.lesson25.closebanners.ClosePlayTodayGame

class SmartScenarios(private val testContext: TestContext<*>) {

    fun closePlayTodayGame() = ClosePlayTodayGame(testContext).initBehavior()
    fun closeGotIt() = CloseGotIt(testContext).initBehavior()
}

val TestContext<*>.smartScenarios: SmartScenarios
    get() = SmartScenarios(this)

//@Test
//fun test() {
//    run {
//        // предварительный сценарий
//        smartScenarios.closePlayTodayGame()
//    }
//}