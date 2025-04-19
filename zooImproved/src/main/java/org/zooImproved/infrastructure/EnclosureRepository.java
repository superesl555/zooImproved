package org.zooImproved.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zooImproved.domain.Enclosure;
import java.util.Optional;
public interface EnclosureRepository extends JpaRepository<Enclosure, Long> {
    Optional<Enclosure> findByName(String name);
}