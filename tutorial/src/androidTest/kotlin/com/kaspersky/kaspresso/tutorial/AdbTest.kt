package com.kaspersky.kaspresso.tutorial

import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Test

class AdbTest : TestCase() {

    @Test
    fun test() {
        adbServer.performShell("screencap /sdcard/my_screen.png")
        adbServer.performAdb("shell screencap /sdcard/my_screen_shell.png")
    }
}
