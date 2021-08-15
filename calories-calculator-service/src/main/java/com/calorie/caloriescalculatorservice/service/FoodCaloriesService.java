package com.calorie.caloriescalculatorservice.service;

import com.calorie.caloriescalculatorservice.entity.FoodCalories;
import com.calorie.caloriescalculatorservice.repository.FoodCaloriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
