package org.zooImproved.presentation;

import org.springframework.web.bind.annotation.*;
import org.zooImproved.application.AnimalTransferService;
import org.zooImproved.domain.Animal;
import org.zooImproved.infrastructure.AnimalRepository;
import org.zooImproved.dto.AnimalDTO;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final AnimalRepository animalRepository;
    private final AnimalTransferService animalTransferService;

    public AnimalController(AnimalRepository animalRepository, AnimalTransferService animalTransferService) {
        this.animalRepository = animalRepository;
        this.animalTransferService = animalTransferService;
    }

    @GetMapping
    public List<AnimalDTO> getAllAnimals() {
        return animalRepository.findAll().stream()
                .map(AnimalDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/move")
    public String moveAnimal(@RequestBody Map<String, String> payload) {
        try {
            String animalName = payload.get("animalName");
            String enclosureName = payload.get("enclosureName");
            animalTransferService.moveAnimalToEnclosure(animalName, enclosureName);
            return "Животное успешно перемещено.";
        } catch (IllegalArgumentException e) {
            return "Ошибка: " + e.getMessage();
        } catch (Exception e) {
            return "Произошла ошибка при перемещении животного.";
        }
    }

    @PostMapping
    public String addAnimal(@RequestBody Animal animal) {
        animalRepository.save(animal);
        return "Животное добавлено в базу";
    }

    @DeleteMapping("/{name}")
    public String deleteAnimal(@PathVariable("name") String name) {
        Animal animal = animalRepository.findByName(name);
        if (animal != null) {
            animalRepository.delete(animal);
            return "Животное удалено из базы";
        } else {
            return "Животное не найдено";
        }
    }
}
