package me.deathlesz.featness;

import org.springframework.boot.SpringApplication;

public class TestFeatnessApplication {
    public static void main(String[] args) {
        SpringApplication.from(FeatnessApplication::main).run(args);
    }
}