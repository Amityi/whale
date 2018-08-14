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

    fun getCountryButtonEl(): WebElement = location.element("country_search_button", home)

    fun getCountryInputEl(): WebElement = location.element("country_search_input", home)

    fun getCountryResultEl(): WebElement = location.element("country_search_result", home)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var android: MobileDriver<*>? = Driver.instance!!.driver()
            var homePage = HomePage(android!!)
            homePage.getSkipEl().click()
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
