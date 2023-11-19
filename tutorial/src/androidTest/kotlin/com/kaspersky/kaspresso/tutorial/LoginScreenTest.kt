package com.kaspersky.kaspresso.tutorial

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.tutorial.afterlogin.AfterLoginActivity
import com.kaspersky.kaspresso.tutorial.login.LoginActivity
import org.junit.Rule
import org.junit.Test

class LoginScreenTest : TestCase() {

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun loginSuccessfulIfUsernameAndPasswordCorrect() = run {
        val username = "Admin"
        val password = "123456"
        scenario(LoginScenario(username, password))
        step("Check current sreen") {
            device.activities.isCurrent(AfterLoginActivity::class.java)
        }
    }

    @Test
    fun loginUnsuccessfulIfUsernameIncorrect() = run {
        val username = "Ad"
        val password = "123456"
        scenario(LoginScenario(username, password))
        step("Check current sreen") {
            device.activities.isCurrent(LoginActivity::class.java)
        }
    }

    @Test
    fun loginUnsuccessfulIfPasswordIncorrect() = run {
        val username = "Admin"
        val password = "123"
        scenario(LoginScenario(username, password))
        step("Check current sreen") {
            device.activities.isCurrent(LoginActivity::class.java)
        }
    }
}
