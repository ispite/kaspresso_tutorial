package com.kaspersky.kaspresso.tutorial

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.tutorial.screen.MainScreen
import com.kaspersky.kaspresso.tutorial.screen.WifiScreen
import org.junit.Rule
import org.junit.Test

class WifiScreenTest : com.kaspersky.kaspresso.testcases.api.testcase.TestCase() {

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun test() = before {
        device.network.toggleWiFi(true)
        device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
    }
        .after {
            device.network.toggleWiFi(true)
            device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
        }
        .run {
            step("Open target screen") {
                MainScreen {
                    wifiActivityButton {
                        isVisible()
                        isClickable()
                        click()
                    }
                }
            }

            WifiScreen {
                step("Check default state") {
                    wifiStatus.hasEmptyText()
                }

                step("Check enabled state") {
                    checkWifiButton.click()
                    wifiStatus.hasText(R.string.enabled_status)
                }

                step("Check disabled state") {
                    device.network.toggleWiFi(false)
                    checkWifiButton.click()
                    wifiStatus.hasText(R.string.disabled_status)
                }

                step("Rotate and check again") {
                    device.exploit.rotate()
                    wifiStatus.hasText(R.string.disabled_status)
                }
            }
        }
}
