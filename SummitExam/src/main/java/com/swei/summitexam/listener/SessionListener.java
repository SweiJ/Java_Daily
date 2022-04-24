package com.swei.summitexam.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-24
 * Time: 20:19
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    private int onlineCount = 0;//记录session的数量

    /**
     * session创建后执行
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        onlineCount++;
        System.out.println("【HttpSessionListener监听器】 sessionCreated, onlineCount:" + onlineCount);
        se.getSession().getServletContext().setAttribute("onlineCount", onlineCount);
    }

    /**
     * session失效后执行
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        if (onlineCount > 0) {
            onlineCount--;
        }
        System.out.println("【HttpSessionListener监听器】 sessionDestroyed, onlineCount:" + onlineCount);
        se.getSession().getServletContext().setAttribute("onlineCount", onlineCount);
    }

}
