package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author supreme
 */
public class FileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. 要获取下载文件的路径
        String path = "E:\\javaweb code\\Maven\\javaweb-sverlet\\response\\src\\main\\resources\\1.jpg";
//        2. 下载文件名是什么
        String filename = path.substring(path.lastIndexOf("\\") + 1);
//        3. 设置想办法让浏览器能够支持下载我们需要的东西
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
//        4. 获取下载文件的输入流
        FileInputStream in = new FileInputStream(path);
//        5. 创建Outputstream对象
        int len = 0;
        byte[] buffer = new byte[1024];
//        6. 将FileOutputStream流写入到buffer缓冲区
        ServletOutputStream out = response.getOutputStream();
//        7. 使用Outputstream将缓冲区中的数据输出到客户端
        while ((len = in.read(buffer))>0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}