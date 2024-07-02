package com.mnn.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;

    // tiêm sự phụ thuộc (các method đã được lớp Cricket Coach override)
    @Autowired
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }

    // Behind the scences
    //    Coach theCoach = new CricketCoach();
    //    DemoController demoController = new DemoController(theCoach);

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/result")
    public boolean getResult() {
        return myCoach.getResult();
    }
}
