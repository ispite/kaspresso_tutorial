package com.kaspersky.kaspresso.tutorial

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.tutorial.screen.FlakyScreen
import com.kaspersky.kaspresso.tutorial.screen.MainScreen
import org.junit.Rule
import org.junit.Test

class FlakyScreenTest : TestCase() {

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun test() = run {
        step("Open target screen") {
            MainScreen {
                flakyActivityButton {
                    isVisible()
                    isClickable()
                    click()
                }
            }
        }
        step("Check display elements") {
            FlakyScreen {
                text1.isDisplayed()
                text5.isNotDisplayed()
            }
        }
        step("Check default state") {
            FlakyScreen {
                text1.isVisible()
                text2.isVisible()
                text3.isVisible()
                text4.isVisible()
                text5.isVisible()

                progressBar1.isVisible()
                progressBar2.isVisible()
                progressBar3.isVisible()
                progressBar4.isVisible()
                progressBar5.isVisible()
            }
        }
        step("check first element after loading") {
            FlakyScreen {
                progressBar1.isGone()
                text1.hasText(R.string.text_1)
            }
        }
        step("check second element after loading") {
            FlakyScreen {
                progressBar2.isGone()
                text2.hasText(R.string.text_2)
            }
        }
        step("check third element after loading") {
            FlakyScreen {
                flakySafely(20_000) {
                    progressBar3.isGone()
                    text3.hasText(R.string.text_3)
                    progressBar4.isGone()
                    text4.hasText(R.string.text_4)
                    progressBar5.isGone()
                    text5.hasText(R.string.text_5)
                }
            }
        }
    }
}
