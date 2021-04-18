package com.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author supreme
 */
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如何让浏览器5秒刷新一次
        resp.setHeader("refresh", "5");
        //在内存中创建一张图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        //保存图片
        Graphics2D gh = (Graphics2D) image.getGraphics();
        //设置图片的背景颜色
        gh.setBackground(Color.red);
        gh.fillRect(0, 0, 80, 20);
        //给图片写数据
        gh.setColor(Color.blue);
        gh.setFont(new Font(null, Font.BOLD, 20));
        gh.drawString(makeNum(), 0, 20);

        //告诉浏览器，这个请求用图片方式打开
        resp.setContentType("image/jpeg");
        //浏览器是存在缓存的
        resp.setDateHeader("expires", -1);
        resp.setHeader("Cache-Control", "no=cache");
        resp.setHeader("pragma", "no=cache");
        //把图片写给浏览器
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }

    private String makeNum() {
        Random rm = new Random();
        String i = rm.nextInt(888888) + "";
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < 6 - i.length(); j++) {
            sb.append("0");
        }
        String s = sb.toString() + i;
        return s;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
