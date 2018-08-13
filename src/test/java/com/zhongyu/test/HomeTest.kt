package com.zhongyu.test

import com.zhongyu.Driver
import com.zhongyu.business.HomeBusiness
import io.appium.java_client.MobileDriver
import org.testng.Reporter
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

/**
 * @author ZhongYu
 */
class HomeTest {

    private var homeBusiness: HomeBusiness? = null
    private var driver: MobileDriver<*>? = null

    @BeforeClass
    @Throws(Exception::class)
    fun setUp() {
        driver = Driver.instance!!.driver()
        homeBusiness = driver?.let { HomeBusiness(it) }
    }

    @Test(priority = 0, description = "执行登录测试")
    fun testLogin() {
        Reporter.log("登录测试")
        homeBusiness!!.login()
    }

    @AfterMethod
    @Throws(Exception::class)
    fun tearDown() {
        driver!!.quit()
    }

}