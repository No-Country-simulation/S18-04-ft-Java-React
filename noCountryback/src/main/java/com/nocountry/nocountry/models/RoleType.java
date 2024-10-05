package com.nocountry.nocountry.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

// Roles de un equipo: Ejemplo: De WebApp: Backend, Frontend, UX/UI, QA,etc
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles_type")
public class RoleType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id=UUID.randomUUID();

    private String roleTypeName;

    @ManyToOne
    @JoinColumn(name = "role_type_id", nullable = false,foreignKey = @ForeignKey(name = "FK_ROLES_TYPE_PROJECT_TYPE"))
    private ProjectType projectType;
}
