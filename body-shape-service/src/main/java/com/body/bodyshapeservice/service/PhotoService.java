package com.body.bodyshapeservice.service;

import com.body.bodyshapeservice.entity.Photo;
import com.body.bodyshapeservice.repository.PhotoRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    RestTemplate restTemplate2;

    public  void addPhoto(Photo photo) throws IOException, TimeoutException {
        System.out.println("++++++++++++++"+photo);
        photoRepository.save(photo);

        //setup connection with rabbitMQ server
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //defining the queue
        channel.queueDeclare("photo_queue", false, false, false, null);

        String photoMsg = photo.getId()+","+photo.getPhotoUrl();
        // send the message to rabbitMQ
        channel.basicPublish("", "photo_queue", null, (photoMsg.getBytes()));

        //close the channel and the connection:
        channel.close();
        connection.close();
    }

    public Optional<Photo> getPhoto(Long id){
       return photoRepository.findById(id);
    }

    public void setShape(Long id,String shape){
        Photo photo = photoRepository.getOne(id);
        photo.setShape(shape);
        photoRepository.save(photo);
    }

    public List<Photo> getPhotos() {
        return photoRepository.findAll();
    }

    /*@Transactional(readOnly = true)
    public List<Photo> getPhotos() {
        return photoRepository.findAll();
    }*/


    ////////





    @CachePut("rates")
    @HystrixCommand(fallbackMethod = "getRateFallback" ,
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "30"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000") })
    public String getRate ()

    {
        String str = this.restTemplate2.getForObject(
                "http://CalculateBurnedCaloriesRate/getRate", String.class

        );

        System.out.println("/////////// CONNECTION DONE ////////////");      return  str;
    }

    public String getRateFallback ()
    {


        return "this is the fallBack Method | Cache is Empty ";

    }

}
