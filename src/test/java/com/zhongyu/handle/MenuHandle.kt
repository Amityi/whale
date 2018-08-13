package com.zhongyu.handle

import com.zhongyu.page.MenuPage
import io.appium.java_client.MobileDriver

/**
 * @author ZhongYu
 */
class MenuHandle(driver: MobileDriver<*>) {

    private val menuPage: MenuPage = MenuPage(driver)

    fun clickHeard() = menuPage.getHeardEl().click()

}