package com.example.demo.feature.repository;

import com.example.demo.feature.model.UserFeatureSwitcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserFeatureSwitcherRepository extends JpaRepository<UserFeatureSwitcher, UUID> {
    UserFeatureSwitcher findUserFeatureSwitcherByFeature_IdAndAndUser_Id(UUID featureId, UUID userId);
}
