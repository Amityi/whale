package com.zhongyu.test

import com.zhongyu.Driver
import com.zhongyu.business.AddressBusiness
import io.appium.java_client.MobileDriver
import org.slf4j.LoggerFactory
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

/**
 * @author ZhongYu
 */
class AddressTest {

    private var driver: MobileDriver<*>? = null
    private var addressBusiness: AddressBusiness? = null
    private val logger = LoggerFactory.getLogger(AddressTest::class.java)

    @BeforeMethod
    @Throws(Exception::class)
    fun setUp() {
        driver = Driver.instance!!.driver()
        addressBusiness = driver?.let { AddressBusiness(it) }
    }

    @Test(priority = 2)
    fun testAddAddress() {
        addressBusiness!!.addAddress()
    }

    @Test(enabled = false)
    fun testDeleteAddress(){

    }

    @Test(enabled = false)
    fun testUpdateAddress(){

    }

    @AfterMethod
    @Throws(Exception::class)
    fun tearDown() {
        Thread.sleep(3000)
        driver!!.quit()
    }

}