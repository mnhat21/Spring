package com.mnn.springcoredemo.rest;

import com.mnn.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;

    @Autowired
    public void setCoach( @Qualifier("swimCoach") Coach theCoach) {
         myCoach = theCoach;
    }

    // BTS
    // Coach theCoach = new CricketCoach();
    // DemoController dm = new DemoController();
    // dm.setCoach(theCoach);

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/result")
    public boolean getResult() {
        return myCoach.getResult();
    }
}
