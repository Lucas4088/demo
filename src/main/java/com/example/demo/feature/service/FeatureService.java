package com.example.demo.feature.service;

import com.example.demo.feature.model.Feature;

import java.util.List;
import java.util.UUID;

public interface FeatureService {
    UUID create(String name);

    List<Feature> getAllEnabled(UUID userId);
}
