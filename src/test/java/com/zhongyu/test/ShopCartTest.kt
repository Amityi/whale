package com.zhongyu.test

import com.zhongyu.Driver
import io.appium.java_client.MobileDriver
import org.testng.annotations.BeforeMethod

/**
 * @author ZhongYu
 */
class ShopCartTest {

    private var driver: MobileDriver<*>? = null

    @BeforeMethod
    @Throws(Exception::class)
    fun setUp() {
        driver = Driver.instance!!.driver()
    }

}