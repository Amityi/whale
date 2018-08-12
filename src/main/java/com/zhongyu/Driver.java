package com.zhongyu;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author ZhongYu
 */
public class Driver {

    private volatile static Driver singleton;

    public Driver() {

    }

    public static Driver getInstance() {
        if (null == singleton) {
            synchronized (Driver.class) {
                if (null == singleton) {
                    singleton = new Driver();
                }
            }
        }
        return singleton;
    }

    public AndroidDriver android() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "none");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.APP, getApp("zzkko-google-release.apk"));
        capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, false);
        capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, false);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.zzkko");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.zzkko.bussiness.login.ui.WelcomeActivity");
        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    private static File getApp(String name) {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        try {
            return new File(appDir.getCanonicalPath(), name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        AndroidDriver driver = Driver.getInstance().android();
        driver.findElementById("tv_skip").click();
        driver.quit();
    }

}
