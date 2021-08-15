package com.calorie.calculateburnedcaloriesrateservice.controllers;


import com.calorie.calculateburnedcaloriesrateservice.dto.Message;
import com.calorie.calculateburnedcaloriesrateservice.dto.WeightDifference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Value("${spring.profiles}")
    private String zone;

    @GetMapping("/getRate")
    public String rate() {
        return ("Burned Calories  : 185500");
    }

    @PostMapping("/rate")
    public Message calculateRate(@RequestBody WeightDifference weightDifference) {
        System.out.println("++++++++++++++++++++"+weightDifference.month);
        double rate = ((weightDifference.lastWeight - weightDifference.newWeight) * 7000) / weightDifference.month * 4;
        String result = "The burned calories rate in the weak is: " + String.valueOf(rate);
        Message message = new Message();
        message.newMessage = result + "\nThese response from Zone: " + rate();
        return message;
    }
}
