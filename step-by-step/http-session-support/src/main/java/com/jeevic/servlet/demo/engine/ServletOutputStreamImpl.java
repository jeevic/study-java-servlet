package com.jeevic.servlet.demo.engine;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.WriteListener;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UncheckedIOException;

/**
 * @className: com.jeevic.servlet.demo.engine -> ServletOutputStreamImpl
 * @description:
 * @author: jeevi
 * @createDate: 2023/12/26 21:25
 * @version: 1.0
 */
public class ServletOutputStreamImpl extends ServletOutputStream {

    private final OutputStream output;
    private WriteListener writeListener = null;

    public ServletOutputStreamImpl(OutputStream output) {
        this.output = output;
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void close() throws IOException {
        this.output.close();
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {
        this.writeListener = writeListener;
        try {
            this.writeListener.onWritePossible();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public void write(int b) throws IOException {
        try {
            this.output.write(b);
        } catch (IOException e) {
            if (this.writeListener != null) {
                this.writeListener.onError(e);
            }
            throw e;
        }
    }
}
