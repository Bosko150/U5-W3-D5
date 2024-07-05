package francescocossu.u5w3d5.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UtenteDTO(
        @NotBlank(message = "Name cannot be empty")
        String nome,
        @NotBlank(message = "Surname cannot be empty")
        String cognome,
        @NotBlank(message = "Email cannot be empty")
        @Email
        String email,
        @NotBlank(message = "Password cannot be empty")
        String password
) {
}
