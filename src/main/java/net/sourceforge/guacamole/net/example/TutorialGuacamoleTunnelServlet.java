package org.glyptodon.guacamole.net.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TutorialGuacamoleTunnelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {
            System.out.println("处理Get()请求");
            PrintWriter out = response.getWriter();
            out.println("Hello Servetl");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        super.doPost(request,response);
    }
}
