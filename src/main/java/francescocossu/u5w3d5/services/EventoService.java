package francescocossu.u5w3d5.services;


import francescocossu.u5w3d5.entities.Evento;
import francescocossu.u5w3d5.entities.Utente;
import francescocossu.u5w3d5.payloads.EventoDTO;
import francescocossu.u5w3d5.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private UserService userService;

    public Evento creaEvento(EventoDTO evento) {
        Utente organizzatore = userService.findByEmail(evento.emailOrganizzatore());

        Evento nuovoEvento = new Evento(evento.titolo(), evento.descrizione(), evento.data(), evento.luogo(), evento.postiDisponibili(), organizzatore);
        return this.eventoRepository.save(nuovoEvento);
    }


}
