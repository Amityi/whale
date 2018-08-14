package com.zhongyu.business

import com.zhongyu.handle.HomeHandle
import com.zhongyu.handle.MenuHandle
import com.zhongyu.utils.AddressUtil
import io.appium.java_client.MobileDriver

/**
 * @author ZhongYu
 */
class HomeBusiness(driver: MobileDriver<*>) {

    private val homeHandle: HomeHandle = HomeHandle(driver)
    private val menuHandle: MenuHandle = MenuHandle(driver)

    fun login() {
        homeHandle.clickSkip()
        homeHandle.clickMenu()
        menuHandle.clickHeard()
    }

    fun switch() {
        homeHandle.clickSkip()
        val site = System.getProperty("site")
        val alias = AddressUtil.instance!!.getInfo(site, "alias")
        val countryName = homeHandle.getCountryText()
        if (countryName != alias) {
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