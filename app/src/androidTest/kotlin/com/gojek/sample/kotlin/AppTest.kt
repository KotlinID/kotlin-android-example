package com.gojek.sample.kotlin

import junit.framework.Assert.*

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppTest {

    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        val context = InstrumentationRegistry.getTargetContext()
        assertEquals("com.gojek.sample.kotlin", context.packageName)
    }
}