package com.mnn.springcoredemo.common;

public class SwimCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Swim 200m for warming up !!";
    }

    @Override
    public boolean getResult() {
        return true;
    }
}
