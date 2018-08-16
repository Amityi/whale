package com.zhongyu.handle

import com.zhongyu.page.CategoryPage
import io.appium.java_client.MobileDriver

/**
 * @author ZhongYu
 */
class CategoryHandle(driver: MobileDriver<*>) {

    private val categoryPage: CategoryPage = CategoryPage(driver)

    fun clickTopsCn() = categoryPage.getTopsCnEl().click()

    fun clickTopsEn() = categoryPage.getTopsEnEl().click()

    fun clickTShirtCn() = categoryPage.getTShirtCnEl().click()

    fun clickTShirtEn() = categoryPage.getTShirtEnEl().click()

    fun clickTShirtEs() = categoryPage.getTShirtEsEl().click()

    fun clickThree() = categoryPage.getThreeEl().click()

    fun clickItem() = categoryPage.getItemEl().click()

}