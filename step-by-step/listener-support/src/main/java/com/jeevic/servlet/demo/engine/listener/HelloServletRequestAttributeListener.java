package com.jeevic.servlet.demo.engine.listener;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.annotation.WebListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @className: com.jeevic.servlet.demo.engine.listener -> HelloServletRequestAttributeListener
 * @description:
 * @author: jeevi
 * @createDate: 2023/12/28 20:45
 * @version: 1.0
 */
@WebListener
public class HelloServletRequestAttributeListener implements ServletRequestAttributeListener {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        logger.info(">>> ServletRequest attribute added: {} = {}", srae.getName(), srae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        logger.info(">>> ServletRequest attribute removed: {} = {}", srae.getName(), srae.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        logger.info(">>> ServletRequest attribute replaced: {} = {}", srae.getName(), srae.getValue());
    }
}
