package com.powernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description: 该类是一个抽象类，当使用servlet时，我们常用的方法是service，然而我们需要重写Servlet的所有方法
 *              就显得代码比较臃肿，所以创建一个抽象类作为一个适配器
 * User: SweiPC
 * Date: 2022-02-27
 * Time: 19:47
 */
public abstract class GenericServlet implements Servlet {
    private ServletConfig config;
    /**
     * ServletConfig 是tomcat创建的对象，当子类需要使用这个变量的时候需要将这个对象变成成员变量
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
