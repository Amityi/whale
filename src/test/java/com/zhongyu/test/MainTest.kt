package com.zhongyu.test

import com.zhongyu.Driver
import com.zhongyu.business.HomeBusiness
import io.appium.java_client.MobileDriver
import org.testng.Reporter
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

/**
 * @author ZhongYu
 */
class MainTest {

    private var driver: MobileDriver<*>? = null
    private var homeBusiness: HomeBusiness? = null

    @BeforeClass
    @Throws(Exception::class)
    fun setUp() {
        driver = Driver.instance!!.driver()
        homeBusiness = driver?.let { HomeBusiness(it) }
    }

    @Test(priority = 0)
    fun switchCountry() {
        Reporter.log("切换站点")
        homeBusiness!!.switch()
    }

    @AfterClass
    @Throws(Exception::class)
    fun tearDown() {
        driver!!.quit()
    }

}