package com.zhongyu.page

import com.zhongyu.utils.Location
import io.appium.java_client.MobileDriver
import org.openqa.selenium.WebElement

/**
 * @author ZhongYu
 */
class CategoryPage(driver: MobileDriver<*>) {

    private val location = Location(driver)
    private val category = "category_element"
    private val goods = "goods_element"

    fun getTopsCnEl(): WebElement = location.element("tops_cn", category)

    fun getTopsEnEl(): WebElement = location.element("tops_en", category)

    fun getTShirtCnEl(): WebElement = location.element("t_shirt_cn", category)

    fun getTShirtEnEl(): WebElement = location.element("t_shirt_en", category)

    fun getTShirtEsEl(): WebElement = location.element("t_shirt_es", category)

    fun getThreeEl(): WebElement = location.element("three", goods)

    fun getItemEl(): WebElement = location.elements("item", goods)[2]

}