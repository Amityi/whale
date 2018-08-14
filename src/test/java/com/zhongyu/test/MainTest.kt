package com.zhongyu.test

import com.zhongyu.Driver
import com.zhongyu.business.HomeBusiness
import io.appium.java_client.MobileDriver
import org.testng.Reporter
import org.testng.annotations.*

/**
 * @author ZhongYu
 */
class MainTest {

    private var driver: MobileDriver<*>? = null
    private var homeBusiness: HomeBusiness? = null

    @BeforeMethod
    @Throws(Exception::class)
    fun setUp() {
        driver = Driver.instance!!.driver()
        homeBusiness = driver?.let { HomeBusiness(it) }
    }

    @Test(priority = 2, description = "执行登录测试")
    fun loginSuccess() {
        Reporter.log("登录测试")
        homeBusiness!!.toLogin("zhongyu.vip@gmail.com", "Shein12345")
        Thread.sleep(3000)
    }

    @Test(priority = 0)
    fun switchCountry() {
        Reporter.log("切换站点")
        homeBusiness!!.switch()
    }

    @AfterMethod
    @Throws(Exception::class)
    fun tearDown() {
        driver!!.quit()
    }

}