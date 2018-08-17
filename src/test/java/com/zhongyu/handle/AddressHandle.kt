package com.zhongyu.handle

import com.zhongyu.page.AddressPage
import io.appium.java_client.MobileDriver

/**
 * @author ZhongYu
 */
class AddressHandle(driver: MobileDriver<*>) {

    private val addressPage: AddressPage = AddressPage(driver)

    fun clickAddAddress() = addressPage.getAddAddressEl().click()

    fun clickDelete() = addressPage.getDeleteEl().click()

    fun clickConfirmDelete() = addressPage.getConfirmDelete().click()

    fun sendFirstName(firstName: String) = addressPage.getFirstNameEl().sendKeys(firstName)

    fun sendLastName(lastName: String) = addressPage.getLastNameEl().sendKeys(lastName)

    fun sendAddress1(address: String) = addressPage.getAddress1El().sendKeys(address)

    fun sendAddress2(address: String) = addressPage.getAddress2El().sendKeys(address)

    fun sendArea(area: String) = addressPage.getAreaEl().sendKeys(area)

    fun clickSelectCity() = addressPage.getCitySelectEl().click()

    fun clickCityItem() = addressPage.getSelectItemEl().click()

    fun sendPhone(phone: String) = addressPage.getPhoneEl().sendKeys(phone)

    fun sendZip(zip: String) = addressPage.getZipEl().sendKeys(zip)

    fun clickSetDefaultAddress() = addressPage.getSetDefaultAddressEl().click()

    fun clickSave() = addressPage.getSaveEl().click()

}