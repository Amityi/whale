package com.zhongyu.page

import com.zhongyu.utils.Location
import io.appium.java_client.MobileDriver
import org.openqa.selenium.WebElement

/**
 * @author ZhongYu
 */
class AddressPage(driver: MobileDriver<*>) {

    private val location = Location(driver)
    private val address = "address_element"

    fun getCountEl(): List<WebElement> = location.elements("count", address)

    fun getAddAddressEl(): WebElement = location.element("add_button", address)

    fun getDeleteEl(): WebElement = location.element("delete", address)

    fun getConfirmDelete(): WebElement = location.element("confirm_delete", address)

    fun getFirstNameEl(): WebElement = location.element("first_name", address)

    fun getLastNameEl(): WebElement = location.element("last_name", address)

    fun getAddress1El(): WebElement = location.elements("address1", address)[2]

    fun getAddress2El(): WebElement = location.element("address2", address)

    fun getAreaEl(): WebElement = location.element("area", address)

    fun getCitySelectEl(): WebElement = location.element("city_select", address)

    fun getSelectItemEl(): WebElement = location.element("city_item", address)

    fun getPhoneEl(): WebElement = location.elements("phone", address)[6]

    fun getZipEl(): WebElement = location.element("zip", address)

    fun getSetDefaultAddressEl(): WebElement = location.element("set_default_address", address)

    fun getSaveEl(): WebElement = location.element("save", address)

}