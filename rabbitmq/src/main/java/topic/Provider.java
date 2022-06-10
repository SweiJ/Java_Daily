package topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-06-10
 * Time: 14:51
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("topics", "topic");

        String routekey = "user.save";

        channel.basicPublish("topics",
                routekey, null, ("这里是topic动态路由模型, routekey: [" + routekey + "]").getBytes());

        RabbitMQUtils.closeConnectionAndChanel(channel, connection);
    }
}
