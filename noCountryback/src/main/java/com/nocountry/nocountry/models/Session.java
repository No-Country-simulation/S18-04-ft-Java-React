package com.nocountry.nocountry.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

// Registro de asistencias y observaciones por parte del tl a un participante de un equipo
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
    private UUID id;

    private LocalDate sessionDate;

    private Boolean sessionPresent;

    private String sessionObservable;

    @ManyToOne
    @JoinColumn(name = "event_record_id", nullable = false, foreignKey = @ForeignKey(name = "FK_SESSIONS_PARTICIPANT"))
    private EventRecord participant;
}
