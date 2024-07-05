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

    public Evento creaEvento(EventoDTO eventoPayload, Utente organizzatore) {
        Utente utente = userService.getUtentebyId(organizzatore.getId());
        Evento nuovoEvento = new Evento(eventoPayload.titolo(), eventoPayload.descrizione(), eventoPayload.data(), eventoPayload.luogo(), eventoPayload.postiDisponibili(), utente);
        eventoRepository.save(nuovoEvento);


        return nuovoEvento;
    }


}
