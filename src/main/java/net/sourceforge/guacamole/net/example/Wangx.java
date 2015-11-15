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
      out.println("<a href='/guacamole'>click me </a>");
      out.println("You are useing Wangx.java");
      out.println("this is wangx36.war");
      String htmltext = ""
+"<!DOCTYPE HTML>"
+""
+"<html>"
+""
+"    <head>"
+"        <title>Guacamole Tutorial</title>"
+"    </head>"
+""
+"     <body>"
+""
+"        <!-- Guacamole -->"
+"        <script type='text/javascript'"
+"            src='guacamole-common-js/all.min.js'></script>"
+""
+"        <!-- Display -->"
+"        <div id='display'></div>"
+""
+"        <!-- Init -->"
+"        <script type='text/javascript'> /* <![CDATA[ */"
+""
+"            // Get display div from document"
+"            var display = document.getElementById('display');"
+""
+"            // Instantiate client, using an HTTP tunnel for communications."
+"            var guac = new Guacamole.Client("
+"                new Guacamole.HTTPTunnel('tunnel')"
+"            );"
+""
+"            // Add client to display div"
+"            display.appendChild(guac.getDisplay().getElement());"
+"            "
+"            // Error handler"
+"            guac.onerror = function(error) {"
+"                alert(error);"
+"            };"
+""
+"            // Connect"
+"            guac.connect();"
+""
+"            // Disconnect on close"
+"            window.onunload = function() {"
+"                guac.disconnect();"
+"            }"
+""
+"        /* ]]> */ </script>"
+""
+"    </body>"
+""
+"</html>";
        out.println(htmltext);

  }
  
  public void destroy()
  {
      // 什么也不做
  }
}
