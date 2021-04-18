package com.sevlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author supreme
 */
public class CookieDemo01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if (cookies!=null){

            out.print("上次访问时间是:");

            for (int i = 0; i<cookies.length ; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("CurrentTime")){
                    cookie.setMaxAge(60*60);
                    long longtime = Long.parseLong(cookie.getValue());
                    Date date = new Date(longtime);
                    out.print(date.toLocaleString());
                }
            }

        }else {
            out.print("这是你第一次来本网站!");
        }

        Cookie cookie = new Cookie("CurrentTime",  System.currentTimeMillis()+"");
        //不能设置为0
        cookie.setMaxAge(60*60);
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
