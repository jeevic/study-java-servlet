package com.jeevic.servlet.demo.engine.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @className: com.jeevic.servlet.demo.engine.listener -> HelloHttpSessionListener
 * @description:
 * @author: jeevi
 * @createDate: 2023/12/28 20:42
 * @version: 1.0
 */
@WebListener
public class HelloHttpSessionListener implements HttpSessionListener {
    final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info(">>> HttpSession created: {}", se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info(">>> HttpSession destroyed: {}", se.getSession());
    }

}
