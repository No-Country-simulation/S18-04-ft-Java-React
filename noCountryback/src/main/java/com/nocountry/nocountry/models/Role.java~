package com.nocountry.nocountry.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Permission;
import java.util.List;
import java.util.UUID;

// Roles de usuario se necesita 2 usuarios por defecto: User, Admin(Desarrollador)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "role_id")
    private UUID id=UUID.randomUUID();

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @Column(name = "role_description", nullable = false)
    private String roleDescription;

    @ManyToMany
    @JoinTable(name = "role_permission",joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "role_id"),inverseJoinColumns = @JoinColumn(name = "permission_id",referencedColumnName = "permission_id"))
    private List<PPermission> permissions;
}
