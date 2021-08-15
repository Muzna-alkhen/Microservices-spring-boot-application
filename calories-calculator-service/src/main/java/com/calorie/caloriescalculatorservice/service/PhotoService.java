package com.calorie.caloriescalculatorservice.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoService {

    @Autowired
    RestTemplate restTemplate1;

    @Autowired
    CacheManager cacheManager1;

    @Autowired
    CacheManager cacheManager2;


    @Autowired
    RestTemplate restTemplate2;

    @CachePut("photos")
    @HystrixCommand(fallbackMethod = "getPhotoFallback" ,
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "30"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000") })
    public String getPhoto (long id)

    {
      String photo = this.restTemplate1.getForObject(
              "http://bodyShape/getPhoto/{id}", String.class,id


      );

        System.out.println("/////////// CONNECTION DONE ////////////");      return  photo;
    }

    public String getPhotoFallback (long id)
    {


        Cache.ValueWrapper vw  = cacheManager1.getCache("photos").get(id);
        if (vw != null)
        {
            System.out.println("yessssssssssssssssss");


            return  (String) vw.get();
        }
        else
        {
            return   "Cache is NULL";
        }

    }
//////////////////



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
                "http://bodyShape/getRate", String.class

        );

        System.out.println("/////////// CONNECTION DONE ////////////");      return  str;
    }

    public String getRateFallback ()
    {


       return "this is the fallBack Method | Cache is Empty ";

    }


}
