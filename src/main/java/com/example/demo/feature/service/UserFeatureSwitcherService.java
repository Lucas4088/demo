package com.example.demo.feature.service;

import com.example.demo.feature.model.UserFeatureSwitcher;

import java.util.UUID;

public interface UserFeatureSwitcherService {
    UserFeatureSwitcher switchOn(UUID userId, UUID featureID);
}
