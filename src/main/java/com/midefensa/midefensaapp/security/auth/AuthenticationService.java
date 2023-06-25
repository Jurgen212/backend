package com.midefensa.midefensaapp.security.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.midefensa.midefensaapp.domain.Credencial;
import com.midefensa.midefensaapp.dto.CredencialDTO;
import com.midefensa.midefensaapp.exceptions.CredencialException;
import com.midefensa.midefensaapp.mappers.CredencialMapper;
import com.midefensa.midefensaapp.repositories.CredencialRepository;
import com.midefensa.midefensaapp.repositories.PersonaRepository;
import com.midefensa.midefensaapp.security.jwt.JwtService;
import com.midefensa.midefensaapp.services.interfaces.CredencialService;
import com.midefensa.midefensaapp.utility.validations.CredencialValidate;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final CredencialRepository credencialRepository;
    private final CredencialService credencialService;
    private final PersonaRepository personaRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) throws CredencialException {
        var credencial = Credencial.builder()
                .persona(personaRepository.getReferenceById(request.getPersonaId()))
                .correo(request.getCorreo())
                .contrasena(passwordEncoder.encode(request.getContrasena()))
                .rolUsuario(request.getRolUsuario())
                .estado(request.isEstado())
                .build();

        var credencialDTO = CredencialMapper.domainToDTO(credencial);
        credencialService.validarCredencial(credencialDTO, true);

        credencialRepository.save(credencial);
        var jwtToken = jwtService.generateToken(credencial);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) throws CredencialException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getContrasena()));

        var credencial = credencialRepository.findOneByCorreo(request.getCorreo()).orElseThrow(() -> new CredencialException(CredencialValidate.CORREO_CONTRASENA_NO_EXISTE));

        var jwtToken = jwtService.generateToken(credencial);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }
}
