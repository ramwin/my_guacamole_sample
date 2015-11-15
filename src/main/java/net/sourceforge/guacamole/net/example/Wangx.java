// 为包命名
package org.glyptodon.guacamole.net.example;

// 导入必需的 java 库
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
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
      out.println("your url is<br/>");
      out.println(url);
      out.println("<br/>");
      Pattern pattern = Pattern.compile("type([a-zA-Z]+)/host([0-9.]+)/port([0-9]+)/username([a-zA-Z]+)/password([a-zA-Z0-9]+)");
      Matcher matcher = pattern.matcher(url);
      out.println("You would send you tunnel url to <br/>");
      String type = "";
      String host = "";
      String port = "";
      String username = "";
      String password = "";
      if (matcher.find()) {
          type = matcher.group(1);
          host = matcher.group(2);
          port = matcher.group(3);
          username = matcher.group(4);
          password = matcher.group(5);
          }
      String tunnel_url = "/zettage/tunnel/type"+type+"/host"+host+"/port"+port+"/username"+username+"/password"+password;
      out.println(tunnel_url);
      out.println("<br/>");

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
+"            var display = document.getElementById('display');"
+""
+"            var guac = new Guacamole.Client("
+"                new Guacamole.HTTPTunnel('tunnel')"
+"            );"
+""
+"            display.appendChild(guac.getDisplay().getElement());"
+"            "
+"            guac.onerror = function(error) {"
+"                alert(error);"
+"            };"
+""
+"            guac.connect();"
+""
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
