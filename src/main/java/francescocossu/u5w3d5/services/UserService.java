package francescocossu.u5w3d5.services;


import francescocossu.u5w3d5.entities.Organizzatore;
import francescocossu.u5w3d5.entities.Utente;
import francescocossu.u5w3d5.entities.UtenteBase;
import francescocossu.u5w3d5.exceptions.NotFoundException;
import francescocossu.u5w3d5.payloads.UtenteDTO;
import francescocossu.u5w3d5.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    PasswordEncoder bcrypt;
    @Autowired
    private UtenteRepository utenteRepository;

    public UtenteBase saveUtenteBase(UtenteDTO utentePayload) {
        this.utenteRepository.findByEmail(utentePayload.email()).ifPresent(employee -> {
            throw new IllegalArgumentException("Email già in uso");
        });

        UtenteBase utenteBase = new UtenteBase(utentePayload.username(), utentePayload.nome(), utentePayload.cognome(), bcrypt.encode(utentePayload.password()), utentePayload.email());

        return this.utenteRepository.save(utenteBase);
    }

    public Organizzatore saveOrganizzatore(UtenteDTO utentePayload) {
        this.utenteRepository.findByEmail(utentePayload.email()).ifPresent(employee -> {
            throw new IllegalArgumentException("Email già in uso");
        });

        Organizzatore organizzatore = new Organizzatore(utentePayload.username(), utentePayload.nome(), utentePayload.cognome(), bcrypt.encode(utentePayload.password()), utentePayload.email());

        return this.utenteRepository.save(organizzatore);
    }

    public Utente getUtentebyId(UUID id) {
        return utenteRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void deleteUtenteById(UUID id) {
        utenteRepository.deleteById(id);
    }

    public Utente findByEmail(String email) {
        return utenteRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("Utende con email" + email + "non trovato"));
    }
}
