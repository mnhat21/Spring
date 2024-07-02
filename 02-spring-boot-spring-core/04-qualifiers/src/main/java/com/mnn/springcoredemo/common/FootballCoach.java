package com.mnn.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach  implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Play football for 1 hour !!";
    }

    @Override
    public boolean getResult() {
        return false;
    }
}
