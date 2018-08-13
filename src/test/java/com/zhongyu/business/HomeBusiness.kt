package com.zhongyu.business

import com.zhongyu.handle.HomeHandle
import io.appium.java_client.MobileDriver

/**
 * @author ZhongYu
 */
class HomeBusiness(driver: MobileDriver<*>) {

    private val homeHandle: HomeHandle = HomeHandle(driver)

    fun login() {
        homeHandle.clickSkip()
        homeHandle.clickMenu()
    }

}