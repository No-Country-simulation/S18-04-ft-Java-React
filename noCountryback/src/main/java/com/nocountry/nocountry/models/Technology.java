package com.nocountry.nocountry.models;

import com.nocountry.nocountry.models.enums.TechnologyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

// Tecnologias usadas por equipo. Lo recopila el tl
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "technologies")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "technology_id")
    private UUID id;

    private String technologyName;

    @ElementCollection
    private List<TechnologyType>technologyTypes;
}
