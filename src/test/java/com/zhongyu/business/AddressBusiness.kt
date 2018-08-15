package com.zhongyu.business

import com.zhongyu.handle.AddressHandle
import com.zhongyu.handle.HomeHandle
import com.zhongyu.handle.MenuHandle
import io.appium.java_client.MobileDriver
import org.slf4j.LoggerFactory

/**
 * @author ZhongYu
 */
class AddressBusiness(driver: MobileDriver<*>) {

    private val logger = LoggerFactory.getLogger(AddressBusiness::class.java)

    private val homeHandle: HomeHandle = HomeHandle(driver)
    private val menuHandle: MenuHandle = MenuHandle(driver)
    private val addressHandle: AddressHandle = AddressHandle(driver)

    fun addAddress() {
        logger.info("添加收货地址")
        homeHandle.clickSkip()
        homeHandle.clickMenu()
        menuHandle.clickAddress()
        addressHandle.clickAddAddress()
        addressHandle.sendFirstName("宇")
        addressHandle.sendLastName("鐘")
        addressHandle.sendAddress1("灣仔港灣道18號")
        addressHandle.sendAddress2("5506室")
        addressHandle.sendArea("灣仔區")
        addressHandle.clickSelectCity()
        addressHandle.clickCityItem()
        addressHandle.sendPhone("36049915")
        addressHandle.sendZip("12345")
        addressHandle.clickSetDefaultAddress()
        addressHandle.clickSave()
    }

}