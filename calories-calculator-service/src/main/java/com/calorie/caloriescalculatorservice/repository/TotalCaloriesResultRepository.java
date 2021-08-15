package com.calorie.caloriescalculatorservice.repository;

import com.calorie.caloriescalculatorservice.entity.TotalCaloriesResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalCaloriesResultRepository extends JpaRepository<TotalCaloriesResult, Long> {
}
