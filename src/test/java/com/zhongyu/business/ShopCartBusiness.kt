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

    private fun init(){
        homeHandle.clickSkip()
        homeHandle.clickCategory()
    }

    fun addToCart(): String {
        init()
        var count = homeHandle.getBagCount()
        //TODO: 需要判断当前使用的语言
        categoryHandle.clickTopsEn()
        categoryHandle.clickTShirtEs()
        categoryHandle.clickThree()
        categoryHandle.clickItem()
//        detailHandle.clickComment()
        detailHandle.clickSize()
        detailHandle.clickBuy()
        return count
    }

    fun buy(){
        init()
        categoryHandle.clickTopsEn()
    }

    fun count(): String = homeHandle.getBagCount()

}
