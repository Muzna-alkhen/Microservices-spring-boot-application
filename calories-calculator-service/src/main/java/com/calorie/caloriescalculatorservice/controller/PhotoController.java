package com.calorie.caloriescalculatorservice.controller;


import com.calorie.caloriescalculatorservice.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhotoController {
@Autowired
PhotoService photoService;

    @GetMapping("/getPhoto/{id}")
    public String getPhoto(@PathVariable long id){

        return photoService.getPhoto( id);


    }


    @GetMapping("/getRate")
    public String getRate(){

        return photoService.getRate();


    }
    @GetMapping("/getCache/{id}")
    public String getCache(@PathVariable long id){

        return photoService.getPhotoFallback(id);


    }
}
