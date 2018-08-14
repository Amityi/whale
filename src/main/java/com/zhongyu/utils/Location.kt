package com.zhongyu.utils

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileDriver
import org.openqa.selenium.WebElement

/**
 * @author ZhongYu
 */
class Location(private val driver: MobileDriver<*>) {

    fun element(key: String, section: Any): WebElement {
        val location = Yml.getInstance().location(key, section)
        val by = location!!.split(">".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0]
        val value = location.split(">".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
        when (by) {
            "id" -> return driver.findElementById(value)
            "class" -> return driver.findElementByClassName(value)
            "accessibility" -> return driver.findElementByAccessibilityId(value)
            "android_uiautomator" -> return driver.findElement(MobileBy.AndroidUIAutomator(value))
        }
        return driver.findElementByXPath(value)
    }

    fun elements(key: String, section: Any): List<WebElement> {
        val location = Yml.getInstance().location(key, section)
        val by = location!!.split(">".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0]
        val value = location.split(">".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
        when (by) {
            "id" -> return driver.findElementsById(value)
            "class" -> return driver.findElementsByClassName(value)
            "accessibility" -> return driver.findElementsByAccessibilityId(value)
            "android_uiautomator" -> return driver.findElements(MobileBy.AndroidUIAutomator(value))
        }
        return driver.findElementsByXPath(value)
    }

}
