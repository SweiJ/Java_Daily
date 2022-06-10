package helloword;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-06-09
 * Time: 19:08
 */
public class Provider {
    @Test
    public void testSendMessage() throws IOException, TimeoutException {
        // 创建连接mq的连接工厂对象
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        connectionFactory.setHost("192.168.80.10");
//        connectionFactory.setPort(5672);
//        connectionFactory.setVirtualHost("/ems");
//        connectionFactory.setUsername("ems");
//        connectionFactory.setPassword("123");
//
//        Connection connection = connectionFactory.newConnection();


        Connection connection = RabbitMQUtils.getConnection();

        // 获取连接中通道
        Channel channel = connection.createChannel();

        // 通道绑定对应消息队列
        // 参数1: 队列名称, 如果队列不存在则自动创建
        // 参数2: 用来定义队列特性是否要持久化, true 持久化队列 false 不持久化
        // 参数3: exclusive 是否独占队列 true 独占队列
        // 参数4: autoDelete: 是否在消费完成后自动删除队列 true 自动删除
        // 参数5: 额外附加参数
        channel.queueDeclare("hello", false, false, false, null);

        // 发布消息
        // 参数1: 交换机名称  参数2: 队列名称  参数3: 传递消息额外设置  参数4: 消息的具体内容
        channel.basicPublish("", "hello", null, "hello rabbitmq".getBytes());


        RabbitMQUtils.closeConnectionAndChanel(channel, connection);
//        channel.close();
//        connection.close();
    }
}
