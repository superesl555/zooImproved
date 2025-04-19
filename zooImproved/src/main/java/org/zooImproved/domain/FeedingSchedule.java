package org.zooImproved.domain;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class FeedingSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // автоинкрементируемый id
    private Long id;

    private String name;
    private String animalName;
    private LocalTime feedingTime;
    private String foodType;
    private boolean isCompleted;

    public FeedingSchedule() {}

    public FeedingSchedule(Animal animal, LocalTime feedingTime, String foodType) {
        this.feedingTime = feedingTime;
        this.foodType = foodType;
        this.isCompleted = false;
    }

    public void changeSchedule(LocalTime newFeedingTime, String newFoodType) {
        this.feedingTime = newFeedingTime;
        this.foodType = newFoodType;
        System.out.println("Feeding schedule for " + animalName + " has been changed to " + feedingTime + " with " + foodType + ".");
    }

    public void markAsCompleted() {
        this.isCompleted = true;
        System.out.println("Feeding for " + animalName + " at " + feedingTime + " has been marked as completed.");
    }

    public String getName() {return name;}

    public String getAnimalName() {
        return animalName;
    }

    public LocalTime getFeedingTime() {
        return feedingTime;
    }

    public String getFoodType() {
        return foodType;
    }

    public boolean getisCompleted() {
        return isCompleted;
    }
}