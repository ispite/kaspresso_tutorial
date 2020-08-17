package com.kaspresky.adbserver.log

import com.kaspresky.adbserver.log.fulllogger.FullLogger
import com.kaspresky.adbserver.log.fulllogger.FullLoggerFilteringByDeviceProvider
import com.kaspresky.adbserver.log.logger.Logger
import com.kaspresky.adbserver.log.logger.LoggerImpl

/**
 * The singleton to provide Logger interface and to hide an implementation
 */
object LoggerFactory {

    private val fullLogger = FullLoggerFilteringByDeviceProvider()

    fun setRunMode(runMode: String?) {
        if (runMode.equals("debug", true)) {
            fullLogger.setRunMode(FullLogger.LogLevel.DEBUG)
        }
    }

    fun setDesktopName(desktopName: String) {
        fullLogger.setDesktopName(desktopName)
    }

    fun getLogger(tag: String, deviceName: String? = null): Logger =
        LoggerImpl(tag, deviceName,
            fullLogger
        )
}
