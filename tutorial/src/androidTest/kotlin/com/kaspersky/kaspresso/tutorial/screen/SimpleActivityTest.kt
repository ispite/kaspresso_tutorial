package com.kaspersky.kaspresso.tutorial.screen

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.tutorial.simple.SimpleActivity
import org.junit.Rule
import org.junit.Test

class SimpleActivityTest : TestCase() {

    @get:Rule
    val activityRule = activityScenarioRule<SimpleActivity>()

    @Test
    fun test() {
        SimpleScreen {
            simpleTitle.isVisible()
            inputText.isVisible()
            changeTitleButton.isVisible()
            simpleTitle.hasText("Default title")
            inputText.hasEmptyText()
            inputText.hasHint("input text")
            inputText.replaceText("New title")
            changeTitleButton.click()
            simpleTitle.hasText("New title")
        }
    }
}
