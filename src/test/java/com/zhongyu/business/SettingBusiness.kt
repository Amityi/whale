package com.zhongyu.business

import com.zhongyu.handle.HomeHandle
import com.zhongyu.handle.MenuHandle
import io.appium.java_client.MobileDriver
import org.slf4j.LoggerFactory

/**
 * @author ZhongYu
 */
class SettingBusiness(driver: MobileDriver<*>) {

    private val logger = LoggerFactory.getLogger(SettingBusiness::class.java)
    private val homeHandle: HomeHandle = HomeHandle(driver)
    private val menuHandle: MenuHandle = MenuHandle(driver)

    private fun init() {
        homeHandle.clickSkip()
        homeHandle.clickMenu()
    }

    fun changeCurrency() {
        init()
        println(menuHandle.getCurrencyText())
        logger.info("更改货币")
        menuHandle.clickCurrency()
        menuHandle.clickCorrency("TRY")
    }

}