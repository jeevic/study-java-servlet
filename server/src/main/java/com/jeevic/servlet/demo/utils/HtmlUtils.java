package com.jeevic.servlet.demo.utils;

public class HtmlUtils {

    public static String encodeHtml(String s) {
        return s.replace("<", "&lt;").replace(">", "&gt;").replace("&", "&amp;").replace("\"", "&quot;");
    }
}
