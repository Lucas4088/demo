package com.example.demo.feature.controller;

import com.example.demo.feature.controller.model.CreateFeature;
import com.example.demo.feature.model.Feature;
import com.example.demo.feature.model.UserFeatureSwitcher;
import com.example.demo.feature.service.FeatureService;
import com.example.demo.feature.service.UserFeatureSwitcherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/feature")
public class FeatureController {

    FeatureService featureService;
    UserFeatureSwitcherService userFeatureSwitcherService;

    @ResponseBody
    @Secured("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<UUID> create(@RequestBody CreateFeature createFeature){
        return new ResponseEntity<>(featureService.create(createFeature.getName()), HttpStatus.CREATED);
    }

    @ResponseBody
    @Secured("ROLE_ADMIN")
    @PatchMapping("/{featureId}/switch-on/{userId}")
    public ResponseEntity<UserFeatureSwitcher> switchOn(@PathVariable UUID featureId, @PathVariable UUID userId) {
        return new ResponseEntity<>(userFeatureSwitcherService.switchOn(userId, featureId), HttpStatus.OK);
    }


    @ResponseBody
    @Secured("ROLE_USER")
    @GetMapping("/all-enabled/{userId}")
    public ResponseEntity<List<Feature>> allEnabled(@PathVariable UUID userId) {
        return new ResponseEntity<>(featureService.getAllEnabled(userId), HttpStatus.OK);
    }
}
