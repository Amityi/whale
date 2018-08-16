package com.zhongyu.business

import com.zhongyu.handle.CategoryHandle
import com.zhongyu.handle.HomeHandle
import io.appium.java_client.MobileDriver

/**
 * @author ZhongYu
 */
class ShopCartBusiness(driver: MobileDriver<*>) {

    private val homeHandle: HomeHandle = HomeHandle(driver)
    private val categoryHandle: CategoryHandle = CategoryHandle(driver)

    fun addToCart() {
        //TODO: 需要判断当前使用的语言
        homeHandle.clickSkip()
        homeHandle.clickCategory()
        categoryHandle.clickTopsEn()
        categoryHandle.clickTShirtEs()
    }

}