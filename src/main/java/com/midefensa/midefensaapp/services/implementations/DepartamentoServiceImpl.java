package com.midefensa.midefensaapp.services.implementations;

import com.midefensa.midefensaapp.domain.Departamento;
import com.midefensa.midefensaapp.dto.DepartamentoDTO;
import com.midefensa.midefensaapp.exceptions.DepartamentoException;
import com.midefensa.midefensaapp.mappers.DepartamentoMapper;
import com.midefensa.midefensaapp.repositories.DepartamentoRepository;
import com.midefensa.midefensaapp.services.interfaces.DepartamentoService;
import com.midefensa.midefensaapp.utility.validations.DepartamentoValidate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
    private final DepartamentoRepository departamentoRepository;

    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    private DepartamentoDTO guardarOActualizarDepartamento(DepartamentoDTO departamentoDTO) {
        Departamento departamento = DepartamentoMapper.dtoToDomain(departamentoDTO);

        return DepartamentoMapper.domainToDto(departamentoRepository.save(departamento));
    }

    private void validarDepartamento(DepartamentoDTO departamentoDTO, boolean esGuardar) throws DepartamentoException {
        if (departamentoDTO == null) {
            throw new DepartamentoException(DepartamentoValidate.DEPARTAMENTO_NO_NULO);
        } if (departamentoDTO.getNombre() == null || departamentoDTO.getNombre().trim().isEmpty()) {
            throw new DepartamentoException(DepartamentoValidate.NOMBRE_NO_NULO_VACIO);
        } if (!Pattern.matches(DepartamentoValidate.NOMBRE_REGEX, departamentoDTO.getNombre())) {
            throw new DepartamentoException(DepartamentoValidate.NOMBRE_REGEX_MENSAJE);
        }

        if (esGuardar) {
            if (departamentoRepository.existsByNombre(departamentoDTO.getNombre())) {
                throw new DepartamentoException(String.format(DepartamentoValidate.NOMBRE_YA_EXISTE, departamentoDTO.getNombre()));
            }
        }

        if (!esGuardar) {
            if (!departamentoRepository.existsById(departamentoDTO.getDepartamentoId())) {
                throw new DepartamentoException(String.format(DepartamentoValidate.DEPARTAMENTO_NO_EXISTE, departamentoDTO.getDepartamentoId()));
            }
        }
    }

    @Override
    public DepartamentoDTO guardarDepartamento(DepartamentoDTO departamentoDTO) throws DepartamentoException {
        validarDepartamento(departamentoDTO, true);

        return guardarOActualizarDepartamento(departamentoDTO);
    }

    @Override
    public DepartamentoDTO actualizarDepartamento(DepartamentoDTO departamentoDTO) throws DepartamentoException {
        validarDepartamento(departamentoDTO, false);

        return guardarOActualizarDepartamento(departamentoDTO);
    }

    @Override
    public List<DepartamentoDTO> obtenerTodosLosDepartamentos() {
        return DepartamentoMapper.domainToDtoList(departamentoRepository.findAll());
    }

    @Override
    public List<DepartamentoDTO> obtenerTodosLosDepartamentosActivos() {
        return DepartamentoMapper.domainToDtoList(departamentoRepository.findAllByEstado(true));
    }

    @Override
    public DepartamentoDTO buscarDepartamentoPorId(Integer departamentoId) throws DepartamentoException {
        if (!departamentoRepository.existsById(departamentoId)) {
            throw new DepartamentoException(String.format(DepartamentoValidate.DEPARTAMENTO_NO_EXISTE, departamentoId));
        }

        return DepartamentoMapper.domainToDto(departamentoRepository.getReferenceById(departamentoId));
    }

    @Override
    public DepartamentoDTO buscarDepartamentoPorIdActivo(Integer departamentoId) throws DepartamentoException {
        if (!departamentoRepository.existsByDepartamentoIdAndEstado(departamentoId, true)) {
            throw new DepartamentoException(String.format(DepartamentoValidate.DEPARTAMENTO_NO_EXISTE, departamentoId));
        }

        return DepartamentoMapper.domainToDto(departamentoRepository.getReferenceById(departamentoId));
    }

    @Override
    public DepartamentoDTO buscarDepartamentoPorNombre(String nombre) throws DepartamentoException {
        if (!departamentoRepository.existsByNombre(nombre)) {
            throw new DepartamentoException(String.format(DepartamentoValidate.NOMBRE_NO_EXISTE, nombre));
        }

        return DepartamentoMapper.domainToDto(departamentoRepository.findByNombre(nombre));
    }

    @Override
    public DepartamentoDTO buscarDepartamentoPorNombreActivo(String nombre) throws DepartamentoException {
        if (!departamentoRepository.existsByNombreAndEstado(nombre, true)) {
            throw new DepartamentoException(String.format(DepartamentoValidate.NOMBRE_NO_EXISTE, nombre));
        }

        return DepartamentoMapper.domainToDto(departamentoRepository.findByNombre(nombre));
    }

    @Override
    public DepartamentoDTO inactivarDepartamento(Integer departamentoId) throws DepartamentoException {
        DepartamentoDTO departamentoDTO = buscarDepartamentoPorId(departamentoId);

        departamentoDTO.setEstado(false);

        return guardarOActualizarDepartamento(departamentoDTO);
    }

    @Override
    public DepartamentoDTO activarDepartamento(Integer departamentoId) throws DepartamentoException {
        DepartamentoDTO departamentoDTO = buscarDepartamentoPorId(departamentoId);

        departamentoDTO.setEstado(true);

        return guardarOActualizarDepartamento(departamentoDTO);
    }

    @Override
    public String eliminarDepartamento(Integer departamentoId) throws DepartamentoException {
        DepartamentoDTO departamentoDTO = buscarDepartamentoPorId(departamentoId);

        String mensajeExito = String.format(DepartamentoValidate.DEPARTAMENTO_ELIMINADO, departamentoId);

        departamentoRepository.delete(DepartamentoMapper.dtoToDomain(departamentoDTO));

        return mensajeExito;
    }
}
