package com.mnn.springcoredemo.config;

import com.mnn.springcoredemo.common.Coach;
import com.mnn.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach () {
        return new SwimCoach();
    }
}
