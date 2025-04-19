package org.zooImproved.presentation;

import org.springframework.web.bind.annotation.*;
import org.zooImproved.domain.FeedingSchedule;
import org.zooImproved.infrastructure.FeedingRepository;

import java.util.List;

@RestController
@RequestMapping("/api/feedings")
public class FeedingController {

    private final FeedingRepository feedingRepository;

    public FeedingController(FeedingRepository feedingRepository) {
        this.feedingRepository = feedingRepository;
    }

    @GetMapping
    public List<FeedingSchedule> getFeedings() {
        return feedingRepository.findAll();
    }

    @PostMapping("/list/{name}")
    public List<FeedingSchedule> getFeedingsByListName(@PathVariable String name) {
        return feedingRepository.findFeedingsByName(name);
    }

    @PostMapping
    public String addFeeding(@RequestBody FeedingSchedule feeding) {
        feedingRepository.save(feeding);
        return "Кормление добавлено в базу";
    }

    @DeleteMapping("/{name}")
    public String deleteFeeding(@PathVariable("name") String name) {
        int deletedCount = feedingRepository.deleteByName(name);

        if (deletedCount > 0) {
            return "Список кормления удален из базы";
        } else {
            return "Список кормления не найден";
        }
    }

    @DeleteMapping("/{name}/{animalName}")
    public String deleteFeeding(@PathVariable("name") String name, @PathVariable("animalName") String animalName) {
        int deletedCount = feedingRepository.deleteByNameAndAnimalName(name, animalName);

        if (deletedCount > 0) {
            return "Животное " + animalName + " удалено из списка " + name;
        } else {
            return "Не найдено";
        }
    }
}