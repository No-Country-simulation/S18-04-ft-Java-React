package com.nocountry.nocountry.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID id;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "role_id"))
    private List<Role>roles;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Profile profile;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<PPermission> permissions = this.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .toList();

        List<GrantedAuthority> authorities = this.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRoleName())).collect(Collectors.toList());
        permissions.stream().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getPermissionName())));
        return authorities;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }
}
