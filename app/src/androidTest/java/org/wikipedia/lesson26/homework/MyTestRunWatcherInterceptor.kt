package org.wikipedia.lesson26.homework

import com.kaspersky.kaspresso.interceptors.watcher.testcase.TestRunWatcherInterceptor
import com.kaspersky.kaspresso.logger.UiTestLogger
import com.kaspersky.kaspresso.testcases.models.info.TestInfo

class MyTestRunWatcherInterceptor(
    private val logger: UiTestLogger
) : TestRunWatcherInterceptor {

    override fun onTestStarted(testInfo: TestInfo) {
        logger.section("MY LOG: BEFORE TEST STARTED")
    }

    override fun onBeforeSectionStarted(testInfo: TestInfo) {
        logger.section("MY LOG: BEFORE SECTION STARTED")
    }

    override fun onBeforeSectionFinishedSuccess(testInfo: TestInfo) {
        logger.section("MY LOG: BEFORE SECTION FINISHED SUCCESS")
    }

    override fun onMainSectionStarted(testInfo: TestInfo) {
        logger.section("MY LOG: ON MAIN SECTION STARTED")
    }

    override fun onMainSectionFinishedSuccess(testInfo: TestInfo) {
        logger.section("MY LOG: ON MAIN SECTION FINISHED SUCCESS")
    }

    override fun onAfterSectionStarted(testInfo: TestInfo) {
        logger.section("MY LOG: ON AFTER SECTION STARTED")
    }

    override fun onAfterSectionFinishedSuccess(testInfo: TestInfo) {
        logger.section("MY LOG: ON AFTER SECTION FINISHED SUCCESS")
    }

    override fun onTestFinished(testInfo: TestInfo, success: Boolean) {
        logger.section("MY LOG: ON TEST FINISHED")
    }
}