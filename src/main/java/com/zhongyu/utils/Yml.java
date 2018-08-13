package com.zhongyu.utils;

import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;

/**
 * @author ZhongYu
 */
public class Yml {

    private volatile static Yml yml;

    public Yml() {

    }

    public static Yml getInstance() {
        if (null == yml) {
            synchronized (Yml.class) {
                if (null == yml) {
                    yml = new Yml();
                }
            }
        }
        return yml;
    }

    public String location(String key, Object section) {
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

}
