package com.midefensa.midefensaapp.controllers;

import com.midefensa.midefensaapp.dto.CredencialDTO;
import com.midefensa.midefensaapp.dto.AdvertenciaDTO;
import com.midefensa.midefensaapp.exceptions.CredencialException;
import com.midefensa.midefensaapp.services.interfaces.CredencialService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/midefensa/credencial")
@Slf4j
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class CredencialController {
    private final CredencialService credencialService;

    public CredencialController(CredencialService credencialService) {
        this.credencialService = credencialService;
    }

    @PostMapping(path = "/guardarCredencial",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarCredencial(@RequestBody CredencialDTO credencialDTO) {
        try {
            return new ResponseEntity(credencialService.guardarCredencial(credencialDTO), HttpStatus.CREATED);
        } catch (CredencialException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/actualizarCredencial")
    public ResponseEntity actualizarCredencial(@RequestBody CredencialDTO credencialDTO) {
        try {
            return new ResponseEntity(credencialService.actualizarCredencial(credencialDTO), HttpStatus.OK);
        } catch (CredencialException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerTodasLasCredenciales")
    public ResponseEntity obtenerTodasLasCredenciales() {
        return new ResponseEntity(credencialService.obtenerTodasLasCredenciales(), HttpStatus.OK);
    }

    @GetMapping("/obtenerTodasLasCredencialesActivas")
    public ResponseEntity obtenerTodasLasCredencialesActivas() {
        return new ResponseEntity(credencialService.obtenerTodasLasCredencialesActivas(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscarCredencialPorId/{credencialId}")
    public ResponseEntity buscarCredencialPorId(@PathVariable("credencialId") Integer credencialId) {
        try {
            return new ResponseEntity(credencialService.buscarCredencialPorId(credencialId), HttpStatus.OK);
        } catch (CredencialException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/buscarCredencialPorIdActiva/{credencialId}")
    public ResponseEntity buscarCredencialPorIdActiva(@PathVariable("credencialId") Integer credencialId) {
        try {
            return new ResponseEntity(credencialService.buscarCredencialPorIdActiva(credencialId), HttpStatus.OK);
        } catch (CredencialException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/buscarCredencialPorCorreo/{correo}")
    public ResponseEntity buscarCredencialPorCorreo(@PathVariable("correo") String correo) {
        try {
            return new ResponseEntity(credencialService.buscarCredencialPorCorreo(correo), HttpStatus.OK);
        } catch (CredencialException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/buscarCredencialPorCorreoActiva/{correo}")
    public ResponseEntity buscarCredencialPorCorreoActiva(@PathVariable("correo") String correo) {
        try {
            return new ResponseEntity(credencialService.buscarCredencialPorCorreoActiva(correo), HttpStatus.OK);
        } catch (CredencialException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/inactivarCredencial/{correo}")
    public ResponseEntity inactivarCredencial(@PathVariable("correo") String correo) {
        try {
            return new ResponseEntity(credencialService.inactivarCredencial(correo), HttpStatus.OK);
        } catch (CredencialException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/activarCredencial/{correo}")
    public ResponseEntity activarCredencial(@PathVariable("correo") String correo) {
        try {
            return new ResponseEntity(credencialService.activarCredencial(correo), HttpStatus.OK);
        } catch (CredencialException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/eliminarCredencial/{correo}")
    public ResponseEntity eliminarCredencial(@PathVariable("correo") String correo) {
        try {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(credencialService.eliminarCredencial(correo)).build(), HttpStatus.OK);
        } catch (CredencialException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
