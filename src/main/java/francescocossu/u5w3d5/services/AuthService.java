package francescocossu.u5w3d5.services;

import francescocossu.u5w3d5.entities.Utente;
import francescocossu.u5w3d5.exceptions.UnauthorizedException;
import francescocossu.u5w3d5.payloads.UserLoginDTO;
import francescocossu.u5w3d5.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;
    @Autowired
    private JWTTools jwtTools;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public String authenticateUserAndGenerateToken(UserLoginDTO payload) {
        Utente utente = userService.findByEmail(payload.email());

        if (bCryptPasswordEncoder.matches(payload.password(), utente.getPassword())) {
            return jwtTools.createToken(utente);
        } else {
            throw new UnauthorizedException("Invalid credentials");
        }

    }
}
