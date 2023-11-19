package com.kaspersky.kaspresso.tutorial

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.tutorial.screen.MainScreen
import com.kaspersky.kaspresso.tutorial.screen.SimpleScreen
import org.junit.Rule
import org.junit.Test

class SimpleActivityTest : TestCase() {

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun test() {
        MainScreen {
            simpleActivityButton {
                isVisible()
                isClickable()
                click()
            }
        }
        SimpleScreen {
            simpleTitle.isVisible()
            inputText.isVisible()
            changeTitleButton.isVisible()
            simpleTitle.hasText(R.string.simple_activity_default_title)
            inputText.hasEmptyText()
            inputText.hasHint(R.string.simple_activity_input_hint)
            inputText.replaceText("New title")
            changeTitleButton.click()
            simpleTitle.hasText("New title")
        }
    }
}
