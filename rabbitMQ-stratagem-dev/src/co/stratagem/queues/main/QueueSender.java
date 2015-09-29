package co.stratagem.queues.main;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class QueueSender {
	private final static String QUEUE_NAME = "panagiotis-dev";

	  public static void main(String[] argv) throws Exception {
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    factory.setPort(5672);
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    channel.queueDelete(QUEUE_NAME);
	    Thread.sleep(1000);
	    channel.queueDeclare(QUEUE_NAME, true, false, false, null);
	    String message = "Welcome to my World!3";
	    channel.basicPublish("", QUEUE_NAME,  MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
	    System.out.println(" [x] Sent '" + message + "'");

	    channel.close();
	    connection.close();
	  }
}
