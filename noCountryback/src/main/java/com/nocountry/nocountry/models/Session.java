package com.nocountry.nocountry.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "session_id")
    private UUID id=UUID.randomUUID();

    private LocalDate sessionDate;

    private Boolean sessionPresent;

    private String sessionObservable;

    @ManyToOne
    @JoinColumn(name = "participant_id", nullable = false, foreignKey = @ForeignKey(name = "FK_SESSIONS_PARTICIPANT"))
    private Participant participant;
}
