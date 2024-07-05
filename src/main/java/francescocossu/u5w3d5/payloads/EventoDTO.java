package francescocossu.u5w3d5.payloads;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EventoDTO(

        @NotBlank
        String titolo,
        @NotBlank
        String descrizione,
        @Future
        LocalDateTime data,
        @NotBlank
        String luogo,
        @NotNull
        int postiDisponibili,
        String emailOrganizzatore) {
}
