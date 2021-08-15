package com.calorie.hystrixDashboard.controller;

import com.calorie.hystrixDashboard.entity.TotalCaloriesResult;
import com.calorie.hystrixDashboard.service.TotalCaloriesSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TotalCaloriesResultController {

    @Autowired
    TotalCaloriesSearchService totalCaloriesSearchService;

    @PostMapping(value = "/sum",produces = MediaType.APPLICATION_JSON_VALUE)
    public void setShape(@RequestBody TotalCaloriesResult food) {
        totalCaloriesSearchService.calculateTotalCalories(food);

    }
}
