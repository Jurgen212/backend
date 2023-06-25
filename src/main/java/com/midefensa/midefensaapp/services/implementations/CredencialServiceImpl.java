package com.midefensa.midefensaapp.services.implementations;

import com.midefensa.midefensaapp.domain.Credencial;
import com.midefensa.midefensaapp.domain.Persona;
import com.midefensa.midefensaapp.dto.CredencialDTO;
import com.midefensa.midefensaapp.exceptions.CredencialException;
import com.midefensa.midefensaapp.mappers.CredencialMapper;
import com.midefensa.midefensaapp.repositories.CredencialRepository;
import com.midefensa.midefensaapp.repositories.PersonaRepository;
import com.midefensa.midefensaapp.services.interfaces.CredencialService;
import com.midefensa.midefensaapp.utility.validations.CredencialValidate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class CredencialServiceImpl implements CredencialService {
    private final CredencialRepository credencialRepository;
    private final PersonaRepository personaRepository;

    public CredencialServiceImpl(CredencialRepository credencialRepository, PersonaRepository personaRepository) {
        this.credencialRepository = credencialRepository;
        this.personaRepository = personaRepository;
    }

    private CredencialDTO guardarOAcutalizarCredencial(CredencialDTO credencialDTO) {
        Credencial credencial = CredencialMapper.dtoToDomain(credencialDTO);

        Persona persona = personaRepository.getReferenceById(credencialDTO.getPersonaId());
        credencial.setPersona(persona);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        credencial.setContrasena(passwordEncoder.encode(credencialDTO.getContrasena()));

        return CredencialMapper.domainToDTO(credencialRepository.save(credencial));
    }

    @Override
    public void validarCredencial(CredencialDTO credencialDTO, boolean esGuardar) throws CredencialException {
        if (credencialDTO == null) {
            throw new CredencialException(CredencialValidate.CREDENCIAL_NO_NULA);
        } if (credencialDTO.getPersonaId() == null) {
            throw new CredencialException(CredencialValidate.PERSONA_NO_NULO);
        } if (!personaRepository.existsById(credencialDTO.getPersonaId())) {
            throw new CredencialException(String.format(CredencialValidate.PERSONA_NO_EXISTE, credencialDTO.getPersonaId()));
        } if (credencialDTO.getRolUsuario() == null) {
            throw new CredencialException(CredencialValidate.ROLUSUARIO_NO_NULO);
        } if (credencialDTO.getCorreo() == null || credencialDTO.getCorreo().isEmpty()) {
            throw new CredencialException(CredencialValidate.CORREO_NO_NULO_VACIO);
        } if (!Pattern.matches(CredencialValidate.CORREO_REGEX, credencialDTO.getCorreo())) {
            throw new CredencialException(CredencialValidate.CORREO_REGEX_MENSAJE);
        } if (credencialDTO.getContrasena() == null || credencialDTO.getContrasena().isEmpty()) {
            throw new CredencialException(CredencialValidate.CONTRASENA_NO_NULO_VACIO);
        } if (!Pattern.matches(CredencialValidate.CONTRASENA_REGEX, credencialDTO.getContrasena())) {
            throw new CredencialException(CredencialValidate.CONTRASENA_REGEX_MENSAJE);
        }

        if (esGuardar) {
            if (credencialRepository.existsByCorreo(credencialDTO.getCorreo())) {
                throw new CredencialException(String.format(CredencialValidate.CORREO_YA_EXISTE, credencialDTO.getCorreo()));
            }
        }

        if (!esGuardar) {
            if (!credencialRepository.existsById(credencialDTO.getCredencialId())) {
                throw new CredencialException(String.format(CredencialValidate.CREDENCIAL_NO_EXISTE, credencialDTO.getCredencialId()));
            }
        }
    }

    @Override
    public CredencialDTO guardarCredencial(CredencialDTO credencialDTO) throws CredencialException {
        validarCredencial(credencialDTO, true);

        return guardarOAcutalizarCredencial(credencialDTO);
    }

    @Override
    public CredencialDTO actualizarCredencial(CredencialDTO credencialDTO) throws CredencialException {
        validarCredencial(credencialDTO, false);

        return guardarOAcutalizarCredencial(credencialDTO);
    }

    @Override
    public List<CredencialDTO> obtenerTodasLasCredenciales() {
        return CredencialMapper.domainToDTOList(credencialRepository.findAll());
    }

    @Override
    public List<CredencialDTO> obtenerTodasLasCredencialesActivas() {
        return CredencialMapper.domainToDTOList(credencialRepository.findAllByEstado(true));
    }

    @Override
    public CredencialDTO buscarCredencialPorId(Integer credencialId) throws CredencialException {
        if (!credencialRepository.existsById(credencialId)) {
            throw new CredencialException(String.format(CredencialValidate.CREDENCIAL_NO_EXISTE, credencialId));
        }

        return CredencialMapper.domainToDTO(credencialRepository.getReferenceById(credencialId));
    }

    @Override
    public CredencialDTO buscarCredencialPorIdActiva(Integer credencialId) throws CredencialException {
        if (!credencialRepository.existsByCredencialIdAndEstado(credencialId, true)) {
            throw new CredencialException(String.format(CredencialValidate.CREDENCIAL_NO_EXISTE, credencialId));
        }

        return CredencialMapper.domainToDTO(credencialRepository.getReferenceById(credencialId));
    }

    @Override
    public CredencialDTO buscarCredencialPorCorreo(String correo) throws CredencialException {
        if (!credencialRepository.existsByCorreo(correo)) {
            throw new CredencialException(String.format(CredencialValidate.CORREO_NO_EXISTE, correo));
        }

        return CredencialMapper.domainToDTO(credencialRepository.findByCorreo(correo));
    }

    @Override
    public CredencialDTO buscarCredencialPorCorreoActiva(String correo) throws CredencialException {
        if (!credencialRepository.existsByCorreoAndEstado(correo, true)) {
            throw new CredencialException(String.format(CredencialValidate.CORREO_NO_EXISTE, correo));
        }

        return CredencialMapper.domainToDTO(credencialRepository.findByCorreo(correo));
    }

    @Override
    public CredencialDTO inactivarCredencial(String correo) throws CredencialException {
        CredencialDTO credencialDTO = buscarCredencialPorCorreo(correo);

        credencialDTO.setEstado(false);

        return guardarOAcutalizarCredencial(credencialDTO);
    }

    @Override
    public CredencialDTO activarCredencial(String correo) throws CredencialException {
        CredencialDTO credencialDTO = buscarCredencialPorCorreo(correo);

        credencialDTO.setEstado(true);

        return guardarOAcutalizarCredencial(credencialDTO);
    }

    @Override
    public String eliminarCredencial(String correo) throws CredencialException {
        CredencialDTO credencialDTO = buscarCredencialPorCorreo(correo);

        String mensajeExito = String.format(CredencialValidate.CREDENCIAL_ELIMINADA, correo);

        credencialRepository.delete(CredencialMapper.dtoToDomain(credencialDTO));

        return mensajeExito;
    }
}
