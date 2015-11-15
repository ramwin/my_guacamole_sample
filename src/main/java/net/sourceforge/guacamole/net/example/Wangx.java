// 为包命名
package org.glyptodon.guacamole.net.example;

// 导入必需的 java 库
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class Wangx extends HttpServlet {
 
  private String message;
 
  public void init() throws ServletException
  {
      // 执行必需的的初始化
      message = "Hello World";
  }
 
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // 设置响应内容类型
      response.setContentType("text/html");
 
      // 实际的逻辑是在这里
      PrintWriter out = response.getWriter();
      StringBuffer url = request.getRequestURL();
      out.println("<h1>" + "testpage" + "</h1>");
      out.println("<a href='../guacamole'>click me </a>");
      out.println("You are useing Wangx.java");

  }
  
  public void destroy()
  {
      // 什么也不做
  }
}
