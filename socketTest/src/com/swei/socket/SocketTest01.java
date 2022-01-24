package com.swei.socket;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-22
 * Time: 19:20
 */
public class SocketTest01 {
    public static void main(String[] args) throws UnknownHostException {
        /**
         * InetAddress 封装的是IP
         * InetSocketAddress 封装的是IP 和端口号
         */
        InetAddress inetAddress1 = InetAddress.getByName("localhost");
        System.out.println(inetAddress1);
        InetAddress inetAddress2 = InetAddress.getByName("SweiPC");
        System.out.println(inetAddress2);
        InetAddress inetAddress3 = InetAddress.getByName("10.202.14.140");
        System.out.println(inetAddress3);
        InetAddress inetAddress4 = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress4);

        InetSocketAddress inetSocketAddress = new InetSocketAddress("SweiPC", 8080);
        System.out.println(inetSocketAddress.getAddress());
        System.out.println(inetSocketAddress.getPort());
        System.out.println(inetSocketAddress.getHostName());
        System.out.println(inetSocketAddress.getHostString());

        InetAddress ita = inetSocketAddress.getAddress();
        System.out.println(ita);
        System.out.println(ita.getHostAddress());
        System.out.println(ita.getHostName());
    }
}
