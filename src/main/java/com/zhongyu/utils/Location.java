package com.zhongyu.utils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import org.ini4j.Ini;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

/**
 * @author ZhongYu
 */
public class Location {

    private MobileDriver driver;

    public Location(MobileDriver driver) {
        this.driver = driver;
    }

    public WebElement element(String key, Object section) {
        Ini ini;
        Ini.Section iniSection;
        try {
            ini = new Ini(new File("src/main/resources/element.ini"));
            if (null == section) iniSection = ini.get("home_element");
            else iniSection = ini.get(section);
        } catch (IOException e) {
            throw new RuntimeException("配置文件未找到！");
        }
        String location = iniSection.get(key);
        if (null == location) {
            throw new RuntimeException("定位元素未找到！");
        } else {
            String by = location.split(">")[0];
            String value = location.split(">")[1];
            switch (by) {
                case "id":
                    return driver.findElementById(value);
                case "class":
                    return driver.findElementByClassName(value);
                case "accessibility":
                    return driver.findElementByAccessibilityId(value);
                case "android_uiautomator":
                    return driver.findElement(MobileBy.AndroidUIAutomator(value));
            }
            return driver.findElementByXPath(key);
        }
    }

}
