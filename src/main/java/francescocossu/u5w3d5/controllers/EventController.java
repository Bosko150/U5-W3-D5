package francescocossu.u5w3d5.controllers;


import francescocossu.u5w3d5.entities.Evento;
import francescocossu.u5w3d5.payloads.EventoDTO;
import francescocossu.u5w3d5.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventi")
public class EventController {

    @Autowired
    private EventoService eventoService;


    @PostMapping
    @PreAuthorize("hasRole('ORGANIZZATORE_EVENTO')")
    public Evento creaEvento(@RequestBody @Validated EventoDTO evento) {

        return this.eventoService.creaEvento(evento);


    }
}
