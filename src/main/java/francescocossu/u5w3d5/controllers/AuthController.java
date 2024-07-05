package francescocossu.u5w3d5.controllers;

import francescocossu.u5w3d5.entities.Utente;
import francescocossu.u5w3d5.exceptions.BadRequestException;
import francescocossu.u5w3d5.payloads.UserLoginDTO;
import francescocossu.u5w3d5.payloads.UserLoginResponseDTO;
import francescocossu.u5w3d5.payloads.UtenteDTO;
import francescocossu.u5w3d5.services.AuthService;
import francescocossu.u5w3d5.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public UserLoginResponseDTO login(@RequestBody UserLoginDTO payload) {
        return new UserLoginResponseDTO(authService.authenticateUserAndGenerateToken(payload));
    }

    @PostMapping("/registrati")
    private Utente registraUtente(@RequestBody @Validated UtenteDTO employeePayload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            throw new BadRequestException(validationResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(",")));
        }
        return userService.saveUtenteBase(employeePayload);
    }

    @PostMapping("/registrati/organizzatore")
    private Utente registraOrganizzatore(@RequestBody @Validated UtenteDTO utentePayload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            throw new BadRequestException(validationResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(",")));
        }
        return userService.saveOrganizzatore(utentePayload);
    }
}
