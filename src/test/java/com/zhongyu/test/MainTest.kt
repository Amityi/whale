package com.zhongyu.test

import com.zhongyu.Driver
import com.zhongyu.business.HomeBusiness
import com.zhongyu.business.LoginBusiness
import io.appium.java_client.MobileDriver
import org.slf4j.LoggerFactory
import org.testng.Reporter
import org.testng.annotations.*

/**
 * @author ZhongYu
 */
class MainTest {

    private var driver: MobileDriver<*>? = null
    private var homeBusiness: HomeBusiness? = null
    private var loginBusiness: LoginBusiness? = null
    private val logger = LoggerFactory.getLogger(MainTest::class.java)

    @BeforeMethod
    @Throws(Exception::class)
    fun setUp() {
        driver = Driver.instance!!.driver()
        homeBusiness = driver?.let { HomeBusiness(it) }
        loginBusiness = driver?.let { LoginBusiness(it) }
    }

    @Test(priority = 1, description = "执行登录测试")
    fun loginSuccess() {
        logger.info("登录测试")
        loginBusiness!!.toLogin("zhongyu.vip@gmail.com", "Shein12345")
        Thread.sleep(3000)
    }

    @Test(priority = 0)
    fun switchCountry() {
        Reporter.log("切换站点")
        logger.info("切换站点")
        homeBusiness!!.switch()
    }

    @AfterMethod
    @Throws(Exception::class)
    fun tearDown() {
        driver!!.quit()
    }

}