package com.zhongyu.test

import com.zhongyu.Driver
import com.zhongyu.business.ShopCartBusiness
import io.appium.java_client.MobileDriver
import org.testng.Assert.assertNotEquals
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

/**
 * @author ZhongYu
 */
class ShopCartTest {

    private var driver: MobileDriver<*>? = null
    private var shopCartBusiness: ShopCartBusiness? = null

    @BeforeMethod
    @Throws(Exception::class)
    fun setUp() {
        driver = Driver.instance!!.driver()
        shopCartBusiness = driver?.let { ShopCartBusiness(it) }
    }

    @AfterMethod
    @Throws(Exception::class)
    fun tearDown() {
        Thread.sleep(6000)
        driver!!.quit()
    }

    @Test
    fun testAddCart() {
        var old = shopCartBusiness!!.addToCart()
        var count = shopCartBusiness!!.count()
        assertNotEquals(count, old)
    }

}