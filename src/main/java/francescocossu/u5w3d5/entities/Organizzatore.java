package francescocossu.u5w3d5.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Organizzatore extends Utente {
    @JsonManagedReference
    @OneToMany(mappedBy = "organizzatori")
    private List<Evento> eventiOrganizzati;


    public Organizzatore(String nome, String cognome, String password, String email) {
        super(nome, cognome, password, email, Ruolo.ORGANIZZATORE_EVENTO);
    }
}
