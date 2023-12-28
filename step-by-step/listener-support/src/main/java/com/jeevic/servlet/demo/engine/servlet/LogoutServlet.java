package com.jeevic.servlet.demo.engine.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @className: com.jeevic.servlet.demo.engine.servlet -> LogoutServlet
 * @description:
 * @author: jeevi
 * @createDate: 2023/12/26 20:53
 * @version: 1.0
 */
@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("/");
    }
}
