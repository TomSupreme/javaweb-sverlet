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
public class OneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        this.getInitParameter();  初始化
//        this.getServletConfig();  Servlet配置
//        this.getServletContext(); Servlet上下文
        ServletContext context = this.getServletContext();

        String username = "tsy";
        String password = "123";

        context.setAttribute("username", username);
        context.setAttribute("password", password);


    }
}
