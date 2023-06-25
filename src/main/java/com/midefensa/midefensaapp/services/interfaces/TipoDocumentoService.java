package com.midefensa.midefensaapp.services.interfaces;

import com.midefensa.midefensaapp.dto.TipoDocumentoDTO;
import com.midefensa.midefensaapp.exceptions.TipoDocumentoException;

import java.util.List;

public interface TipoDocumentoService {
    TipoDocumentoDTO guardarTipoDocumento(TipoDocumentoDTO tipoDocumentoDTO) throws TipoDocumentoException;
    TipoDocumentoDTO actualizarTipoDocumento(TipoDocumentoDTO tipoDocumentoDTO) throws TipoDocumentoException;
    List<TipoDocumentoDTO> obtenerTodosLosTipoDocumentos();
    List<TipoDocumentoDTO> obtenerTodosLosTipoDocumentosActivos();
    TipoDocumentoDTO buscarTipoDocumentoPorId(Integer tipoDocumentoId) throws TipoDocumentoException;
    TipoDocumentoDTO buscarTipoDocumentoPorIdActivo(Integer tipoDocumentoId) throws TipoDocumentoException;
    TipoDocumentoDTO buscarTipoDocumentoPorDescripcion(String descripcion) throws TipoDocumentoException;
    TipoDocumentoDTO buscarTipoDocumentoPorDescripcionActivo(String descripcion) throws TipoDocumentoException;
    TipoDocumentoDTO inactivarTipoDocumento(Integer tipoDocumentoId) throws TipoDocumentoException;
    TipoDocumentoDTO activarTipoDocumento(Integer tipoDocumentoId) throws TipoDocumentoException;
    String eliminarTipoDocumento(Integer tipoDocumentoId) throws TipoDocumentoException;
}
