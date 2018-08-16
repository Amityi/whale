package com.zhongyu.page

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

    fun getBagCountEl(): WebElement = location.element("bag_count", home)

    fun getCategoryEl(): WebElement = location.elements("category", home)[1]

    fun getCountryEl(): WebElement = location.element("country", home)

    fun getCountryButtonEl(): WebElement = location.element("country_search_button", home)

    fun getCountryInputEl(): WebElement = location.element("country_search_input", home)

    fun getCountryResultEl(): WebElement = location.element("country_search_result", home)

}
