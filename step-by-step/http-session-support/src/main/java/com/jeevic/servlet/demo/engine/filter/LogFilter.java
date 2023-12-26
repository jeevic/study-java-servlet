package com.jeevic.servlet.demo.engine.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @className: com.jeevic.servlet.demo.engine.filter -> LogFilter
 * @description:
 * @author: jeevi
 * @createDate: 2023/12/25 21:10
 * @version: 1.0
 */
@WebFilter(urlPatterns = "/*")
public class LogFilter implements Filter {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        logger.info("{}: {}", req.getMethod(), req.getRequestURI());
        chain.doFilter(request, response);
    }
}
