package com.nocountry.nocountry.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nocountry.nocountry.models.enums.Schedule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

// Registro en una simulacion o hackaton
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event_records")
public class EventRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "event_record_id")
    private UUID id;

    @Enumerated(EnumType.STRING)
    private Schedule schedule;

    @Column(name = "tl",nullable = false)
    private Boolean tl;

    @ManyToOne
    @JoinColumn(name = "role_type_id",nullable = false,foreignKey = @ForeignKey(name = "FK_EVENT_RECORD_ROLE_TYPE"))
    private RoleType roleType;

    @ManyToMany
    @JoinTable(name = "register_stack",joinColumns = @JoinColumn(name = "event_record_id",referencedColumnName = "event_record_id"),inverseJoinColumns = @JoinColumn(name = "framework_id",referencedColumnName = "framework_id"))
    private List<Framework>stack;


    @ManyToOne
    @JoinColumn(name = "language_id",foreignKey = @ForeignKey(name = "FK_EVENT_RECORD_LANGUAGE"))
    private Languages language;

    @ManyToOne
    @JoinColumn(name = "profile_id",nullable = false,foreignKey = @ForeignKey(name = "FK_EVENT_RECORD_PROFILE"))
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "event_id",nullable = false,foreignKey = @ForeignKey(name = "FK_EVENT_RECORDS_EVENT"))
    private Event event;

    @OneToMany(mappedBy = "eventRecord",cascade = {CascadeType.ALL},orphanRemoval = true)
    @JsonIgnore
    private List<Participant> participants;
}
