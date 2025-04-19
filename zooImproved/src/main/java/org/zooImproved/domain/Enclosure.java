package org.zooImproved.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Enclosure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // автоинкрементируемый id
    private Long id;

    private String name;
    private String type;
    private int maxCapacity;
    private double size;

    @OneToMany(mappedBy = "enclosure", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Animal> animals = new ArrayList<>();

    public Enclosure() {}

    public Enclosure(String name, String type, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.type = type;
        this.size = 0;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void maxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setType(String type) {
        this.type = type;
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

    public Long getId() {
        return id;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
