package com.jeevic.servlet.demo.engine.mapping;

import jakarta.servlet.Servlet;

/**
 * @className: com.jeevic.servlet.demo.engine.mapping -> ServletMapping
 * @description:
 * @author: jeevi
 * @createDate: 2023/12/18 20:57
 * @version: 1.0
 */
public class ServletMapping extends AbstractMapping{
    public final Servlet servlet;

    public ServletMapping(String urlPattern, Servlet servlet) {
        super(urlPattern);
        this.servlet = servlet;
    }
}
