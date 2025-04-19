package org.zooImproved.dto;

public class AnimalDTO {
    private String name;
    private String species;
    private String enclosureName;

    public AnimalDTO(String name, String species, String enclosureName) {
        this.name = name;
        this.species = species;
        this.enclosureName = enclosureName;
    }

    public AnimalDTO(org.zooImproved.domain.Animal animal) {
        this.name = animal.getName();
        this.species = animal.getSpecies();
        this.enclosureName = animal.getEnclosure() != null ? animal.getEnclosure().getName() : "Без вольера";
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getEnclosureName() {
        return enclosureName;
    }
}
