package com.powernode.javaweb.servlet;

import jakarta.servlet.*;
import jakarta.servlet.GenericServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-02-27
 * Time: 19:51
 */
public class ServletDemo extends GenericServlet {
	@Override
	public void init() {
		System.out.print("ServletDemo.init");
	}
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		ServletConfig config = this.getServletConfig();
		// 该方法可以打印所有的servlet-name中的关键词
		Enumeration<String> figParam = this.getInitParameterNames();
		while(figParam.hasMoreElements()) {
			String name = figParam.nextElement();
			String value = config.getInitParameter(name);
			out.print(name + "=" + value);
		}

		// 一个servlet对象 对应一个servletConfig对象， 100个servlet对象对应100个servletConfig对象
		// 该方法主要存储所有的servlet对象 在一个webapp中共享一个servletContxt对象
		// 在服务器启动的时候创建 关闭时销毁
		ServletContext application = this.getServletContext();
		Enumeration<String> textParam = application.getInitParameterNames();
		while(textParam.hasMoreElements()) {
			String name = textParam.nextElement();
			String value = application.getInitParameter(name);
			out.print(name + "=" + value + "<br>");
		}

		// 获取应用的根 此项目的根为/xmm
		String path = application.getContextPath();
		out.print(path + "<br>");

		// 加上"/"表示从根开始, 打印的是web.xml的路径
		String realPath = application.getRealPath("/");
		out.print(realPath + "<br>");

		// 加上"/"和不加"/"都可以
		String realPath1 = application.getRealPath("student.html");
		String realPath2 = application.getRealPath("/student.html");
		out.print(realPath1 + "<br>" + realPath2);

		// catalina.2022-03-01.log 服务器端的java程序运行的控制台信息
		// localhost.2022-03-01.log ServletContext对象的log方法记录的日志信息存储到这个文件中
		// localhost_access_log.2022-03-01.txt 访问日志
		int a = 10;
		if(a < 18) {
			application.log("当前值小于正常值", new Exception("存在一个错误！"));
		}
    }
}
