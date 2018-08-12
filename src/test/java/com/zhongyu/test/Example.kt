package com.zhongyu.test

import com.zhongyu.Driver
import io.appium.java_client.MobileDriver
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

/**
 * @author ZhongYu
 */
class Example {

    private var driver: MobileDriver<*>? = null

    @BeforeClass
    fun setUp() {
        driver = Driver.instance!!.driver()
    }

    @AfterClass
    fun tearDown() {
        driver!!.quit()
    }

    @Test
    fun open() {
        driver!!.findElementById("tv_skip").click()
    }

}
