package com.calorie.hystrixDashboard.files;

class FoodCalorie {
    public int id;
    public String foodName;
    public int foodCalories;

    FoodCalorie(int id, String foodName, int foodCalories){
        this.id = id;
        this.foodName = foodName;
        this.foodCalories = foodCalories;

    }
}
