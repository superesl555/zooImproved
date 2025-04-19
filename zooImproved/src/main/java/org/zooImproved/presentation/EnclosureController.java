package org.zooImproved.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zooImproved.domain.Animal;
import org.zooImproved.domain.Enclosure;
import org.zooImproved.infrastructure.AnimalRepository;
import org.zooImproved.infrastructure.EnclosureRepository;

import java.util.List;

@RestController
@RequestMapping("/api/enclosures")
public class EnclosureController {

    private final EnclosureRepository enclosureRepository;
    private final AnimalRepository animalRepository;

    @Autowired
    public EnclosureController(EnclosureRepository enclosureRepository, AnimalRepository animalRepository) {
        this.enclosureRepository = enclosureRepository;
        this.animalRepository = animalRepository;
    }

    @PostMapping
    public String addEnclosure(@RequestBody Enclosure enclosure) {
        try {
            enclosureRepository.save(enclosure);
            return "Вольер успешно добавлен в базу.";
        } catch (Exception e) {
            return "Ошибка при добавлении вольера: " + e.getMessage();
        }
    }

    @GetMapping
    public List<Enclosure> getAllEnclosures() {
        return enclosureRepository.findAll();
    }

    @DeleteMapping("/{name}")
    public String deleteEnclosureByName(@PathVariable("name") String name) {
        try {
            Enclosure enclosure = enclosureRepository.findByName(name)
                    .orElseThrow(() -> new IllegalArgumentException("Вольер с именем '" + name + "' не найден."));

            List<Animal> animals = animalRepository.findAllByEnclosureId(enclosure.getId());
            for (Animal animal : animals) {
                animal.setEnclosure(null); // удаляем связь
            }
            animalRepository.saveAll(animals);

            enclosureRepository.delete(enclosure);

            return "Вольер '" + name + "' и все связи с животными удалены.";
        } catch (Exception e) {
            return "Ошибка при удалении вольера: " + e.getMessage();
        }
    }
}
