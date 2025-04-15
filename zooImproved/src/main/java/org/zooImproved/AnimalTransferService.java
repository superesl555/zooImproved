package org.zooImproved;

public class AnimalTransferService {
    public void transferAnimal(Animal animal, Enclosure fromEnclosure, Enclosure toEnclosure) {
        if (fromEnclosure.removeAnimal(animal)) {
            if (toEnclosure.addAnimal(animal)) {
                System.out.println(animal.getName() + " has been transferred from " + fromEnclosure.getType() + " to " + toEnclosure.getType() + ".");
            } else {
                fromEnclosure.addAnimal(animal);
            }
        } else {
            System.out.println(animal.getName() + " is not in the " + fromEnclosure.getType() + ".");
        }
    }
}
