package com.zhongyu.business

import com.zhongyu.handle.LoginHandle
import io.appium.java_client.MobileDriver

/**
 * @author ZhongYu
 */
class LoginBusiness(driver: MobileDriver<*>) {

    private val loginHandle: LoginHandle = LoginHandle(driver)

    fun login(email: String, password: String) {
        loginHandle.clickUseLogin()
        loginHandle.sendEmail(email)
        loginHandle.sendPassword(password)
        loginHandle.clickSubmitButton()
    }

}