package com.zhongyu

import com.zhongyu.utils.Location
import io.appium.java_client.MobileDriver
import org.ini4j.Ini

import java.io.File
import java.io.IOException

/**
 * @author ZhongYu
 */
object Tests {

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        //        Ini ini = new Ini(new File("src/main/resources/element.ini"));
        //        Ini.Section section = ini.get("home_element");
        //        String location = section.get("name");
        //        String by = location.split(">")[0];
        //        String local = location.split(">")[1];
        //        System.out.println(by);
        //        System.out.println(local);
        System.setProperty("platform","android")
        var driver = Driver.instance!!.driver()
        var location = Location(driver)
        location.element("skip", "home_element").click()
    }

}
