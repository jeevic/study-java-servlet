package com.jeevic.servlet.demo.connector;

import com.jeevic.servlet.demo.engine.HttpServletRequestImpl;
import com.jeevic.servlet.demo.engine.HttpServletResponseImpl;
import com.jeevic.servlet.demo.engine.ServletContextImpl;
import com.jeevic.servlet.demo.engine.filter.HelloFilter;
import com.jeevic.servlet.demo.engine.filter.LogFilter;
import com.jeevic.servlet.demo.engine.servlet.HelloServlet;
import com.jeevic.servlet.demo.engine.servlet.IndexServlet;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.List;

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

    final ServletContextImpl servletContext;

    final Duration stopDelay = Duration.ofSeconds(5);

    public  HttpConnector() throws IOException {

        this.servletContext = new ServletContextImpl();
        //initServlets
        this.servletContext.initialize(List.of(IndexServlet.class, HelloServlet.class));
        //initFilters
        this.servletContext.initFilters(List.of(LogFilter.class, HelloFilter.class));


        String host = "0.0.0.0";
        int port = 8080;
        this.httpServer = HttpServer.create(new InetSocketAddress(host, port), 0, "/", this);
        this.httpServer.start();
        logger.info("http server started at {}:{}...", host, port);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        logger.info("{}: {}?{}", exchange.getRequestMethod(), exchange.getRequestURI().getPath(), exchange.getRequestURI().getRawQuery());

        var adapter = new HttpExchangeAdapter(exchange);
        var request = new HttpServletRequestImpl(adapter);
        var response = new HttpServletResponseImpl(adapter);

        // process:
        try {
            this.servletContext.process(request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String html = "<h1>Hello, " + (name == null ? "world" : name) + ".</h1>";
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.write(html);
        pw.close();
    }

    @Override
    public void close() throws Exception {
        httpServer.stop(3);
    }
}
