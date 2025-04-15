package org.zooImproved;

import java.time.LocalTime;

public class FeedingSchedule {
    private final Animal animal;
    private LocalTime feedingTime;
    private String foodType;
    private boolean isCompleted;

    public FeedingSchedule(Animal animal, LocalTime feedingTime, String foodType) {
        this.animal = animal;
        this.feedingTime = feedingTime;
        this.foodType = foodType;
        this.isCompleted = false;
    }

    public void changeSchedule(LocalTime newFeedingTime, String newFoodType) {
        this.feedingTime = newFeedingTime;
        this.foodType = newFoodType;
        System.out.println("Feeding schedule for " + animal.getName() + " has been changed to " + feedingTime + " with " + foodType + ".");
    }

    public void markAsCompleted() {
        this.isCompleted = true;
        System.out.println("Feeding for " + animal.getName() + " at " + feedingTime + " has been marked as completed.");
    }

    public Animal getAnimal() {
        return animal;
    }

    public LocalTime getFeedingTime() {
        return feedingTime;
    }

    public String getFoodType() {
        return foodType;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}