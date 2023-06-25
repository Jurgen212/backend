package com.midefensa.midefensaapp.controllers;

import com.midefensa.midefensaapp.dto.AdvertenciaDTO;
import com.midefensa.midefensaapp.dto.TipoDocumentoDTO;
import com.midefensa.midefensaapp.exceptions.TipoDocumentoException;
import com.midefensa.midefensaapp.services.interfaces.TipoDocumentoService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/midefensa/tipoDocumento")
@Slf4j
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class TipoDocumentoController {
    private final TipoDocumentoService tipoDocumentoService;

    public TipoDocumentoController(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @PostMapping(path = "/guardarTipoDocumento",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarTipoDocumento(@RequestBody TipoDocumentoDTO tipoDocumentoDTO) {
        try {
            return new ResponseEntity(tipoDocumentoService.guardarTipoDocumento(tipoDocumentoDTO), HttpStatus.CREATED);
        } catch (TipoDocumentoException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/actualizarTipoDocumento")
    public ResponseEntity actualizarTipoDocumento(@RequestBody TipoDocumentoDTO tipoDocumentoDTO) {
        try {
            return new ResponseEntity(tipoDocumentoService.actualizarTipoDocumento(tipoDocumentoDTO), HttpStatus.OK);
        } catch (TipoDocumentoException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerTodosLosTipoDocumentos")
    public ResponseEntity obtenerTodosLosTipoDocumentos() {
        return new ResponseEntity(tipoDocumentoService.obtenerTodosLosTipoDocumentos(), HttpStatus.OK);
    }

    @GetMapping("/obtenerTodosLosTipoDocumentosActivos")
    public ResponseEntity obtenerTodosLosTipoDocumentosActivos() {
        return new ResponseEntity(tipoDocumentoService.obtenerTodosLosTipoDocumentosActivos(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscarTipoDocumentoPorId/{tipoDocumentoId}")
    public ResponseEntity buscarTipoDocumentoPorId(@PathVariable("tipoDocumentoId") Integer tipoDocumentoId) {
        try {
            return new ResponseEntity(tipoDocumentoService.buscarTipoDocumentoPorId(tipoDocumentoId), HttpStatus.OK);
        } catch (TipoDocumentoException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/buscarTipoDocumentoPorIdActivo/{tipoDocumentoId}")
    public ResponseEntity buscarTipoDocumentoPorIdActivo(@PathVariable("tipoDocumentoId") Integer tipoDocumentoId) {
        try {
            return new ResponseEntity(tipoDocumentoService.buscarTipoDocumentoPorIdActivo(tipoDocumentoId), HttpStatus.OK);
        } catch (TipoDocumentoException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/buscarTipoDocumentoPorDescripcion/{descripcion}")
    public ResponseEntity buscarTipoDocumentoPorDescripcion(@PathVariable("descripcion") String descripcion) {
        try {
            return new ResponseEntity(tipoDocumentoService.buscarTipoDocumentoPorDescripcion(descripcion), HttpStatus.OK);
        } catch (TipoDocumentoException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/buscarTipoDocumentoPorDescripcionActivo/{descripcion}")
    public ResponseEntity buscarTipoDocumentoPorDescripcionActivo(@PathVariable("descripcion") String descripcion) {
        try {
            return new ResponseEntity(tipoDocumentoService.buscarTipoDocumentoPorDescripcionActivo(descripcion), HttpStatus.OK);
        } catch (TipoDocumentoException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/inactivarTipoDocumento/{tipoDocumentoId}")
    public ResponseEntity inactivarTipoDocumento(@PathVariable Integer tipoDocumentoId) {
        try {
            return new ResponseEntity(tipoDocumentoService.inactivarTipoDocumento(tipoDocumentoId), HttpStatus.OK);
        } catch (TipoDocumentoException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/activarTipoDocumento/{tipoDocumentoId}")
    public ResponseEntity activarTipoDocumento(@PathVariable Integer tipoDocumentoId) {
        try {
            return new ResponseEntity(tipoDocumentoService.activarTipoDocumento(tipoDocumentoId), HttpStatus.OK);
        } catch (TipoDocumentoException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/eliminarTipoDocumento/{tipoDocumentoId}")
    public ResponseEntity eliminarTipoDocumento(@PathVariable Integer tipoDocumentoId) {
        try {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(tipoDocumentoService.eliminarTipoDocumento(tipoDocumentoId)).build(), HttpStatus.OK);
        } catch (TipoDocumentoException ex) {
            return new ResponseEntity(AdvertenciaDTO.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
