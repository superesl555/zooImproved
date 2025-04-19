package org.zooImproved.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zooImproved.domain.FeedingSchedule;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;

public interface FeedingRepository extends JpaRepository<FeedingSchedule, Long> {
    Optional<FeedingSchedule> findByName(String name);

    @Query("SELECT f FROM FeedingSchedule f WHERE f.name = :name")
    List<FeedingSchedule> findFeedingsByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("DELETE FROM FeedingSchedule f WHERE f.name = :name")
    int deleteByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("DELETE FROM FeedingSchedule f WHERE f.name = :name AND f.animalName = :animalName")
    int deleteByNameAndAnimalName(@Param("name") String name, @Param("animalName") String animalName);
}