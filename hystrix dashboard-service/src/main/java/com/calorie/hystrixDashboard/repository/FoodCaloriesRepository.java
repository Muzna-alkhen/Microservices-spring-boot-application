package com.calorie.hystrixDashboard.repository;

import com.calorie.hystrixDashboard.entity.FoodCalories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCaloriesRepository extends JpaRepository<FoodCalories, Long> {
}
