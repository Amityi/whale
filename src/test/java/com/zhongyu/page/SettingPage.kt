package com.zhongyu.page

import com.zhongyu.utils.Location
import io.appium.java_client.MobileDriver
import org.openqa.selenium.WebElement

/**
 * @author ZhongYu
 */
class SettingPage(driver: MobileDriver<*>) {

    private val location = Location(driver)
    private val setting = "setting_element"

    fun getChangeCurrencyEl(): WebElement = location.element("change_currency", setting)

    fun getChangePasswordEl(): WebElement = location.element("change_password", setting)

    fun getOldPasswordEl(): WebElement = location.element("old_password", setting)

    fun getNewPasswordEl(): WebElement = location.element("new_password", setting)

    fun getTwoPasswordEl(): WebElement = location.element("two_password", setting)

    fun getSubmitPasswordEl(): WebElement = location.element("submit_password", setting)

}