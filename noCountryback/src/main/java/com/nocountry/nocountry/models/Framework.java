package com.nocountry.nocountry.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "frameworks")
public class Framework {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "framework_id")
    private UUID id=UUID.randomUUID();

    @Column(name = "framework_name", nullable = false)
    private String frameworkName;
}
