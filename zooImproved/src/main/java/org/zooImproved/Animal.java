package org.zooImproved;
import java.time.LocalDate;

public class Animal {
    private String species;
    private String name;
    private LocalDate birthDate;
    private String gender;
    private String favoriteFood;
    private String healthStatus;

    public Animal(String species, String name, LocalDate birthDate, String gender, String favoriteFood, String healthStatus) {
        this.species = species;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.favoriteFood = favoriteFood;
        this.healthStatus = healthStatus;
    }

    public void feed() {
        System.out.println(name + " is being fed with " + favoriteFood + ".");
    }

    public void treat() {
        healthStatus = "здоров";
        System.out.println(name + " has been treated and is now healthy.");
    }

    public void relocate(String newEnclosure) {
        System.out.println(name + " has been moved to the " + newEnclosure + " enclosure.");
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }
}
