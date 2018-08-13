package com.zhongyu.handle

import com.zhongyu.page.HomePage
import io.appium.java_client.MobileDriver

/**
 * @author ZhongYu
 */
class HomeHandle(driver: MobileDriver<*>) {

    private val homePage: HomePage = HomePage(driver)

    fun clickSkip() = homePage.getSkipEl().click()

    fun clickMenu() = homePage.getMenuEl().click()

}
