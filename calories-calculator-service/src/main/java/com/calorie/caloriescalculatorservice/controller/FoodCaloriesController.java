package com.calorie.caloriescalculatorservice.controller;

import com.calorie.caloriescalculatorservice.entity.FoodCalories;
import com.calorie.caloriescalculatorservice.service.FoodCaloriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
public class FoodCaloriesController {

    @Autowired
    private FoodCaloriesService foodCaloriesService = new FoodCaloriesService();

    @GetMapping("/get")
    public String newd(){
        return "newd";
    }
    @GetMapping("/getFood")
    public ResponseEntity<List<FoodCalories>> getFood() {
        return status(OK).body(foodCaloriesService.getFoodList());
    }

    @PostMapping(value = "/addFood",produces = MediaType.APPLICATION_JSON_VALUE)
    public void addCar(@RequestBody FoodCalories foodCalories) {

        foodCaloriesService.addFood(foodCalories);

    }


}
