package org.zooImproved;

import java.util.List;

public class ZooStatisticsService {
    public void printStatistics(List<Enclosure> enclosures) {
        System.out.println("Zoo Statistics:");
        for (Enclosure enclosure : enclosures) {
            System.out.println("Type: " + enclosure.getType() + ", Current Animals: " + enclosure.getCurrentAnimalCount() + ", Max Capacity: " + enclosure.getMaxCapacity());
        }
    }
}
