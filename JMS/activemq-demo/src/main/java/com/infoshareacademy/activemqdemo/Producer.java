package com.infoshareacademy.activemqdemo;

import java.io.IOException;
import java.util.Scanner;
import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {

    public static void main(String[] args) throws JMSException, IOException {
        ConnectionFactory connectionFactory =
            new ActiveMQConnectionFactory("tcp://localhost:61616");

        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session =
            connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue("ISA.JJDD3.MSG.QUEUE");

        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        System.out.println("Type message : ");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String text = scanner.nextLine();
            Message msg = session.createTextMessage(text);
            producer.send(msg);
            if (text.equals("exit")) {
                break;
                }
        }

        session.close();
        connection.close();
    }
}
