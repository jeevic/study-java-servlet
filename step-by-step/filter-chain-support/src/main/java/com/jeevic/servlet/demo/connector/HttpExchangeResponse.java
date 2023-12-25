package com.jeevic.servlet.demo.connector;

import com.sun.net.httpserver.Headers;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @className: com.jeevic.servlet.demo.connector -> HttpExchangeResponse
 * @description: HttpExchangeResponse
 * @author: jeevi
 * @createDate: 2023/12/12 21:06
 * @version: 1.0
 */
public interface HttpExchangeResponse {
    Headers getResponseHeaders();

    void sendResponseHeaders(int rCode, long responseLength) throws IOException;

    OutputStream getResponseBody();
}
