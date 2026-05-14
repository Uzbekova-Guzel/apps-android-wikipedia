package org.wikipedia.lesson27

import android.util.Log
import io.qameta.allure.kotlin.AllureId
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class ExampleRule : TestRule {
    override fun apply(
        base: Statement?,
        description: Description?
    ): Statement? {
        Log.i("KASPRESSO", description?.displayName ?: "")
        return object : Statement() { // анонимный класс
            override fun evaluate() {
                val annot = description?.getAnnotation<AllureId>(AllureId::class.java)?.value
                Log.i("KASPRESSO", annot ?: "")
                if (annot !in Config.testCases) throw IllegalArgumentException("Wrong test")
                try {
                    base?.evaluate()
                } catch (e: Throwable) {
                    Log.i("KASPRESSO", e.message ?: "Empty message")
                }
                Log.i("KASPRESSO", "Test rule finished")
            }
        }
    }

//class MyStatement(
//    val base: Statement?,
//    val description: Description?
//) : Statement() {
//    override fun evaluate() {
//        val annot = description?.getAnnotation<AllureId>(AllureId::class.java)?.value
//        Log.i("KASPRESSO", annot ?: "")
//        if(annot !in Config.testCases) throw IllegalArgumentException("Wrong test")
//        try {
//            base?.evaluate()
//        } catch (e: Throwable) {
//            Log.i("KASPRESSO", e.message ?: "Empty message")
//        }
//        Log.i("KASPRESSO", "Test rule finished")
//    }
//
//}

    object Config {
        val testCases = listOf("1", "2", "3")
    }

    class ExampleTest() {

        @get:Rule
        val baseRule = ExampleRule()

        @Test
        @AllureId("4")
        fun exampleTest() {
            Log.i("KASPRESSO", "LOG exampleTest")
            Assert.assertTrue("тут апали", false)
        }
    }
}