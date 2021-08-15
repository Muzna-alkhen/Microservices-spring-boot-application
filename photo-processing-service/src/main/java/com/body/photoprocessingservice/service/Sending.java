package com.body.photoprocessingservice.service;


import com.body.photoprocessingservice.dto.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Sending {

       @Autowired
       RestTemplate restTemplate;

       public void send(Photo photo)
       {
           String result = this.restTemplate.postForObject(
                   "http://bodyShape/setShape", photo, String.class
           );


       }
}
