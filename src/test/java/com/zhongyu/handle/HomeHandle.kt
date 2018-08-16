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

    fun getBagCount(): String = homePage.getBagCountEl().text

    fun clickCategory() = homePage.getCategoryEl().click()

    fun clickCountry() = homePage.getCountryEl().click()

    fun getCountryText(): String = homePage.getCountryEl().text

    fun clickCountryButton() = homePage.getCountryButtonEl().click()

    fun sendCountryInfo(country: String) = homePage.getCountryInputEl().sendKeys(country)

    fun selectResultCountry() = homePage.getCountryResultEl().click()

}
