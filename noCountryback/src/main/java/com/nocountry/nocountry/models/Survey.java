package com.nocountry.nocountry.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

// Encuestas de habilidades blandas de un participante del equipo
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "surveys")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "survey_id")
    private UUID id;

    private Double teamWork;

    private Double communication;

    private Double proactivity;

    private Double positiveAttitude;

    private Double toleranceToChange;

    private Double adaptability;

    private Double troubleshooting;

    @ManyToOne
    @JoinColumn(name = "participant_id", nullable = false,foreignKey = @ForeignKey(name = "FK_SURVERIES_PARTICIPANT"))
    private EventRecord participant;

    @ManyToOne
    @JoinColumn(name = "buddy_id",nullable = false,foreignKey = @ForeignKey(name = "FK_SUVERIES_BUDDY"))
    private EventRecord buddy;
}
