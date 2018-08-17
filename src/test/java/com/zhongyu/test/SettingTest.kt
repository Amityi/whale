package com.zhongyu.test

import com.zhongyu.Driver
import com.zhongyu.business.SettingBusiness
import io.appium.java_client.MobileDriver
import org.slf4j.LoggerFactory
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

/**
 * @author ZhongYu
 */
class SettingTest {

    private var driver: MobileDriver<*>? = null
    private var settingBusiness: SettingBusiness? = null
    private val logger = LoggerFactory.getLogger(MainTest::class.java)

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
    }

}