package com.example.demo.feature.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feature {
    @Id
    UUID id;

    String name;

    FeatureAvailability availability;
}
