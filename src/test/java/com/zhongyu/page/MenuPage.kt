package com.zhongyu.page

import com.zhongyu.utils.Location
import io.appium.java_client.MobileDriver
import org.openqa.selenium.WebElement

/**
 * @author ZhongYu
 */
class MenuPage(driver: MobileDriver<*>) {

    private var location = Location(driver)
    private var menu = "menu_element"

    fun getHeardEl(): WebElement = location.element("heard", menu)

    fun getNickNameEl(): WebElement = location.element("nickname", menu)

    fun getAddressEl(): WebElement = location.element("address", menu)

}