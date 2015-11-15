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

      String htmltext = "\n"
+"        <script type='text/javascript'\n"
+"            src='/zettage/guacamole-common-js/all.min.js'></script>\n"
+"\n"
+"        <div id='display'></div>\n"
+"        <script type='text/javascript'> \n"
+"\n"
+"            var display = document.getElementById('display');\n"
+"\n"
+"            var guac = new Guacamole.Client(\n"
+"                new Guacamole.HTTPTunnel('"
+tunnel_url
+"')\n"
+"            );\n"
+"\n"
+"            display.appendChild(guac.getDisplay().getElement());\n"
+"            \n"
+"            guac.onerror = function(error) {\n"
+"                alert(error);\n"
+"            };\n"
+"\n"
+"            guac.connect();\n"
+"\n"
+"            window.onunload = function() {\n"
+"                guac.disconnect();\n"
+"            }\n"

+"var mouse = new Guacamole.Mouse(guac.getDisplay().getElement());\n"
+"\n"
+"            mouse.onmousedown = \n"
+"            mouse.onmouseup   =\n"
+"            mouse.onmousemove = function(mouseState) {\n"
+"                guac.sendMouseState(mouseState);\n"
+"            };\n"
+"\n"
+"            var keyboard = new Guacamole.Keyboard(document);\n"
+"\n"
+"            keyboard.onkeydown = function (keysym) {\n"
+"                guac.sendKeyEvent(1, keysym);\n"
+"            };\n"
+"\n"
+"            keyboard.onkeyup = function (keysym) {\n"
+"                guac.sendKeyEvent(0, keysym);\n"
+"            };\n"
+"</script>\n"
+"";
        out.println(htmltext);

  }
  
  public void destroy()
  {
      // 什么也不做
  }
}
