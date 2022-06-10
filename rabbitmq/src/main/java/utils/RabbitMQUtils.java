package utils;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-06-10
 * Time: 9:30
 */
public class RabbitMQUtils {

    private static ConnectionFactory connectionFactory;

    static  {
        connectionFactory = new ConnectionFactory();
    }
    // 定义连接对象的方法
    public static Connection  getConnection() {
        try {
            connectionFactory.setHost("192.168.80.10");
            connectionFactory.setPort(5672);
            connectionFactory.setVirtualHost("/ems");
            connectionFactory.setUsername("ems");
            connectionFactory.setPassword("123");
            return connectionFactory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnectionAndChanel(Channel channel, Connection conn) {
        try {
            if(channel != null) {
                channel.close();
            }
            if(conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
