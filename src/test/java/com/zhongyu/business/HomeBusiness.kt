package com.zhongyu.business

import com.zhongyu.handle.HomeHandle
import com.zhongyu.handle.MenuHandle
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

}