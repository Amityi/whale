package com.zhongyu.test

import com.zhongyu.Driver
import com.zhongyu.business.MenuBusiness
import io.appium.java_client.MobileDriver
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

/**
 * @author ZhongYu
 */
class AddressTest {

    private var driver: MobileDriver<*>? = null
    private var menuBusiness: MenuBusiness? = null

    @BeforeMethod
    @Throws(Exception::class)
    fun setUp() {
        driver = Driver.instance!!.driver()
        menuBusiness = driver?.let { MenuBusiness(it) }
    }

    @Test
    fun testAddAddress() {
        menuBusiness!!.addAddress()
    }

    @Test
    fun testDeleteAddress(){

    }

    @Test
    fun testUpdateAddress(){

    }

    @AfterMethod
    @Throws(Exception::class)
    fun tearDown() {
        Thread.sleep(3000)
        driver!!.quit()
    }

}