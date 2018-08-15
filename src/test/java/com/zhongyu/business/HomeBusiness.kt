package com.zhongyu.business

import com.zhongyu.handle.HomeHandle
import com.zhongyu.utils.AddressUtil
import io.appium.java_client.MobileDriver
import org.slf4j.LoggerFactory

/**
 * @author ZhongYu
 */
class HomeBusiness(driver: MobileDriver<*>) {

    private val homeHandle: HomeHandle = HomeHandle(driver)
    private val logger = LoggerFactory.getLogger(HomeBusiness::class.java)

    fun switch() {
        homeHandle.clickSkip()
        val site = System.getProperty("site")
        val countryName = homeHandle.getCountryText()
        if (countryName != site) {
            logger.info("站点不一致,执行切换站点")
            homeHandle.clickCountry()
            homeHandle.clickCountryButton()
            val country = AddressUtil.instance!!.getInfo(site, "name")
            homeHandle.sendCountryInfo(country)
            homeHandle.selectResultCountry()
            homeHandle.clickCountry()
        } else {
            logger.info("测试站点一致,不需要切换")
        }
    }

}