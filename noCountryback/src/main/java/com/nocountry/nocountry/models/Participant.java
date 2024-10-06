package com.nocountry.nocountry.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

// Participante de un equipo
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "participants")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "participant_id")
    private UUID id=UUID.randomUUID();

    private Boolean isTl;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PARTICIPANTS_TEAM"))
    private Team team;


    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Survey> buddy;

    @OneToMany(mappedBy = "participant",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Session>sessions;

    @ManyToOne
    @JoinColumn(name = "event_record_id", nullable = false, foreignKey = @ForeignKey(name = "FK_EVENT_RECORD_PARTICIPANT"))
    private EventRecord eventRecord;
}
