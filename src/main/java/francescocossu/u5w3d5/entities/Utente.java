package francescocossu.u5w3d5.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract public class Utente {
    @JsonBackReference
    @ManyToMany(mappedBy = "partecipanti")
    public List<Evento> eventiPrenotati;
    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private Ruolo ruolo;


    public Utente(String nome, String cognome, String password, String email, Ruolo ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.email = email;
        this.ruolo = ruolo;
    }
}
