package com.zhongyu.page

import com.zhongyu.utils.Location
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileDriver
import org.openqa.selenium.WebElement

/**
 * @author ZhongYu
 */
class MenuPage(private val driver: MobileDriver<*>) {

    private val location = Location(driver)
    private val menu = "menu_element"

    fun getHeardEl(): WebElement = location.element("heard", menu)

    fun getNickNameEl(): WebElement = location.element("nickname", menu)

    fun getAddressEl(): WebElement = location.element("address", menu)

    fun getCurrencyTextEl(currency: String): WebElement = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(resourceId(\"android:id/list\")).scrollIntoView(new UiSelector().text(\"$currency\"))"))

    fun getCurrencyEl(): WebElement = location.element("currency", menu)

    fun getSettingEl(): WebElement = location.element("setting", menu)

}