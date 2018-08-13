package com.zhongyu.business

import com.zhongyu.handle.MenuHandle
import io.appium.java_client.MobileDriver

/**
 * @author ZhongYu
 */
class MenuBusiness(driver: MobileDriver<*>) {

    private val menuHandle: MenuHandle = MenuHandle(driver)

}