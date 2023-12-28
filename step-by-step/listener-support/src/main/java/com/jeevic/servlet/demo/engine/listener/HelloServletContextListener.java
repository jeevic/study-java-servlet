package com.jeevic.servlet.demo.engine.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @className: com.jeevic.servlet.demo.engine.listener -> HelloServletContextListener
 * @description:
 * @author: jeevi
 * @createDate: 2023/12/28 20:44
 * @version: 1.0
 */
@WebListener
public class HelloServletContextListener implements ServletContextListener {
    final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info(">>> ServletContext initialized: {}", sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info(">>> ServletContext destroyed: {}", sce.getServletContext());
    }
}
