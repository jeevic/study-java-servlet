package com.jeevic.servlet.demo.connector;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @className: com.jeevic.servlet.demo.connector -> HttpConnector
 * @description: http connector
 * @author: jeevi
 * @createDate: 2023/12/12 20:48
 * @version: 1.0
 */
public class HttpConnector implements HttpHandler, AutoCloseable {


    final Logger logger = LoggerFactory.getLogger(getClass());

    final HttpServer httpServer;

    public  HttpConnector() throws IOException {
        String host = "0.0.0.0";
        int port = 8080;
        this.httpServer = HttpServer.create(new InetSocketAddress(host, port), 0, "/", this);
        this.httpServer.start();
        logger.info("http server started at {}:{}...", host, port);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        logger.info("{}: {}?{}", exchange.getRequestMethod(), exchange.getRequestURI().getPath(), exchange.getRequestURI().getRawQuery());


    }

    @Override
    public void close() throws Exception {
        httpServer.stop(3);
    }
}
