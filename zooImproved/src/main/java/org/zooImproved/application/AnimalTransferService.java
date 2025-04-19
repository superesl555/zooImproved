package org.zooImproved.application;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.zooImproved.infrastructure.AnimalRepository;
import org.zooImproved.infrastructure.EnclosureRepository;
import org.zooImproved.domain.Animal;
import org.zooImproved.domain.Enclosure;


@Service
public class AnimalTransferService {

    private final AnimalRepository animalRepository;
    private final EnclosureRepository enclosureRepository;

    public AnimalTransferService(AnimalRepository animalRepository, EnclosureRepository enclosureRepository) {
        this.animalRepository = animalRepository;
        this.enclosureRepository = enclosureRepository;
    }

    @Transactional
    public void moveAnimalToEnclosure(String animalName, String targetEnclosureName) {
        Animal animal = animalRepository.findByName(animalName);
        if (animal == null) {
            throw new RuntimeException("Animal not found");
        }
        Enclosure currentEnclosure = animal.getEnclosure();
        Enclosure targetEnclosure = enclosureRepository.findByName(targetEnclosureName)
                .orElseThrow(() -> new RuntimeException("Target enclosure not found"));

        if (targetEnclosure.getAnimals().size() >= targetEnclosure.getMaxCapacity()) {
            throw new IllegalStateException("Target enclosure is full");
        }

        if (currentEnclosure != null) {
            currentEnclosure.getAnimals().remove(animal);
        }

        // Добавляем в новый вольер
        targetEnclosure.getAnimals().add(animal);
        animal.setEnclosure(targetEnclosure);

        // Сохраняем изменения
        animalRepository.save(animal);
    }
}
