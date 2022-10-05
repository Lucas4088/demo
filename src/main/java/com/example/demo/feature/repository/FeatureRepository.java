package com.example.demo.feature.repository;

import com.example.demo.feature.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, UUID> {

    @Query("select * from Feature f join UserFeatureSwitcher ufs on f.id = ufs.feature.id where f.availability = 'ON' and ufs.feature.availability = 'ON' and ufs.user.id like %?1%")
    List<Feature> getAllEnabled(UUID userId);
}
