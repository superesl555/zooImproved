package org.zooImproved;

import java.util.ArrayList;
import java.util.List;

public class FeedingOrganizationService {
    private List<FeedingSchedule> feedingSchedules;

    public FeedingOrganizationService() {
        this.feedingSchedules = new ArrayList<>();
    }

    public void addFeedingSchedule(FeedingSchedule schedule) {
        feedingSchedules.add(schedule);
        System.out.println("Feeding schedule for " + schedule.getAnimal().getName() + " has been added.");
    }

    public void executeFeedingSchedules() {
        for (FeedingSchedule schedule : feedingSchedules) {
            if (!schedule.isCompleted()) {
                System.out.println("Feeding " + schedule.getAnimal().getName() + " with " + schedule.getFoodType() + " at " + schedule.getFeedingTime() + ".");
                schedule.markAsCompleted();
            }
        }
    }
}
