package com.kaspersky.kaspresso.tutorial

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.tutorial.screen.AfterLoginScreen
import org.junit.Rule
import org.junit.Test

class AfterLoginScreenTest : TestCase() {

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun test() = run {
        scenario(LoginScenario("Admin", "123456"))
        step("Check default state") {
            AfterLoginScreen {
                title.isVisible()
                title.hasText(R.string.screen_after_login)
            }
        }
    }
}
