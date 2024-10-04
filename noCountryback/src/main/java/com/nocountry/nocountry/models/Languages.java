package com.nocountry.nocountry.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "languages")
public class Languages {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "language_id")
    private UUID id=UUID.randomUUID();

    @Column(name = "language_name",nullable = false)
    private String languageName;

    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<EventRecord>eventRecords;
}
