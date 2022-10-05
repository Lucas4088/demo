package com.example.demo.user.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class User {
    @Id
    UUID id;
}
