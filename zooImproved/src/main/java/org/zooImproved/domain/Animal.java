package org.zooImproved.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // автоинкрементируемый id
    private Long id;

    private String species;
    private String name;
    private LocalDate birthDate;
    private String gender;
    private String favoriteFood;
    private String healthStatus;

    @ManyToOne
    @JoinColumn(name = "enclosure_id")
    @JsonIgnoreProperties("animals")
    private Enclosure enclosure;

    // Обязательный пустой конструктор для JPA
    public Animal() {}

    public Animal(String species, String name, LocalDate birthDate, String gender, String favoriteFood, String healthStatus) {
        this.species = species;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.favoriteFood = favoriteFood;
        this.healthStatus = healthStatus;
    }

    // Поведение
    public void feed() {
        System.out.println(name + " is being fed with " + favoriteFood + ".");
    }

    public void treat() {
        this.healthStatus = "здоров";
        System.out.println(name + " has been treated and is now healthy.");
    }

    public void relocate(String newEnclosure) {
        System.out.println(name + " has been moved to the " + newEnclosure + " enclosure.");
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }
}
