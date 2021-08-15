package com.calorie.hystrixDashboard.repository;

import com.calorie.hystrixDashboard.entity.TotalCaloriesResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalCaloriesResultRepository extends JpaRepository<TotalCaloriesResult, Long> {
}
