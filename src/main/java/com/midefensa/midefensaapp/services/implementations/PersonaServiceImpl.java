package com.midefensa.midefensaapp.services.implementations;

import com.midefensa.midefensaapp.domain.Ciudad;
import com.midefensa.midefensaapp.domain.Persona;
import com.midefensa.midefensaapp.domain.TipoDocumento;
import com.midefensa.midefensaapp.dto.PersonaDTO;
import com.midefensa.midefensaapp.utility.enums.TipoPersonaEnum;
import com.midefensa.midefensaapp.exceptions.PersonaException;
import com.midefensa.midefensaapp.mappers.PersonaMapper;
import com.midefensa.midefensaapp.repositories.CiudadRepository;
import com.midefensa.midefensaapp.repositories.PersonaRepository;
import com.midefensa.midefensaapp.repositories.TipoDocumentoRepository;
import com.midefensa.midefensaapp.services.interfaces.PersonaService;
import com.midefensa.midefensaapp.utility.validations.PersonaValidate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;
    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final CiudadRepository ciudadRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository, TipoDocumentoRepository tipoDocumentoRepository, CiudadRepository ciudadRepository) {
        this.personaRepository = personaRepository;
        this.tipoDocumentoRepository = tipoDocumentoRepository;
        this.ciudadRepository = ciudadRepository;
    }

    private PersonaDTO guardarActualizarPersona(PersonaDTO personaDTO) {
        Persona persona = PersonaMapper.dtoToDomain(personaDTO);

        TipoDocumento tipoDocumento = tipoDocumentoRepository.getReferenceById(personaDTO.getTipoDocumentoId());
        Ciudad ciudad = ciudadRepository.getReferenceById(personaDTO.getCiudadId());

        persona.setTipoDocumento(tipoDocumento);
        persona.setCiudad(ciudad);

        return PersonaMapper.domainToDto(personaRepository.save(persona));
    }

    private void validarPersona(PersonaDTO personaDTO, boolean esGuardar) throws PersonaException {
        if (personaDTO == null) {
            throw new PersonaException(PersonaValidate.PERSONA_NO_NULA);
        } if (personaDTO.getTipoDocumentoId() == null) {
            throw new PersonaException(PersonaValidate.TIPODOCUMENTO_NO_NULO);
        } if (!tipoDocumentoRepository.existsById(personaDTO.getTipoDocumentoId())) {
            throw new PersonaException(String.format(PersonaValidate.TIPODOCUMENTO_NO_EXISTE, personaDTO.getTipoDocumentoId()));
        } if (personaDTO.getCiudadId() == null) {
            throw new PersonaException(PersonaValidate.CIUDAD_NO_NULA);
        } if (!ciudadRepository.existsById(personaDTO.getCiudadId())) {
            throw new PersonaException(String.format(PersonaValidate.CIUDAD_NO_EXISTE, personaDTO.getCiudadId()));
        } if (personaDTO.getNombre() == null || personaDTO.getNombre().trim().isEmpty()) {
            throw new PersonaException(PersonaValidate.NOMBRE_NO_NULO_VACIO);
        } if (!Pattern.matches(PersonaValidate.NOMBRE_REGEX, personaDTO.getNombre())) {
            throw new PersonaException(PersonaValidate.NOMBRE_REGEX_MENSAJE);
        } if (personaDTO.getApellido() == null || personaDTO.getApellido().trim().isEmpty()) {
            throw new PersonaException(PersonaValidate.APELLIDO_NO_NULO_VACIO);
        } if (!Pattern.matches(PersonaValidate.APELLIDO_REGEX, personaDTO.getApellido())) {
            throw new PersonaException(PersonaValidate.APELLIDO_REGEX_MENSAJE);
        } if (personaDTO.getNoDocumento() == null || personaDTO.getNoDocumento().trim().isEmpty()) {
            throw new PersonaException(PersonaValidate.NODOCUMENTO_NO_NULO_VACIO);
        } if (!Pattern.matches(PersonaValidate.NODOCUMENTO_REGEX, personaDTO.getNoDocumento())) {
            throw new PersonaException(PersonaValidate.NODOCUMENTO_REGEX_MENSAJE);
        } if (personaDTO.getTelefonoFijo() == null || personaDTO.getTelefonoFijo().trim().isEmpty()) {
            throw new PersonaException(PersonaValidate.TELEFONOFIJO_NO_NULO_VACIO);
        } if (!Pattern.matches(PersonaValidate.TELEFONOFIJO_REGEX, personaDTO.getTelefonoFijo())) {
            throw new PersonaException(PersonaValidate.TELEFONOFIJO_REGEX_MENSAJE);
        } if (personaDTO.getTelefonoCelular() == null || personaDTO.getTelefonoCelular().trim().isEmpty()) {
            throw new PersonaException(PersonaValidate.TELEFONOCELULAR_NO_NULO_VACIO);
        } if (!Pattern.matches(PersonaValidate.TELEFONOCELULAR_REGEX, personaDTO.getTelefonoCelular())) {
            throw new PersonaException(PersonaValidate.TELEFONOCELULAR_REGEX_MENSAJE);
        } if (personaDTO.getTipoPersona() == null || personaDTO.getTipoPersona().trim().isEmpty()) {
            throw new PersonaException(PersonaValidate.TIPOPERSONA_NO_NULO_VACIO);
        } if (!TipoPersonaEnum.esValidoTipoPersona(personaDTO.getTipoPersona())) {
            throw new PersonaException(PersonaValidate.TIPOPERSONA_NO_VALIDA);
        }

        if (esGuardar) {
            if (personaRepository.existsByNoDocumento(personaDTO.getNoDocumento())) {
                throw new PersonaException(String.format(PersonaValidate.NODOCUMENTO_YA_EXISTE, personaDTO.getNoDocumento()));
            }
        }

        if (!esGuardar) {
            if (!personaRepository.existsById(personaDTO.getPersonaId())) {
                throw new PersonaException(String.format(PersonaValidate.PERSONA_NO_EXISTE, personaDTO.getPersonaId()));
            }
        }
    }

    @Override
    public PersonaDTO guardarPersona(PersonaDTO personaDTO) throws PersonaException {
        validarPersona(personaDTO, true);

        return guardarActualizarPersona(personaDTO);
    }

    @Override
    public PersonaDTO actualizarPersona(PersonaDTO personaDTO) throws PersonaException {
        validarPersona(personaDTO, false);

        return guardarActualizarPersona(personaDTO);
    }

    @Override
    public List<PersonaDTO> obtenerTodasLasPersonas() {
        return PersonaMapper.domainToDtoList(personaRepository.findAll());
    }

    @Override
    public List<PersonaDTO> obtenerTodasLasPersonasActivas() {
        return PersonaMapper.domainToDtoList(personaRepository.findAllByEstado(true));
    }

    @Override
    public PersonaDTO buscarPersonaPorId(Integer personaId) throws PersonaException {
        if (!personaRepository.existsById(personaId)) {
            throw new PersonaException(String.format(PersonaValidate.PERSONA_NO_EXISTE, personaId));
        }

        return PersonaMapper.domainToDto(personaRepository.getReferenceById(personaId));
    }

    @Override
    public PersonaDTO buscarPersonaPorIdActiva(Integer personaId) throws PersonaException {
        if (!personaRepository.existsByPersonaIdAndEstado(personaId, true)) {
            throw new PersonaException(String.format(PersonaValidate.PERSONA_NO_EXISTE, personaId));
        }

        return PersonaMapper.domainToDto(personaRepository.getReferenceById(personaId));
    }

    @Override
    public PersonaDTO buscarPersonaPorNoDocumento(String noDocumento) throws PersonaException {
        if (!personaRepository.existsByNoDocumento(noDocumento)) {
            throw new PersonaException(String.format(PersonaValidate.PERSONA_NO_EXISTE_NODOCUMENTO, noDocumento));
        }

        return PersonaMapper.domainToDto(personaRepository.findByNoDocumento(noDocumento));
    }

    @Override
    public PersonaDTO buscarPersonaPorNoDocumentoActiva(String noDocumento) throws PersonaException {
        if (!personaRepository.existsByNoDocumentoAndEstado(noDocumento, true)) {
            throw new PersonaException(String.format(PersonaValidate.PERSONA_NO_EXISTE_NODOCUMENTO, noDocumento));
        }

        return PersonaMapper.domainToDto(personaRepository.findByNoDocumento(noDocumento));
    }

    @Override
    public PersonaDTO inactivarPersona(String noDocumento) throws PersonaException {
        PersonaDTO personaDTO = buscarPersonaPorNoDocumento(noDocumento);

        personaDTO.setEstado(false);

        return guardarActualizarPersona(personaDTO);
    }

    @Override
    public PersonaDTO activarPersona(String noDocumento) throws PersonaException {
        PersonaDTO personaDTO = buscarPersonaPorNoDocumento(noDocumento);

        personaDTO.setEstado(true);

        return guardarActualizarPersona(personaDTO);
    }

    @Override
    public String eliminarPersona(String noDocumento) throws PersonaException {
        PersonaDTO personaDTO = buscarPersonaPorNoDocumento(noDocumento);

        String mensajeExito = String.format(PersonaValidate.PERSONA_ELIMINADA, noDocumento);

        personaRepository.delete(PersonaMapper.dtoToDomain(personaDTO));

        return mensajeExito;
    }
}
