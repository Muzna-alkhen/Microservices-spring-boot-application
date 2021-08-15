package com.body.photoprocessingservice.service;

import com.body.photoprocessingservice.dto.Photo;
import com.body.photoprocessingservice.files.Shapes;
import com.rabbitmq.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

@Service
public class BodyProcessing {
    private Shapes shapes = new Shapes();
    Photo photo = new Photo();
    @Autowired
    Sending sendingService;


    public void photoProcessing() throws IOException, TimeoutException {
        //setup connection with rabbitMQ server
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            public RestTemplate restTemplate = new RestTemplate();

            @Override
            public void handleDelivery(

                    String consumerTag,
                    Envelope envelope,
                    AMQP.BasicProperties properties,
                    byte[] body) throws IOException {
                String msg_mq = new String(body, "UTF-8");

                //split the message
                String[] tokens = msg_mq.split(",");
                String photoId = tokens[0];
                String photoUrl = tokens[1];
                System.out.println("+++++++++++++" + photoId + "|" + photoUrl);

                Random rand = new Random(); //instance of random class
                int upperbound = 5;
                int randomShapeIndex = rand.nextInt(upperbound);
                /*msg_mq = msg_mq + "|" + shapes.getShapes().get(randomShapeIndex);*/

                photo.setId(Long.valueOf(tokens[0]));
                photo.setPhotoUrl(tokens[1]);
                photo.setShape(shapes.getShapes().get(randomShapeIndex));


                sendingService.send(photo);


            }
        };
        channel.basicConsume("photo_queue", true, consumer);
    }

    public void sendResult() {

    }
}