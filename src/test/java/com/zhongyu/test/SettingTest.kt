package com.zhongyu.test

import com.zhongyu.Driver
import com.zhongyu.business.SettingBusiness
import io.appium.java_client.AppiumDriver
import org.slf4j.LoggerFactory
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

/**
 * @author ZhongYu
 */
class SettingTest {

    private var driver: AppiumDriver<*>? = null
    private val logger = LoggerFactory.getLogger(MainTest::class.java)
    private var settingBusiness: SettingBusiness? = null

    @BeforeMethod
    @Throws(Exception::class)
    fun setUp() {
        driver = Driver.instance!!.driver()
        settingBusiness = driver?.let { SettingBusiness(it) }
    }

    @AfterMethod
    @Throws(Exception::class)
    fun tearDown() = driver!!.quit()

    @Test
    fun testChangeCurrency() {
        logger.info("更改货币测试")
        settingBusiness!!.changeCurrency()
    }

}