package com.zhongyu.utils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import org.ini4j.Ini;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author ZhongYu
 */
public class Location {

    private MobileDriver driver;

    public Location(MobileDriver driver) {
        this.driver = driver;
    }

    private String location(String key, Object section) {
        Ini ini;
        Ini.Section iniSection;
        try {
            ini = new Ini(new File("src/main/resources/element.ini"));
            if (null == section) iniSection = ini.get("home_element");
            else iniSection = ini.get(section);
        } catch (IOException e) {
            throw new RuntimeException("配置文件未找到！");
        }
        return iniSection.get(key);
    }

    public WebElement element(String key, Object section) {
        String location = location(key, section);
        String by = location.split(">")[0];
        String value = location.split(">")[1];
        if (null == location) {
            throw new RuntimeException("定位元素未找到！");
        } else {
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

    public List<WebElement> elements(String key, Object section) {
        String location = location(key, section);
        String by = location.split(">")[0];
        String value = location.split(">")[1];
        if (null == location) {
            throw new RuntimeException("定位元素未找到！");
        } else {
            switch (by) {
                case "id":
                    return driver.findElementsById(value);
                case "class":
                    return driver.findElementsByClassName(value);
                case "accessibility":
                    return driver.findElementsByAccessibilityId(value);
                case "android_uiautomator":
                    return driver.findElements(MobileBy.AndroidUIAutomator(value));
            }
            return driver.findElementsByXPath(key);
        }
    }

}
