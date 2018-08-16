package com.zhongyu.handle

import com.zhongyu.page.DetailPage
import io.appium.java_client.MobileDriver

/**
 * @author ZhongYu
 */
class DetailHandle(driver: MobileDriver<*>) {

    private val detailPage: DetailPage = DetailPage(driver)

    fun clickComment() = detailPage.getCommentEl().click()

    fun clickSize() = detailPage.getSizeEl().click()

    fun clickBuy() = detailPage.getBuyEl().click()

}