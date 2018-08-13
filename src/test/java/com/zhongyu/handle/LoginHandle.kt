package com.zhongyu.handle

import com.zhongyu.page.LoginPage
import io.appium.java_client.MobileDriver

/**
 * @author ZhongYu
 */
class LoginHandle(driver: MobileDriver<*>) {

    private val loginPage: LoginPage = LoginPage(driver)

    fun clickUseLogin() = loginPage.getUseLoginEl().click()

    fun sendEmail(email: String) = loginPage.getEmailEl().sendKeys(email)

    fun sendPassword(password: String) = loginPage.getPasswordEl().sendKeys(password)

    fun clickSubmitButton() = loginPage.getSubmitButtonEl().click()

}