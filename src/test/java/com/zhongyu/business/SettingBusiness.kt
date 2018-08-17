package com.zhongyu.business

import com.zhongyu.handle.HomeHandle
import io.appium.java_client.MobileDriver
import org.slf4j.LoggerFactory

/**
 * @author ZhongYu
 */
class SettingBusiness(driver: MobileDriver<*>) {

    private val homeHandle: HomeHandle = HomeHandle(driver)
    private val logger = LoggerFactory.getLogger(SettingBusiness::class.java)

    fun changeCurrency(){
        logger.info("更改货币")

    }

}