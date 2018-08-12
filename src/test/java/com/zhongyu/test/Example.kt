package com.zhongyu.test

import com.zhongyu.Driver
import com.zhongyu.page.HomePage
import io.appium.java_client.MobileDriver
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

/**
 * @author ZhongYu
 */
class Example {

    private var driver: MobileDriver<*>? = null
    private var page: HomePage? = null

    @BeforeClass
    fun setUp() {
        driver = Driver.instance!!.driver()
        page = driver?.let { HomePage(it) }
    }

    @AfterClass
    fun tearDown() {
        driver!!.quit()
    }

    @Test
    fun open() {
        page!!.getSkipEl().click()
        page!!.getMenuEL().click()
    }

}
