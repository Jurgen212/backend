package com.midefensa.midefensaapp.security.auth;

import com.midefensa.midefensaapp.dto.AdvertenciaDTO;
import com.midefensa.midefensaapp.exceptions.CredencialException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/midefensa/autenticacion")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", methods= { RequestMethod.POST })
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/registrar")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        try {
            return new ResponseEntity(authenticationService.register(request), HttpStatus.OK);
        } catch (CredencialException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/autenticar")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        try {
            return new ResponseEntity(authenticationService.authenticate(request), HttpStatus.OK);
        } catch (CredencialException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
