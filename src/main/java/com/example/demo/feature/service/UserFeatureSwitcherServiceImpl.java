package com.example.demo.feature.service;

import com.example.demo.feature.model.FeatureAvailability;
import com.example.demo.feature.model.UserFeatureSwitcher;
import com.example.demo.feature.repository.UserFeatureSwitcherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserFeatureSwitcherServiceImpl implements UserFeatureSwitcherService {
    UserFeatureSwitcherRepository repository;


    @Override
    public UserFeatureSwitcher switchOn(UUID userId, UUID featureID) {
        UserFeatureSwitcher userFeatureSwitcher = repository.findUserFeatureSwitcherByFeature_IdAndAndUser_Id(featureID, userId);
        if (userFeatureSwitcher != null) {
            userFeatureSwitcher.getFeature().setAvailability(FeatureAvailability.ON);
            return userFeatureSwitcher;
        } else {
            throw new EntityNotFoundException();
        }
    }
}
