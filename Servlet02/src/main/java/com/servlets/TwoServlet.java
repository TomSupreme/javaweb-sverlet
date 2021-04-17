package com.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author supreme
 */
public class TwoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        ServletContext context = this.getServletContext();
        String username = (String) context.getAttribute("username");
        String password = (String) context.getAttribute("password");
        //字体编码
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print("username:" + username + ",password:" + password);

    }
}
