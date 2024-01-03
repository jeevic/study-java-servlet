package com.jeevic.servlet.demo.connector;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.Headers;

public interface HttpExchangeResponse {

    Headers getResponseHeaders();

    void sendResponseHeaders(int rCode, long responseLength) throws IOException;

    OutputStream getResponseBody();

}
