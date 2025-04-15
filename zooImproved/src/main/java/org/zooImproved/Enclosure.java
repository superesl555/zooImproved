package org.zooImproved;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    private String type;
    private double size;
    private List<Animal> animals;
    private int maxCapacity;

    public Enclosure(String type, double size, int maxCapacity) {
        this.type = type;
        this.size = size;
        this.maxCapacity = maxCapacity;
        this.animals = new ArrayList<>();
    }

    public boolean addAnimal(Animal animal) {
        if (animals.size() < maxCapacity) {
            animals.add(animal);
            System.out.println(animal.getName() + " has been added to the enclosure.");
            return true;
        } else {
            System.out.println("Cannot add " + animal.getName() + ": enclosure is full.");
            return false;
        }
    }

    public boolean removeAnimal(Animal animal) {
        if (animals.remove(animal)) {
            System.out.println(animal.getName() + " has been removed from the enclosure.");
            return true;
        } else {
            System.out.println(animal.getName() + " is not in the enclosure.");
            return false;
        }
    }

    public void clean() {
        System.out.println("The enclosure has been cleaned.");
    }

    public String getType() {
        return type;
    }

    public double getSize() {
        return size;
    }

    public int getCurrentAnimalCount() {
        return animals.size();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
