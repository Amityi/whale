package com.zhongyu

import com.zhongyu.utils.AddressUtil
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.Platform
import org.openqa.selenium.remote.DesiredCapabilities
import java.io.File
import java.io.IOException
import java.net.URL
import java.util.concurrent.TimeUnit

/**
 * @author ZhongYu
 */
class Driver {

    private var driver: AppiumDriver<MobileElement>? = null

    fun driver(): AppiumDriver<*>? {
        val capabilities = DesiredCapabilities()
        val site = System.getProperty("site")
        val platform = System.getProperty("platform")
        val address = URL("http://127.0.0.1:4723/wd/hub")
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "none")
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false)
        if (StringUtils.isNotBlank(site) && StringUtils.isNotEmpty(site)) {
            var country = AddressUtil.instance!!.exists(site)
            if (country) {
                capabilities.setCapability(MobileCapabilityType.LANGUAGE, AddressUtil.instance!!.getInfo(site, "language"))
                capabilities.setCapability(MobileCapabilityType.LOCALE, AddressUtil.instance!!.getInfo(site, "locale"))
            } else {
                throw RuntimeException("站点配置未找到!")
            }
        } else {
            capabilities.setCapability(MobileCapabilityType.LANGUAGE, "zh")
            capabilities.setCapability(MobileCapabilityType.LOCALE, "CN")
        }
        driver = if (platform == "iOS") {
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS)
            capabilities.setCapability(MobileCapabilityType.APP, getApp("zzkko-release.app"))
            IOSDriver(address, capabilities)
        } else {
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID)
            capabilities.setCapability(MobileCapabilityType.APP, "https://kaya.oss-cn-shanghai.aliyuncs.com/shein/zzkko-google-release.apk")
            capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, false)
            capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, false)
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.zzkko")
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.zzkko.bussiness.login.ui.WelcomeActivity")
            AndroidDriver(address, capabilities)
        }
        driver!!.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
        return driver
    }

    companion object {

        @Volatile
        private var singleton: Driver? = null

        val instance: Driver?
            get() {
                if (null == singleton) {
                    synchronized(Driver::class.java) {
                        if (null == singleton) {
                            singleton = Driver()
                        }
                    }
                }
                return singleton
            }

        private fun getApp(name: String): File? {
            val classpathRoot = File(System.getProperty("user.dir"))
            val appDir = File(classpathRoot, "apps")
            try {
                return File(appDir.canonicalPath, name)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return null
        }

        @JvmStatic
        fun main(args: Array<String>) {
            System.setProperty("site", "hk")
            val driver = Driver.instance!!.driver()
            driver!!.findElementById("tv_skip").click()
            driver.quit()
        }
    }

}
