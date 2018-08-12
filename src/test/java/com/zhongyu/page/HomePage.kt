package com.zhongyu.page

import com.zhongyu.Driver
import io.appium.java_client.MobileDriver
import org.openqa.selenium.WebElement

/**
 * @author ZhongYu
 */
class HomePage(private val driver: MobileDriver<*>) {

    fun getSkipEl(): WebElement = driver.findElementById("tv_skip")

    fun getMenuEL(): WebElement = driver.findElementByAccessibilityId("Open navigation drawer")

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            System.setProperty("platform", "android")
            var android: MobileDriver<*>? = Driver.instance!!.driver()
            var homePage = HomePage(android!!)
            homePage.getSkipEl().click()
            homePage.getMenuEL().click()
            android.quit()
        }
    }

}
