package com.jeevic.servlet.demo.connector;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

/**
 * @className: com.jeevic.servlet.demo.connector -> HttpExchangeAdapter
 * @description:
 * @author: jeevi
 * @createDate: 2023/12/12 21:02
 * @version: 1.0
 */
public class HttpExchangeAdapter implements HttpExchangeRequest, HttpExchangeResponse{


    byte[] requestBodyData;

    final HttpExchange exchange;

    public HttpExchangeAdapter(HttpExchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public String getRequestMethod() {
        return this.exchange.getRequestMethod();
    }

    @Override
    public URI getRequestURI() {
        return this.exchange.getRequestURI();
    }

    @Override
    public Headers getRequestHeaders() {
        return this.exchange.getRequestHeaders();
    }

    @Override
    public InetSocketAddress getRemoteAddress() {
        return this.exchange.getRemoteAddress();
    }

    @Override
    public InetSocketAddress getLocalAddress() {
        return this.exchange.getLocalAddress();
    }

    @Override
    public byte[] getRequestBody() throws IOException {
        if (this.requestBodyData == null) {
            try (InputStream input = this.exchange.getRequestBody()) {
                this.requestBodyData = input.readAllBytes();
            }
        }
        return this.requestBodyData;
    }

    @Override
    public Headers getResponseHeaders() {
        return this.exchange.getResponseHeaders();
    }

    @Override
    public void sendResponseHeaders(int rCode, long responseLength) throws IOException {
        this.exchange.sendResponseHeaders(rCode, responseLength);

    }

    @Override
    public OutputStream getResponseBody() {
        return this.exchange.getResponseBody();
    }
}
