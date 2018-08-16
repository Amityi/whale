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

    fun getTopsCnEl(): WebElement = location.element("tops_cn", category)

    fun getTopsEnEl(): WebElement = location.element("tops_en", category)

}