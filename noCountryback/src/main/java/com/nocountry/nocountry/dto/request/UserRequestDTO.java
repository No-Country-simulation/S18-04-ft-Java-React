package com.nocountry.nocountry.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public class UserRequestDTO {
    @NotBlank(message = "El email es obligatorio.")
    @Email(message = "El email debe ser válido.")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria.")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres.")
    private String password;

    private List<UUID> roleIds;
}
