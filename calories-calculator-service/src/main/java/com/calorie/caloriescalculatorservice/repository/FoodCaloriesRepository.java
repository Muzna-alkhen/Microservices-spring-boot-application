package com.calorie.caloriescalculatorservice.repository;

import com.calorie.caloriescalculatorservice.entity.FoodCalories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FoodCaloriesRepository extends JpaRepository<FoodCalories, Long> {
}
