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

    fun getMenuEl(): WebElement = location.element("menu", home)

    fun getCountryEl(): WebElement = location.element("country", home)

    //TODO: 使用真机再此处出现数字下标越界
    fun getCountryButtonEl(): WebElement = location.elements("country_search_button", home)[1]

    fun getCountryInputEl(): WebElement = location.element("country_search_input", home)

    fun getCountryResultEl(): WebElement = location.element("country_search_result", home)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var android: MobileDriver<*>? = Driver.instance!!.driver()
            var homePage = HomePage(android!!)
            homePage.getSkipEl().click()
            System.setProperty("site", "hk")
            var site = "HK"
            if (homePage.getCountryEl().text != site) {
                homePage.getCountryEl().click()
                homePage.getCountryButtonEl().click()
                homePage.getCountryInputEl().sendKeys("Hong Kong")
                homePage.getCountryResultEl().click()
            }
            Thread.sleep(6000)
            android.quit()
        }
    }

}
