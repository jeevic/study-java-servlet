package com.jeevic.servlet.demo.engine;

import com.jeevic.servlet.demo.engine.support.Attributes;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

import java.util.Enumeration;

/**
 * @className: com.jeevic.servlet.demo.engine -> HttpSessionImpl
 * @description:
 * @author: jeevi
 * @createDate: 2023/12/26 20:56
 * @version: 1.0
 */
public class HttpSessionImpl implements HttpSession {
    final ServletContextImpl servletContext;

    String sessionId;
    int maxInactiveInterval;
    long creationTime;
    long lastAccessedTime;
    Attributes attributes;

    public HttpSessionImpl(ServletContextImpl servletContext, String sessionId, int interval) {
        this.servletContext = servletContext;
        this.sessionId = sessionId;
        this.creationTime = this.lastAccessedTime = System.currentTimeMillis();
        this.attributes = new Attributes(true);
        setMaxInactiveInterval(interval);
    }

    @Override
    public long getCreationTime() {
        return creationTime;
    }

    @Override
    public String getId() {
        return this.sessionId;
    }

    @Override
    public long getLastAccessedTime() {
        return this.lastAccessedTime;
    }

    @Override
    public ServletContext getServletContext() {
        return this.servletContext;
    }

    @Override
    public void setMaxInactiveInterval(int interval) {
        this.maxInactiveInterval = interval;

    }

    @Override
    public int getMaxInactiveInterval() {
        return this.maxInactiveInterval;
    }

    @Override
    public void invalidate() {
        checkValid();
        this.servletContext.sessionManager.remove(this);
        this.sessionId = null;
    }

    @Override
    public boolean isNew() {
        return this.creationTime == this.lastAccessedTime;
    }

    // attribute operations ///////////////////////////////////////////////////

    @Override
    public Object getAttribute(String name) {
        checkValid();
        return this.attributes.getAttribute(name);
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        checkValid();
        return this.attributes.getAttributeNames();
    }

    @Override
    public void setAttribute(String name, Object value) {
        checkValid();
        if (value == null) {
            removeAttribute(name);
        } else {
            this.attributes.setAttribute(name, value);
        }
    }

    @Override
    public void removeAttribute(String name) {
        checkValid();
        this.attributes.removeAttribute(name);
    }

    void checkValid() {
        if (this.sessionId == null) {
            throw new IllegalStateException("Session is already invalidated.");
        }
    }
}
