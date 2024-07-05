package francescocossu.u5w3d5.entities;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UtenteBase extends Utente {


    public UtenteBase(String nome, String cognome, String password, String email) {
        super(nome, cognome, password, email, Ruolo.UTENTE);

    }
}
