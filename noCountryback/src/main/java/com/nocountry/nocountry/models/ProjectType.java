package com.nocountry.nocountry.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;
import java.util.UUID;

// Tipo de Equipo: WebApp, NoCode, Mobile, Data Bi
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project_type")
public class ProjectType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "project_type_id")
    private UUID id;

    @Column(name = "project_type_name",nullable = false)
    private String projectTypeName;

    @Column(name = "project_type_description",nullable = false)
    private String projectTypeDescription;

    @OneToMany(mappedBy = "projectType",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<RoleType> rolesType;
}
