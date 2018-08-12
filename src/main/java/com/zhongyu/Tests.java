package com.zhongyu;

import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;

/**
 * @author ZhongYu
 */
public class Tests {

    public static void main(String[] args) throws IOException {
        Ini ini = new Ini(new File("src/main/resources/element.ini"));
        Ini.Section section = ini.get("home_element");
        System.out.println(section.get("name"));
    }

}
