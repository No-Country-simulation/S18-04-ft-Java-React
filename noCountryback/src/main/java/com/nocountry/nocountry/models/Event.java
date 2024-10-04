package com.nocountry.nocountry.models;

import com.nocountry.nocountry.models.enums.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

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
    private UUID id=UUID.randomUUID();

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

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<EventRecord> eventRecords;
}
