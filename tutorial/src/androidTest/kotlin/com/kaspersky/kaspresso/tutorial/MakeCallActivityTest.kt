package com.kaspersky.kaspresso.tutorial

import android.media.AudioManager
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.tutorial.screen.MainScreen
import com.kaspersky.kaspresso.tutorial.screen.MakeCallActivityScreen
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class MakeCallActivityTest : TestCase() {

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @get:Rule
    val grantPermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        android.Manifest.permission.CALL_PHONE
    )

    private val phoneNumber = "111"

    @Test
    fun test() = before {

    }.after {
        device.phone.cancelCall(phoneNumber)
    }.run {
        step("Open target screen") {
            MainScreen {
                makeCallActivityButton {
                    isVisible()
                    isClickable()
                    click()
                }
            }
        }
        step("Check default state") {
            MakeCallActivityScreen {
                inputNumber {
                    isVisible()
                    hasHint(R.string.phone_number_hint)
                }
                makeCallButton {
                    isVisible()
                    isClickable()
                }
            }
        }
        step("Try to call") {
            MakeCallActivityScreen {
                inputNumber.replaceText(phoneNumber)
                makeCallButton.click()
            }
        }
        step("Check phone is calling") {
            val audioManger = device.context.getSystemService(AudioManager::class.java)
            flakySafely {
                Assert.assertTrue(audioManger.mode == AudioManager.MODE_IN_CALL)
            }
        }
    }
}
