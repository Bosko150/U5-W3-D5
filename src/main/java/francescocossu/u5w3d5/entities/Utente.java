package francescocossu.u5w3d5.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"password", "ruolo", "authorities", "enabled", "accountNonExpired", "credentialsNonExpired", "accountNonLocked"})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract public class Utente implements UserDetails {
    @JsonBackReference
    @ManyToMany(mappedBy = "partecipanti")
    public List<Evento> eventiPrenotati;
    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String cognome;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Ruolo ruolo;


    public Utente(String username, String nome, String cognome, String password, String email, Ruolo ruolo) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.email = email;
        this.ruolo = ruolo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.ruolo.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
