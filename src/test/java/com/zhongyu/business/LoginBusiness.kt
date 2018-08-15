package com.zhongyu.business

import com.zhongyu.handle.HomeHandle
import com.zhongyu.handle.LoginHandle
import com.zhongyu.handle.MenuHandle
import io.appium.java_client.MobileDriver
import org.slf4j.LoggerFactory

/**
 * @author ZhongYu
 */
class LoginBusiness(driver: MobileDriver<*>) {

    private val homeHandle: HomeHandle = HomeHandle(driver)
    private val menuHandle: MenuHandle = MenuHandle(driver)
    private val loginHandle: LoginHandle = LoginHandle(driver)
    private val logger = LoggerFactory.getLogger(HomeBusiness::class.java)

    fun toLogin(email: String, password: String) {
        homeHandle.clickSkip()
        homeHandle.clickMenu()
        try {
            menuHandle.getNickname()
            logger.info("已经登录...")
        } catch (e: Exception) {
            logger.info("执行登录...")
            menuHandle.clickHeard()
            loginHandle.clickUseLogin()
            loginHandle.sendEmail(email)
            loginHandle.clickShowPassword()
            loginHandle.sendPassword(password)
            loginHandle.clickSubmitButton()
        }
    }

}