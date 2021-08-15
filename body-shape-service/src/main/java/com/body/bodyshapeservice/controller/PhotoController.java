package com.body.bodyshapeservice.controller;

import com.body.bodyshapeservice.entity.Photo;
import com.body.bodyshapeservice.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeoutException;

@RestController
public class PhotoController {
    @Autowired
    public PhotoService photoService;

    @GetMapping("/getPhotos")
    public List<Photo> getPhotos(){
        return photoService.getPhotos();
    }
    @GetMapping("/getRate")
    public String rate() {

        return photoService.getRate();

    }

    @GetMapping("/getPhoto/{id}")
    public Optional<Photo> getPhoto(@PathVariable long id ){
        System.out.println("++++++++++");
        return photoService.getPhoto((long) id);
    }

    @PostMapping(value = "/addPhoto",produces = MediaType.APPLICATION_JSON_VALUE)
    public void addPhoto(@RequestBody Photo photo) throws IOException, TimeoutException {
        System.out.println("+++++++"+photo.getPhotoUrl());
        photoService.addPhoto(photo);
    }

    @PostMapping(value = "/setShape",produces = MediaType.APPLICATION_JSON_VALUE)
    public void setShape(@RequestBody Photo photo) {
        photoService.setShape(photo.getId(),photo.getShape());
    }
}
