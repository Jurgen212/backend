package com.midefensa.midefensaapp.controllers;

import com.midefensa.midefensaapp.dto.CiudadDTO;
import com.midefensa.midefensaapp.dto.AdvertenciaDTO;
import com.midefensa.midefensaapp.exceptions.CiudadException;
import com.midefensa.midefensaapp.services.interfaces.CiudadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/midefensa/ciudad")
@Slf4j
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class CiudadController {
    private final CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @PostMapping(path = "/guardarCiudad",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarCiudad(@RequestBody CiudadDTO ciudadDTO) {
        try {
            return new ResponseEntity(ciudadService.guardarCiudad(ciudadDTO), HttpStatus.CREATED);
        } catch (CiudadException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/actualizarCiudad")
    public ResponseEntity actualizarCiudad(@RequestBody CiudadDTO ciudadDTO) {
        try {
            return new ResponseEntity(ciudadService.actualizarCiudad(ciudadDTO), HttpStatus.OK);
        } catch (CiudadException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerTodasLasCiudades")
    public ResponseEntity obtenerTodasLasCiudades() {
        return new ResponseEntity(ciudadService.obtenerTodasLasCiudades(), HttpStatus.OK);
    }

    @GetMapping("/obtenerTodasLasCiudadesActivas")
    public ResponseEntity obtenerTodasLasCiudadesActivas() {
        return new ResponseEntity(ciudadService.obtenerTodasLasCiudadesActivas(), HttpStatus.OK);
    }

    @GetMapping("/obtenerTodasLasCiudadesPorDepartamentoId/{departamentoId}")
    public ResponseEntity obtenerTodasLasCiudadesActivasPorDepartamento(@PathVariable("departamentoId") Integer departamentoId) {
        try {
            return new ResponseEntity(ciudadService.obtenerTodasLasCiudadesPorDepartamentoId(departamentoId), HttpStatus.OK);
        } catch (CiudadException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/buscarCiudadPorId/{ciudadId}")
    public ResponseEntity buscarCiudadPorId(@PathVariable("ciudadId") Integer ciudadId) {
        try {
            return new ResponseEntity(ciudadService.buscarCiudadPorId(ciudadId), HttpStatus.OK);
        } catch (CiudadException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/buscarCiudadPorIdActiva/{ciudadId}")
    public ResponseEntity buscarCiudadPorIdActiva(@PathVariable("ciudadId") Integer ciudadId) {
        try {
            return new ResponseEntity(ciudadService.buscarCiudadPorIdActiva(ciudadId), HttpStatus.OK);
        } catch (CiudadException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/buscarCiudadPorNombre/{nombre}")
    public ResponseEntity buscarCiudadPorNombre(@PathVariable("nombre") String nombre) {
        try {
            return new ResponseEntity(ciudadService.buscarCiudadPorNombre(nombre), HttpStatus.OK);
        } catch (CiudadException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/buscarCiudadPorNombreActiva/{nombre}")
    public ResponseEntity buscarCiudadPorNombreActiva(@PathVariable("nombre") String nombre) {
        try {
            return new ResponseEntity(ciudadService.buscarCiudadPorNombreActiva(nombre), HttpStatus.OK);
        } catch (CiudadException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/inactivarCiudad/{ciudadId}")
    public ResponseEntity inactivarCiudad(@PathVariable("ciudadId") Integer ciudadId) {
        try {
            return new ResponseEntity(ciudadService.inactivarCiudad(ciudadId), HttpStatus.OK);
        } catch (CiudadException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/activarCiudad/{ciudadId}")
    public ResponseEntity activarCiudad(@PathVariable("ciudadId") Integer ciudadId) {
        try {
            return new ResponseEntity(ciudadService.activarCiudad(ciudadId), HttpStatus.OK);
        } catch (CiudadException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/eliminarCiudad/{ciudadId}")
    public ResponseEntity eliminarCiudad(@PathVariable("ciudadId") Integer ciudadId) {
        try {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ciudadService.eliminarCiudad(ciudadId)).build(), HttpStatus.OK);
        } catch (CiudadException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
