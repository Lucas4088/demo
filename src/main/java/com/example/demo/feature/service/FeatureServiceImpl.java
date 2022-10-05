package com.example.demo.feature.service;

import com.example.demo.feature.model.Feature;
import com.example.demo.feature.model.FeatureAvailability;
import com.example.demo.feature.repository.FeatureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FeatureServiceImpl implements FeatureService {
    FeatureRepository featureRepository;

    @Override
    public UUID create(String name) {
        UUID id = UUID.randomUUID();
        Feature feature = new Feature(id, name, FeatureAvailability.OFF);
        featureRepository.save(feature);
        return id;
    }

    @Override
    public List<Feature> getAllEnabled(UUID userID) {
        return featureRepository.getAllEnabled(userID);
    }

}
