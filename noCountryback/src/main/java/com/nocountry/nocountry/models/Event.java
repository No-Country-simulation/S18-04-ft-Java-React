package com.nocountry.nocountry.models;

import com.nocountry.nocountry.models.enums.EventType;
import com.nocountry.nocountry.models.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

// Los eventos pueden ser las simulaciones o hackatones: Se describe el nombres y demas atributos
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "event_id")
    private UUID id;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(name = "event_name",nullable = false)
    private String eventName;

    @Column(name = "event_description",nullable = false)
    private String eventDescription;

    @Column(name = "event_participant")
    private Integer eventParticipant;

    @Column(name = "event_date_start",nullable = false)
    private LocalDate eventDateStart;

    @Column(name = "event_date_end",nullable = false)
    private LocalDate eventDateEnd;

    @Enumerated(EnumType.STRING)
    private State state;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<EventRecord> eventRecords;
}
