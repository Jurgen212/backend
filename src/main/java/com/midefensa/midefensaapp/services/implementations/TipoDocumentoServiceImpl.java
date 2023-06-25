package com.midefensa.midefensaapp.services.implementations;

import com.midefensa.midefensaapp.domain.TipoDocumento;
import com.midefensa.midefensaapp.dto.TipoDocumentoDTO;
import com.midefensa.midefensaapp.utility.enums.TipoDocumentoEnum;
import com.midefensa.midefensaapp.exceptions.TipoDocumentoException;
import com.midefensa.midefensaapp.mappers.TipoDocumentoMapper;
import com.midefensa.midefensaapp.repositories.TipoDocumentoRepository;
import com.midefensa.midefensaapp.services.interfaces.TipoDocumentoService;
import com.midefensa.midefensaapp.utility.validations.TipoDocumentoValidate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {
    private final TipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoServiceImpl(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    private TipoDocumentoDTO guardarOActualizarTipoDocumento(TipoDocumentoDTO tipoDocumentoDTO) {
        TipoDocumento tipoDocumento = TipoDocumentoMapper.dtoToDomain(tipoDocumentoDTO);

        return TipoDocumentoMapper.domainToDto(tipoDocumentoRepository.save(tipoDocumento));
    }

    private void validarTipoDocumento(TipoDocumentoDTO tipoDocumentoDTO, boolean esGuardar) throws TipoDocumentoException {
        if (tipoDocumentoDTO == null) {
            throw new TipoDocumentoException(TipoDocumentoValidate.TIPODOCUMENTO_NO_NULO);
        } if (tipoDocumentoDTO.getDescripcion() == null || tipoDocumentoDTO.getDescripcion().trim().isEmpty()) {
            throw new TipoDocumentoException(TipoDocumentoValidate.DESCRIPCION_NO_NULA_VACIA);
        } if (!TipoDocumentoEnum.esValidoTipoDocumento(tipoDocumentoDTO.getDescripcion())) {
            throw new TipoDocumentoException(TipoDocumentoValidate.DESCRIPCION_NO_VALIDA);
        }

        if (esGuardar) {
            if (tipoDocumentoRepository.existsByDescripcion(tipoDocumentoDTO.getDescripcion())) {
                throw new TipoDocumentoException(String.format(TipoDocumentoValidate.DESCRIPCION_YA_EXISTE, tipoDocumentoDTO.getDescripcion()));
            }
        }

        if (!esGuardar) {
            if (!tipoDocumentoRepository.existsById(tipoDocumentoDTO.getTipoDocumentoId())) {
                throw new TipoDocumentoException(String.format(TipoDocumentoValidate.TIPODOCUMENTO_NO_EXISTE, tipoDocumentoDTO.getTipoDocumentoId()));
            }
        }
    }

    @Override
    public TipoDocumentoDTO guardarTipoDocumento(TipoDocumentoDTO tipoDocumentoDTO) throws TipoDocumentoException {
        validarTipoDocumento(tipoDocumentoDTO, true);

        return guardarOActualizarTipoDocumento(tipoDocumentoDTO);
    }

    @Override
    public TipoDocumentoDTO actualizarTipoDocumento(TipoDocumentoDTO tipoDocumentoDTO) throws TipoDocumentoException {
        validarTipoDocumento(tipoDocumentoDTO, false);

        return guardarOActualizarTipoDocumento(tipoDocumentoDTO);
    }

    @Override
    public List<TipoDocumentoDTO> obtenerTodosLosTipoDocumentos() {
        return TipoDocumentoMapper.domainToDtoList(tipoDocumentoRepository.findAll());
    }

    @Override
    public List<TipoDocumentoDTO> obtenerTodosLosTipoDocumentosActivos() {
        return TipoDocumentoMapper.domainToDtoList(tipoDocumentoRepository.findAllByEstado(true));
    }

    @Override
    public TipoDocumentoDTO buscarTipoDocumentoPorId(Integer tipoDocumentoId) throws TipoDocumentoException {
        if (!tipoDocumentoRepository.existsById(tipoDocumentoId)) {
            throw new TipoDocumentoException(String.format(TipoDocumentoValidate.TIPODOCUMENTO_NO_EXISTE, tipoDocumentoId));
        }

        return TipoDocumentoMapper.domainToDto(tipoDocumentoRepository.getReferenceById(tipoDocumentoId));
    }

    @Override
    public TipoDocumentoDTO buscarTipoDocumentoPorIdActivo(Integer tipoDocumentoId) throws TipoDocumentoException {
        if (!tipoDocumentoRepository.existsByTipoDocumentoIdAndEstado(tipoDocumentoId, true)) {
            throw new TipoDocumentoException(String.format(TipoDocumentoValidate.TIPODOCUMENTO_NO_EXISTE, tipoDocumentoId));
        }

        return TipoDocumentoMapper.domainToDto(tipoDocumentoRepository.getReferenceById(tipoDocumentoId));
    }

    @Override
    public TipoDocumentoDTO buscarTipoDocumentoPorDescripcion(String descripcion) throws TipoDocumentoException {
        if (!tipoDocumentoRepository.existsByDescripcion(descripcion)) {
            throw new TipoDocumentoException(String.format(TipoDocumentoValidate.DESCRIPCION_NO_EXISTE, descripcion));
        }

        return TipoDocumentoMapper.domainToDto(tipoDocumentoRepository.findByDescripcion(descripcion));
    }

    @Override
    public TipoDocumentoDTO buscarTipoDocumentoPorDescripcionActivo(String descripcion) throws TipoDocumentoException {
        if (!tipoDocumentoRepository.existsByDescripcionAndEstado(descripcion, true)) {
            throw new TipoDocumentoException(String.format(TipoDocumentoValidate.DESCRIPCION_NO_EXISTE, descripcion));
        }

        return TipoDocumentoMapper.domainToDto(tipoDocumentoRepository.findByDescripcion(descripcion));
    }

    @Override
    public TipoDocumentoDTO inactivarTipoDocumento(Integer tipoDocumentoId) throws TipoDocumentoException {
        TipoDocumentoDTO tipoDocumentoDTO = buscarTipoDocumentoPorId(tipoDocumentoId);

        tipoDocumentoDTO.setEstado(false);

        return guardarOActualizarTipoDocumento(tipoDocumentoDTO);
    }

    @Override
    public TipoDocumentoDTO activarTipoDocumento(Integer tipoDocumentoId) throws TipoDocumentoException {
        TipoDocumentoDTO tipoDocumentoDTO = buscarTipoDocumentoPorId(tipoDocumentoId);

        tipoDocumentoDTO.setEstado(true);

        return guardarOActualizarTipoDocumento(tipoDocumentoDTO);
    }

    @Override
    public String eliminarTipoDocumento(Integer tipoDocumentoId) throws TipoDocumentoException {
        TipoDocumentoDTO tipoDocumentoDTO = buscarTipoDocumentoPorId(tipoDocumentoId);

        String mensajeExito = String.format(TipoDocumentoValidate.TIPODOCUMENTO_ELIMINADO, tipoDocumentoId);

        tipoDocumentoRepository.delete(TipoDocumentoMapper.dtoToDomain(tipoDocumentoDTO));

        return mensajeExito;
    }
}
