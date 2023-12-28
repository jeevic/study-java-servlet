package com.jeevic.servlet.demo.engine.listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @className: com.jeevic.servlet.demo.engine.listener -> HelloServletContextAttributeListener
 * @description:
 * @author: jeevi
 * @createDate: 2023/12/28 20:43
 * @version: 1.0
 */
@WebListener
public class HelloServletContextAttributeListener implements ServletContextAttributeListener {
    final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        logger.info(">>> ServletContext attribute added: {} = {}", event.getName(), event.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        logger.info(">>> ServletContext attribute removed: {} = {}", event.getName(), event.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        logger.info(">>> ServletContext attribute replaced: {} = {}", event.getName(), event.getValue());
    }

}
