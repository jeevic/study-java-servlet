package com.jeevic.servlet.demo.engine.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @className: com.jeevic.servlet.demo.engine.listener -> HelloServletRequestListener
 * @description:
 * @author: jeevi
 * @createDate: 2023/12/28 20:38
 * @version: 1.0
 */
@WebListener
public class HelloServletRequestListener implements ServletRequestListener {
    final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        logger.info(">>> ServletRequest initialized: {}", sre.getServletRequest());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.info(">>> ServletRequest destroyed: {}", sre.getServletRequest());
    }
}
