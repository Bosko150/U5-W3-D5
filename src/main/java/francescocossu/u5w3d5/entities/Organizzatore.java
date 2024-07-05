package francescocossu.u5w3d5.entities;

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
    @OneToMany(mappedBy = "organizzatore")
    private List<Evento> eventiOrganizzati;


    public Organizzatore(String username, String nome, String cognome, String password, String email) {
        super(username, nome, cognome, password, email, Ruolo.ORGANIZZATORE_EVENTO);
    }
}
