package com.nocountry.nocountry.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PasswordResetRequest(
        @NotBlank(message = "El token no debe estar vacío")
        String token,

        @NotBlank(message = "La contraseña no debe estar vacía")
        @Size(min = 6, max = 15, message = "La contraseña debe tener entre 6 y 15 caracteres")
        //@Pattern(regexp = ".*[A-Z].*", message = "La contraseña debe contener al menos una letra mayúscula")
        //@Pattern(regexp = ".*[a-z].*", message = "La contraseña debe contener al menos una letra minúscula")
        //@Pattern(regexp = ".*[!@#$%&*_].*", message = "La contraseña debe contener al menos un carácter especial de !@#$%&*_")
        String password
) {
}
