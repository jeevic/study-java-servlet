package com.jeevic.servlet.demo.engine.support;

import java.util.Enumeration;
import java.util.Map;
import java.util.Objects;

/**
 * @className: com.jeevic.servlet.demo.engine.support -> Attributes
 * @description:
 * @author: jeevi
 * @createDate: 2023/12/26 20:43
 * @version: 1.0
 */
public class Attributes extends LazyMap<Object>{
    public Attributes(boolean concurrent) {
        super(concurrent);
    }

    public Attributes() {
        this(false);
    }

    public Object getAttribute(String name) {
        Objects.requireNonNull(name, "name is null.");
        return super.get(name);
    }

    public Enumeration<String> getAttributeNames() {
        return super.keyEnumeration();
    }

    public Object setAttribute(String name, Object value) {
        Objects.requireNonNull(name, "name is null.");
        return super.put(name, value);
    }

    public Object removeAttribute(String name) {
        Objects.requireNonNull(name, "name is null.");
        return super.remove(name);
    }

    public Map<String, Object> getAttributes() {
        return super.map();
    }
}
