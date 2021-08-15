package com.calorie.hystrixDashboard.service;

import com.calorie.hystrixDashboard.entity.FoodCalories;
import com.calorie.hystrixDashboard.repository.FoodCaloriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class FoodCaloriesService {

    @Autowired
    private FoodCaloriesRepository foodCaloriesRepository;

    public FoodCaloriesService() {
    }

    @Transactional(readOnly = true)
    public List<FoodCalories> getFoodList(){
        return foodCaloriesRepository.findAll();
    }


    public void addFood(FoodCalories foodCalories) {
        System.out.println("+++++++++++++++++++++"+foodCalories.foodName);
        FoodCalories food = foodCalories;
        foodCaloriesRepository.save(food);
    }
}
