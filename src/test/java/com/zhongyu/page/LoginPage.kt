package com.zhongyu.page

import com.zhongyu.utils.Location
import io.appium.java_client.MobileDriver
import org.openqa.selenium.WebElement

/**
 * @author ZhongYu
 */
class LoginPage(driver: MobileDriver<*>) {

    private var location = Location(driver)
    private var login = "login_element"

    fun getUseLoginEl(): WebElement = location.elements("use_login", login)[0]

    fun getEmailEl(): WebElement = location.element("email_input", login)

    fun getPasswordEl(): WebElement = location.element("password_input", login)

    fun getShowPasswordEl(): WebElement = location.element("show_password", login)

    fun getSubmitButtonEl(): WebElement = location.element("submit_button", login)

}