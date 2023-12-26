package com.jeevic.servlet.demo.connector;

import com.sun.net.httpserver.Headers;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;

/**
 * @className: com.jeevic.servlet.demo.connector -> HttpExchangeRequest
 * @description: HttpExchangeRequest
 * @author: jeevi
 * @createDate: 2023/12/12 21:03
 * @version: 1.0
 */
public interface HttpExchangeRequest {
    /**
     * 获取请求method
     * @return
     */
    String getRequestMethod();

    URI getRequestURI();

    Headers getRequestHeaders();

    InetSocketAddress getRemoteAddress();

    InetSocketAddress getLocalAddress();

    byte[] getRequestBody() throws IOException;
}
