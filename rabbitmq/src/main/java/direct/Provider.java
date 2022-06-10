package direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-06-10
 * Time: 14:06
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        String exchangeName = "logs_direct";
        Channel channel = connection.createChannel();

        // 参数1: 交换机名称  参数2: 路由模式
        channel.exchangeDeclare(exchangeName, "direct");

        String routingkey = "error";
        channel.basicPublish(exchangeName, routingkey,
                null, ("这是direct模型发布的基于route key: [" + routingkey + "]发布消息").getBytes());

        RabbitMQUtils.closeConnectionAndChanel(channel, connection);
    }
}
