package com.zhongyu.handle

import com.zhongyu.page.SettingPage
import io.appium.java_client.MobileDriver

/**
 * @author ZhongYu
 */
class SettingHandle(driver: MobileDriver<*>) {

    private val settingPage: SettingPage = SettingPage(driver)

    fun clickChangeCurrency() = settingPage.getChangeCurrencyEl().click()

    fun clickChangePassword() = settingPage.getChangePasswordEl().click()

    fun sendOldPassword(oldPassword: String) = settingPage.getOldPasswordEl().sendKeys(oldPassword)

    fun sendNewPassword(newPassword: String) = settingPage.getNewPasswordEl().sendKeys(newPassword)

    fun sendTwoPassword(twoPassword: String) = settingPage.getTwoPasswordEl().sendKeys(twoPassword)

    fun clickSubmitPassword() = settingPage.getSubmitPasswordEl().click()

}