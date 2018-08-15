package com.zhongyu.business

import com.zhongyu.handle.HomeHandle
import com.zhongyu.handle.LoginHandle
import com.zhongyu.handle.MenuHandle
import com.zhongyu.utils.AddressUtil
import io.appium.java_client.MobileDriver

/**
 * @author ZhongYu
 */
class HomeBusiness(driver: MobileDriver<*>) {

    private val homeHandle: HomeHandle = HomeHandle(driver)
    private val menuHandle: MenuHandle = MenuHandle(driver)
    private val loginHandle: LoginHandle = LoginHandle(driver)

    fun toLogin(email: String, password: String) {
        homeHandle.clickSkip()
        homeHandle.clickMenu()
        try {
            menuHandle.getNickname()
        } catch (e: Exception) {
            menuHandle.clickHeard()
            loginHandle.clickUseLogin()
            loginHandle.sendEmail(email)
            loginHandle.clickShowPassword()
            loginHandle.sendPassword(password)
            loginHandle.clickSubmitButton()
        }
    }

    fun switch() {
        homeHandle.clickSkip()
        val site = System.getProperty("site")
        val countryName = homeHandle.getCountryText()
        if (countryName != site) {
            homeHandle.clickCountry()
            homeHandle.clickCountryButton()
            val country = AddressUtil.instance!!.getInfo(site, "name")
            homeHandle.sendCountryInfo(country)
            homeHandle.selectResultCountry()
            homeHandle.clickCountry()
        } else {
            println("国家相匹配,不需要切换")
        }
    }

}