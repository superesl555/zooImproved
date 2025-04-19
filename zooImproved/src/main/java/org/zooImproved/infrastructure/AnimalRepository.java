package org.zooImproved.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zooImproved.domain.Animal;

import java.util.List;
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Animal findByName(String name);
    List<Animal> findAllByEnclosureId(Long enclosureId);
}
