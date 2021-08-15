package com.calorie.caloriescalculatorservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="food_calories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCalories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String foodName;

    public double caloriesNumber;
}
