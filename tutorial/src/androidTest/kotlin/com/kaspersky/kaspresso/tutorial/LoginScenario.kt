package com.kaspersky.kaspresso.tutorial

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.tutorial.screen.LoginScreen
import com.kaspersky.kaspresso.tutorial.screen.MainScreen

class LoginScenario(private val username: String, private val password: String) : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {
        step("Open target screen") {
            MainScreen {
                loginActivityButton {
                    isVisible()
                    isClickable()
                    click()
                }
            }
        }
        LoginScreen {
            step("Check default state") {
                inputUserName {
                    isVisible()
                    hasHint(R.string.login_activity_hint_username)
                }
                inputPassword {
                    isVisible()
                    hasHint(R.string.login_activity_hint_password)
                }
                loginButton {
                    isVisible()
                    isClickable()
                }
            }
            step("Try to login") {
                inputUserName.replaceText(username)
                inputPassword.replaceText(password)
                loginButton.click()
            }
        }
    }
}
