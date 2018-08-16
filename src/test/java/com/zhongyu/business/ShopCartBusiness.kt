package com.zhongyu.business

import com.zhongyu.handle.CategoryHandle
import com.zhongyu.handle.DetailHandle
import com.zhongyu.handle.HomeHandle
import io.appium.java_client.MobileDriver

/**
 * @author ZhongYu
 */
class ShopCartBusiness(driver: MobileDriver<*>) {

    private val homeHandle: HomeHandle = HomeHandle(driver)
    private val categoryHandle: CategoryHandle = CategoryHandle(driver)
    private val detailHandle: DetailHandle = DetailHandle(driver)

    fun addToCart(): String {
        //TODO: 需要判断当前使用的语言
        homeHandle.clickSkip()
        homeHandle.clickCategory()
        var count = homeHandle.getBagCount()
        categoryHandle.clickTopsEn()
        categoryHandle.clickTShirtEs()
        categoryHandle.clickThree()
        categoryHandle.clickItem()
//        detailHandle.clickComment()
        detailHandle.clickSize()
        detailHandle.clickBuy()
        return count
    }

    fun count(): String = homeHandle.getBagCount()

}