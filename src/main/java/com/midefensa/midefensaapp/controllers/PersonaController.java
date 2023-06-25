package com.midefensa.midefensaapp.controllers;

import com.midefensa.midefensaapp.dto.AdvertenciaDTO;
import com.midefensa.midefensaapp.dto.PersonaDTO;
import com.midefensa.midefensaapp.exceptions.PersonaException;
import com.midefensa.midefensaapp.services.interfaces.PersonaService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/midefensa/persona")
@Slf4j
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping(path = "/guardarPersona",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarPersona(@RequestBody PersonaDTO personaDTO) {
        try {
            return new ResponseEntity(personaService.guardarPersona(personaDTO), HttpStatus.CREATED);
        } catch (PersonaException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/actualizarPersona")
    public ResponseEntity actualizarPersona(@RequestBody PersonaDTO personaDTO) {
        try {
            return new ResponseEntity(personaService.actualizarPersona(personaDTO), HttpStatus.OK);
        } catch (PersonaException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerTodasLasPersonas")
    public ResponseEntity obtenerTodasLasPersonas() {
        return new ResponseEntity(personaService.obtenerTodasLasPersonas(), HttpStatus.OK);
    }

    @GetMapping("/obtenerTodasLasPersonasActivas")
    public ResponseEntity obtenerTodasLasPersonasActivas() {
        return new ResponseEntity(personaService.obtenerTodasLasPersonasActivas(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscarPersonaPorId/{personaId}")
    public ResponseEntity buscarPersonaPorId(@PathVariable("personaId") Integer personaId) {
        try {
            return new ResponseEntity(personaService.buscarPersonaPorId(personaId), HttpStatus.OK);
        } catch (PersonaException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/buscarPersonaPorIdActiva/{personaId}")
    public ResponseEntity buscarPersonaPorIdActiva(@PathVariable("personaId") Integer personaId) {
        try {
            return new ResponseEntity(personaService.buscarPersonaPorIdActiva(personaId), HttpStatus.OK);
        } catch (PersonaException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/buscarPersonaPorNoDocumento/{noDocumento}")
    public ResponseEntity buscarPersonaPorNoDocumento(@PathVariable("noDocumento") String noDocumento) {
        try {
            return new ResponseEntity(personaService.buscarPersonaPorNoDocumento(noDocumento), HttpStatus.OK);
        } catch (PersonaException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/buscarPersonaPorNoDocumentoActiva/{noDocumento}")
    public ResponseEntity buscarPersonaPorNoDocumentoActiva(@PathVariable("noDocumento") String noDocumento) {
        try {
            return new ResponseEntity(personaService.buscarPersonaPorNoDocumentoActiva(noDocumento), HttpStatus.OK);
        } catch (PersonaException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/inactivarPersona/{noDocumento}")
    public ResponseEntity inactivarPersona(@PathVariable("noDocumento") String noDocumento) {
        try {
            return new ResponseEntity(personaService.inactivarPersona(noDocumento), HttpStatus.OK);
        } catch (PersonaException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/activarPersona/{noDocumento}")
    public ResponseEntity activarPersona(@PathVariable("noDocumento") String noDocumento) {
        try {
            return new ResponseEntity(personaService.activarPersona(noDocumento), HttpStatus.OK);
        } catch (PersonaException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/eliminarPersona/{noDocumento}")
    public ResponseEntity eliminarPersona(@PathVariable("noDocumento") String noDocumento) {
        try {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(personaService.eliminarPersona(noDocumento)).build(), HttpStatus.OK);
        } catch (PersonaException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
