package com.zhongyu.page

import com.zhongyu.utils.Location
import io.appium.java_client.MobileDriver
import org.openqa.selenium.WebElement

/**
 * @author ZhongYu
 */
class DetailPage(driver: MobileDriver<*>) {

    private val location = Location(driver)
    private val detail = "details_element"

    fun getCommentEl(): WebElement = location.element("comment", detail)

    fun getSizeEl(): WebElement = location.element("size", detail)

    fun getBuyEl(): WebElement = location.element("buy", detail)

}