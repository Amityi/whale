package com.zhongyu.page

import com.zhongyu.Driver
import com.zhongyu.utils.Location
import io.appium.java_client.MobileDriver
import org.openqa.selenium.WebElement

/**
 * @author ZhongYu
 */
class HomePage(driver: MobileDriver<*>) {

    private var location = Location(driver)
    private var home = "home_element"

    fun getSkipEl(): WebElement = location.element("skip", home)

    fun getMenuEL(): WebElement = location.element("menu", home)

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