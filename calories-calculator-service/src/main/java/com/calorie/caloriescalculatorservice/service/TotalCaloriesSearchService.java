package com.calorie.caloriescalculatorservice.service;

import com.calorie.caloriescalculatorservice.entity.TotalCaloriesResult;
import com.calorie.caloriescalculatorservice.repository.TotalCaloriesResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TotalCaloriesSearchService {

    @Autowired
    TotalCaloriesResultRepository totalCaloriesResultRepository;
    public void calculateTotalCalories(TotalCaloriesResult food){
        food.setTotalOfCalories(32000);
        totalCaloriesResultRepository.save(food);
    };

}
