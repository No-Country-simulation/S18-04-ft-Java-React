package com.nocountry.nocountry.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

// El stack que te preguntan cuando te registras: Angular, Spring, React,
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
    private UUID id;

    @Column(name = "framework_name", nullable = false)
    private String frameworkName;

    @Column(name = "framework_type",nullable = false)
    private String frameworkType;

    @Column(name = "language",nullable = false)
    private String language;
}
