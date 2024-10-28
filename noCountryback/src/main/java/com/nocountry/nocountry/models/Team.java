package com.nocountry.nocountry.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;
import java.util.UUID;

// Equipo de una simulacion o hackaton
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "team_id")
    private UUID id;

    private String teamName;

    private String projectName;

    private Integer teamNumber;

    @ManyToMany
    @JoinTable(name = "team_framework",joinColumns = @JoinColumn(name = "team_id",referencedColumnName = "team_id"),inverseJoinColumns = @JoinColumn(name = "framework_id",referencedColumnName = "framework_id"))
    private List<Framework> teamFrameworks;

    @ManyToMany
    @JoinTable(name = "team-technologies",joinColumns = @JoinColumn(name = "team_id",referencedColumnName = "team_id"),inverseJoinColumns = @JoinColumn(name = "technology_id",referencedColumnName = "technology_id"))
    private List<Technology>technologies;

    private String meetUrl;

    private String whatsappUrl;

    @OneToOne
    @JoinColumn(name = "event_record_id",foreignKey = @ForeignKey(name = "FK_TEAMS_EVENT_RECORDS"))
    private EventRecord tl;

}
