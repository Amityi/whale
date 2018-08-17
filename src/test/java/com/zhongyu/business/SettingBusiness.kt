package com.zhongyu.business

import com.zhongyu.handle.HomeHandle
import com.zhongyu.handle.MenuHandle
import com.zhongyu.handle.SettingHandle
import io.appium.java_client.MobileDriver
import org.slf4j.LoggerFactory

/**
 * @author ZhongYu
 */
class SettingBusiness(driver: MobileDriver<*>) {

    private val logger = LoggerFactory.getLogger(SettingBusiness::class.java)
    private val homeHandle: HomeHandle = HomeHandle(driver)
    private val menuHandle: MenuHandle = MenuHandle(driver)
    private val settingHandle: SettingHandle = SettingHandle(driver)

    private fun init() {
        homeHandle.clickSkip()
        homeHandle.clickMenu()
    }

    fun changeCurrency() {
        init()
        println(menuHandle.getCurrencyText())
        logger.info("更改货币")
        menuHandle.clickCurrency()
        menuHandle.clickCurrency("TRY")
    }

    fun change2Currency(){
        init()
        menuHandle.clickSetting()
        settingHandle.clickChangeCurrency()
        menuHandle.clickCurrency("HKD")
    }

    fun changePassword() {
        init()
        logger.info("修改密码")
        menuHandle.clickSetting()
        settingHandle.clickChangePassword()
        settingHandle.sendOldPassword("Shein12345")
        settingHandle.sendNewPassword("Shein12345")
        settingHandle.sendTwoPassword("Shein12345")
        settingHandle.clickSubmitPassword()
    }

}