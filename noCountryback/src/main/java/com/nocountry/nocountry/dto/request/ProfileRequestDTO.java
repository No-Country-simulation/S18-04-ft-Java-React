package com.nocountry.nocountry.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ProfileRequestDTO {
    @NotBlank(message = "El nombre del perfil es obligatorio.")
    private String profileName;
    @NotBlank(message = "El apellido del perfil es obligatorio.")
    private String profileLastname;
    @Pattern(regexp = "^(http://|https://).*", message = "La URL de GitHub debe ser válida.")
    private String githubUrl;
    @Pattern(regexp = "^(http://|https://).*", message = "La URL de LinkedIn debe ser válida.")
    private String linkedinUrl;
    private String avatarUrl;
    private UserRequestDTO user;
}
