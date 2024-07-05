package francescocossu.u5w3d5.controllers;


import francescocossu.u5w3d5.entities.Evento;
import francescocossu.u5w3d5.entities.Utente;
import francescocossu.u5w3d5.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/utenti")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public Utente getProfile(@AuthenticationPrincipal Utente currentlyAuthUser) {
        return currentlyAuthUser;

    }

    @DeleteMapping("/me")
    public void deleteProfile(@AuthenticationPrincipal Utente currentlyAuthUser) {
        userService.deleteUtenteById(currentlyAuthUser.getId());
    }

    @GetMapping("/me/prenotazioni")
    public List<Evento> getEventi(@AuthenticationPrincipal Utente currentlyAuthUser) {
        return currentlyAuthUser.getEventiPrenotati();
    }
}
