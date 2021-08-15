package com.calorie.hystrixDashboard.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "total_search")
@Data
public class TotalCaloriesResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String searchAbout;

    private double totalOfCalories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSearchAbout() {
        return searchAbout;
    }

    public void setSearchAbout(String searchAbout) {
        this.searchAbout = searchAbout;
    }

    public double getTotalOfCalories() {
        return totalOfCalories;
    }

    public void setTotalOfCalories(double totalOfCalories) {
        this.totalOfCalories = totalOfCalories;
    }
}
