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

    /**
     * 根据站点使用相对应的语言
     */
    private fun judge() {
        val site = homeHandle.getCountryText()
        if (site == "HK") {
            //汉语
            categoryHandle.clickTopsCn()
            categoryHandle.clickTShirtCn()
        } else if (site == "TW") {
            //台湾没有热销选项
        } else if (site == "ES" || site == "MX") {
            //西语
            categoryHandle.clickTopsEn()
            categoryHandle.clickTShirtEs()
        } else if (site == "FR") {
            //法语
            categoryHandle.clickTopsEn()
        } else {
            //英语
            categoryHandle.clickTopsEn()
            categoryHandle.clickTShirtEn()
        }
    }

    fun addToCart(): String {
        homeHandle.clickSkip()
        homeHandle.clickCategory()
        val count = homeHandle.getBagCount()
        judge()
        categoryHandle.clickThree()
        categoryHandle.clickItem()
//        detailHandle.clickComment()
        detailHandle.clickSize()
        detailHandle.clickBuy()
        return count
    }

    fun buy() {
        homeHandle.clickSkip()
        homeHandle.clickCategory()
        judge()
        categoryHandle.clickThree()
        categoryHandle.clickItem()
//        detailHandle.clickComment()
        detailHandle.clickSize()
        detailHandle.clickBuy()
    }

    fun count(): String = homeHandle.getBagCount()

}
