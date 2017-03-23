package com.tooploox.iot.firmware.activities

import android.app.Activity
import android.os.Bundle
import com.google.android.things.pio.PeripheralManagerService

/**
 * Maksym Dybarskyi | maksym.dybarskyi@tooploox.com
 * 23/03/2017 13:08
 */
abstract class IotActivity : Activity() {

    protected val peripheralService = PeripheralManagerService()

    abstract fun initPeriphery()
    abstract fun closePeriphery()
    abstract fun doAction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPeriphery()
    }

    override fun onDestroy() {
        super.onDestroy()
        closePeriphery()
    }

    override fun onStart() {
        super.onStart()
        doAction()
    }
}