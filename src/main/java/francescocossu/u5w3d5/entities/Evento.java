package francescocossu.u5w3d5.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Evento {
    private UUID id;
    private String titolo;
    private String descrizione;
    private Date data;
    private String luogo;
    private int postiDisponibili;
    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "eventi_partecipanti", joinColumns = @JoinColumn(name = "id_evento"), inverseJoinColumns = @JoinColumn(name = "id_utente"))
    private List<Utente> partecipanti;
    @JsonBackReference
    @ManyToOne
    @JoinTable(name = "eventi_organizzatori", joinColumns = @JoinColumn(name = "id_evento"), inverseJoinColumns = @JoinColumn(name = "id_organizzatore"))
    private Organizzatore organizzatore;


    public Evento(String titolo, String descrizione, Date data, String luogo, int postiDisponibili, Organizzatore organizzatore) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.data = data;
        this.luogo = luogo;
        this.postiDisponibili = postiDisponibili;
        this.organizzatore = organizzatore;
    }
}
