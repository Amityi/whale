package com.zhongyu.page

import com.zhongyu.Driver
import com.zhongyu.utils.Location
import io.appium.java_client.MobileDriver
import org.openqa.selenium.WebElement

/**
 * @author ZhongYu
 */
class HomePage(private val driver: MobileDriver<*>) {

    private var location = Location(driver)
    private var home = "home_element"

    fun getSkipEl(): WebElement = location.element("skip", home)

    fun getMenuEl(): WebElement = location.element("menu", home)

    fun getCountryEl(): WebElement = location.element("country", home)

    fun getCountryButtonEl(): WebElement {
        //TODO: 此处需要等待，因为使用class定位，再拿到标题后就执行了，使用会出现地址下表越界问题
        Thread.sleep(3000)
        return location.elements("country_search_button", home)[1]
    }

    fun getCountryInputEl(): WebElement = location.element("country_search_input", home)

    fun getCountryResultEl(): WebElement = location.element("country_search_result", home)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var android: MobileDriver<*>? = Driver.instance!!.driver()
            var homePage = HomePage(android!!)
            homePage.getSkipEl().click()
            System.setProperty("site", "hk")
            var site = "MX"
            if (homePage.getCountryEl().text != site) {
                homePage.getCountryEl().click()
                homePage.getCountryButtonEl().click()
                homePage.getCountryInputEl().sendKeys("Mexico")
                homePage.getCountryResultEl().click()
            }
            android.quit()
        }
    }

}
