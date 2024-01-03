package com.jeevic.servlet.demo;

import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @className: com.jeevic.servlet.demo -> ConfigTest
 * @description:
 * @author: jeevi
 * @createDate: 2024/1/3 21:05
 * @version: 1.0
 */
class ConfigTest {

    @Test
    void testClassLoader() {
        System.out.println(String.class.getClassLoader()); // null
        System.out.println(DataSource.class.getClassLoader()); // PlatformClassLoader
        System.out.println(ConfigTest.class.getClassLoader()); // AppClassLoader
    }
}
