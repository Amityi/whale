package com.zhongyu.handle

import com.zhongyu.page.MenuPage
import io.appium.java_client.MobileDriver

/**
 * @author ZhongYu
 */
class MenuHandle(driver: MobileDriver<*>) {

    private val menuPage: MenuPage = MenuPage(driver)

    fun clickHeard() = menuPage.getHeardEl().click()

    fun getNickname(): String = menuPage.getNickNameEl().getAttribute("text")

    fun clickAddress() = menuPage.getAddressEl().click()

    fun clickCurrency() = menuPage.getCurrencyEl().click()

    fun getCurrencyText() = menuPage.getCurrencyEl().text!!

    fun clickCorrency(currency: String) = menuPage.getCurrencyTextEl(currency).click()

}