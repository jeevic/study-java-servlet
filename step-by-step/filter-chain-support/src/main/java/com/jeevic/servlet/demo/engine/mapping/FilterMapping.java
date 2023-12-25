package com.jeevic.servlet.demo.engine.mapping;

import jakarta.servlet.Filter;

/**
 * @className: com.jeevic.servlet.demo.engine.mapping -> FilterMapping
 * @description:
 * @author: jeevi
 * @createDate: 2023/12/25 21:00
 * @version: 1.0
 */
public class FilterMapping extends AbstractMapping{
    public final Filter filter;

    public FilterMapping(String urlPattern, Filter filter) {
        super(urlPattern);
        this.filter = filter;
    }
}
