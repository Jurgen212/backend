package com.midefensa.midefensaapp.controllers;

import com.midefensa.midefensaapp.dto.DepartamentoDTO;
import com.midefensa.midefensaapp.dto.AdvertenciaDTO;
import com.midefensa.midefensaapp.exceptions.DepartamentoException;
import com.midefensa.midefensaapp.services.interfaces.DepartamentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/midefensa/departamento")
@Slf4j
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class DepartamentoController {
    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @PostMapping(path = "/guardarDepartamento",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarDepartamento(@RequestBody DepartamentoDTO departamentoDTO) {
        try {
            return new ResponseEntity(departamentoService.guardarDepartamento(departamentoDTO), HttpStatus.CREATED);
        } catch (DepartamentoException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/actualizarDepartamento")
    public ResponseEntity actualizarDepartamento(@RequestBody DepartamentoDTO departamentoDTO) {
        try {
            return new ResponseEntity(departamentoService.actualizarDepartamento(departamentoDTO), HttpStatus.OK);
        } catch (DepartamentoException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerTodosLosDepartamentos")
    public ResponseEntity obtenerTodosLosDepartamentos() {
        return new ResponseEntity(departamentoService.obtenerTodosLosDepartamentos(), HttpStatus.OK);
    }

    @GetMapping("/obtenerTodosLosDepartamentosActivos")
    public ResponseEntity obtenerTodosLosDepartamentosActivos() {
        return new ResponseEntity(departamentoService.obtenerTodosLosDepartamentosActivos(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscarDepartamentoPorId/{departamentoId}")
    public ResponseEntity buscarDepartamentoPorId(@PathVariable("departamentoId") Integer departamentoId) {
        try {
            return new ResponseEntity(departamentoService.buscarDepartamentoPorId(departamentoId), HttpStatus.OK);
        } catch (DepartamentoException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/buscarDepartamentoPorIdActivo/{departamentoId}")
    public ResponseEntity buscarDepartamentoPorIdActivo(@PathVariable("departamentoId") Integer departamentoId) {
        try {
            return new ResponseEntity(departamentoService.buscarDepartamentoPorIdActivo(departamentoId), HttpStatus.OK);
        } catch (DepartamentoException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/buscarDepartamentoPorNombre/{nombre}")
    public ResponseEntity buscarDepartamentoPorNombre(@PathVariable("nombre") String nombre) {
        try {
            return new ResponseEntity(departamentoService.buscarDepartamentoPorNombre(nombre), HttpStatus.OK);
        } catch (DepartamentoException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/buscarDepartamentoPorNombreActivo/{nombre}")
    public ResponseEntity buscarDepartamentoPorNombreActivo(@PathVariable("nombre") String nombre) {
        try {
            return new ResponseEntity(departamentoService.buscarDepartamentoPorNombreActivo(nombre), HttpStatus.OK);
        } catch (DepartamentoException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/inactivarDepartamento/{departamentoId}")
    public ResponseEntity inactivarDepartamento(@PathVariable("departamentoId") Integer departamentoId) {
        try {
            return new ResponseEntity(departamentoService.inactivarDepartamento(departamentoId), HttpStatus.OK);
        } catch (DepartamentoException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/activarDepartamento/{departamentoId}")
    public ResponseEntity activarDepartamento(@PathVariable("departamentoId") Integer departamentoId) {
        try {
            return new ResponseEntity(departamentoService.activarDepartamento(departamentoId), HttpStatus.OK);
        } catch (DepartamentoException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/eliminarDepartamento/{departamentoId}")
    public ResponseEntity eliminarDepartamento(@PathVariable("departamentoId") Integer departamentoId) {
        try {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(departamentoService.eliminarDepartamento(departamentoId)).build(), HttpStatus.OK);
        } catch (DepartamentoException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
