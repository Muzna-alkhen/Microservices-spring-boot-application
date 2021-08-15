package com.calorie.hystrixDashboard.files;


import java.util.*;

class FoodArray {
    private List<FoodCalorie> foodCalories = new ArrayList<>();

    FoodArray(){
        foodCalories.add(new FoodCalorie(1,"potato",7000));
        foodCalories.add(new FoodCalorie(2,"tomato",87));
    }

    public List<FoodCalorie> getFoodCalories() {
        return foodCalories;
    }

    public void setFoodCalories(List<FoodCalorie> foodCalories) {
        this.foodCalories = foodCalories;
    }
}
