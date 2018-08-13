package com.zhongyu.test

import com.zhongyu.Driver
import com.zhongyu.business.HomeBusiness
import com.zhongyu.business.LoginBusiness
import io.appium.java_client.MobileDriver
import org.testng.Reporter
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

/**
 * @author ZhongYu
 */
class HomeTest {

    private var driver: MobileDriver<*>? = null
    private var homeBusiness: HomeBusiness? = null
    private var loginBusiness: LoginBusiness? = null

    @BeforeMethod
    @Throws(Exception::class)
    fun setUp() {
        driver = Driver.instance!!.driver()
        homeBusiness = driver?.let { HomeBusiness(it) }
        loginBusiness = driver?.let { LoginBusiness(it) }
    }

    @Test(priority = 10, description = "执行登录测试")
    fun testLogin() {
        Reporter.log("登录测试")
        homeBusiness!!.login()
        loginBusiness!!.login("zhongyu.vip@gmail.com", "Zhongyu1.")
    }

    @Test(priority = 0)
    fun changeCountry() {
        Reporter.log("切换站点")
    }

    @AfterMethod
    @Throws(Exception::class)
    fun tearDown() {
        driver!!.quit()
    }

}