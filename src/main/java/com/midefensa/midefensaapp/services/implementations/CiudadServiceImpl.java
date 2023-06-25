package com.midefensa.midefensaapp.services.implementations;

import com.midefensa.midefensaapp.domain.Ciudad;
import com.midefensa.midefensaapp.domain.Departamento;
import com.midefensa.midefensaapp.dto.CiudadDTO;
import com.midefensa.midefensaapp.exceptions.CiudadException;
import com.midefensa.midefensaapp.mappers.CiudadMapper;
import com.midefensa.midefensaapp.repositories.CiudadRepository;
import com.midefensa.midefensaapp.repositories.DepartamentoRepository;
import com.midefensa.midefensaapp.services.interfaces.CiudadService;
import com.midefensa.midefensaapp.utility.validations.CiudadValidate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class CiudadServiceImpl implements CiudadService {
    private final CiudadRepository ciudadRepository;
    private final DepartamentoRepository departamentoRepository;

    public CiudadServiceImpl(CiudadRepository ciudadRepository, DepartamentoRepository departamentoRepository) {
        this.ciudadRepository = ciudadRepository;
        this.departamentoRepository = departamentoRepository;
    }

    private CiudadDTO guardarOActualizarCiudad(CiudadDTO ciudadDTO) {
        Ciudad ciudad = CiudadMapper.dtoToDomain(ciudadDTO);

        Departamento departamento = departamentoRepository.getReferenceById(ciudadDTO.getDepartamentoId());

        ciudad.setDepartamento(departamento);

        return CiudadMapper.domainToDto(ciudadRepository.save(ciudad));
    }

    private void validarCiudad(CiudadDTO ciudadDTO, boolean esGuardar) throws CiudadException {
        if (ciudadDTO == null) {
            throw new CiudadException(CiudadValidate.CIUDAD_NO_NULA);
        } if (ciudadDTO.getDepartamentoId() == null) {
            throw new CiudadException(CiudadValidate.DEPARTAMENTO_NO_NULO);
        } if (!departamentoRepository.existsById(ciudadDTO.getDepartamentoId())) {
            throw new CiudadException(String.format(CiudadValidate.DEPARTAMENTO_NO_EXISTE, ciudadDTO.getDepartamentoId()));
        } if (ciudadDTO.getNombre() == null || ciudadDTO.getNombre().isEmpty()) {
            throw new CiudadException(CiudadValidate.NOMBRE_NO_NULO_VACIO);
        } if (!Pattern.matches(CiudadValidate.NOMBRE_REGEX, ciudadDTO.getNombre())) {
            throw new CiudadException(CiudadValidate.NOMBRE_REGEX_MENSAJE);
        }

        if (esGuardar) {
            if (ciudadRepository.existsByNombre(ciudadDTO.getNombre())) {
                throw new CiudadException(String.format(CiudadValidate.NOMBRE_YA_EXISTE, ciudadDTO.getNombre()));
            }
        }

        if (!esGuardar) {
            if (!ciudadRepository.existsById(ciudadDTO.getCiudadId())) {
                throw new CiudadException(String.format(CiudadValidate.CIUDAD_NO_EXISTE, ciudadDTO.getCiudadId()));
            }
        }
    }

    @Override
    public CiudadDTO guardarCiudad(CiudadDTO ciudadDTO) throws CiudadException {
        validarCiudad(ciudadDTO, true);

        return guardarOActualizarCiudad(ciudadDTO);
    }

    @Override
    public CiudadDTO actualizarCiudad(CiudadDTO ciudadDTO) throws CiudadException {
        validarCiudad(ciudadDTO, false);

        return guardarOActualizarCiudad(ciudadDTO);
    }

    @Override
    public List<CiudadDTO> obtenerTodasLasCiudades() {
        return CiudadMapper.domainToDtoList(ciudadRepository.findAll());
    }

    @Override
    public List<CiudadDTO> obtenerTodasLasCiudadesActivas() {
        return CiudadMapper.domainToDtoList(ciudadRepository.findAllByEstado(true));
    }

    @Override
    public List<CiudadDTO> obtenerTodasLasCiudadesPorDepartamentoId(Integer departamentoId) throws CiudadException {
        if (!departamentoRepository.existsById(departamentoId)) {
            throw new CiudadException(String.format(CiudadValidate.DEPARTAMENTO_NO_EXISTE, departamentoId));
        }

        return CiudadMapper.domainToDtoList(ciudadRepository.findAllByDepartamento_DepartamentoId(departamentoId));
    }

    @Override
    public CiudadDTO buscarCiudadPorId(Integer ciudadId) throws CiudadException {
        if (!ciudadRepository.existsById(ciudadId)) {
            throw new CiudadException(String.format(CiudadValidate.CIUDAD_NO_EXISTE, ciudadId));
        }

        return CiudadMapper.domainToDto(ciudadRepository.getReferenceById(ciudadId));
    }

    @Override
    public CiudadDTO buscarCiudadPorIdActiva(Integer ciudadId) throws CiudadException {
        if (!ciudadRepository.existsByCiudadIdAndEstado(ciudadId, true)) {
            throw new CiudadException(String.format(CiudadValidate.CIUDAD_NO_EXISTE, ciudadId));
        }

        return CiudadMapper.domainToDto(ciudadRepository.getReferenceById(ciudadId));
    }

    @Override
    public CiudadDTO buscarCiudadPorNombre(String nombre) throws CiudadException {
        if (!ciudadRepository.existsByNombre(nombre)) {
            throw new CiudadException(String.format(CiudadValidate.NOMBRE_NO_EXISTE, nombre));
        }

        return CiudadMapper.domainToDto(ciudadRepository.findByNombre(nombre));
    }

    @Override
    public CiudadDTO buscarCiudadPorNombreActiva(String nombre) throws CiudadException {
        if (!ciudadRepository.existsByNombreAndEstado(nombre, true)) {
            throw new CiudadException(String.format(CiudadValidate.NOMBRE_NO_EXISTE, nombre));
        }

        return CiudadMapper.domainToDto(ciudadRepository.findByNombre(nombre));
    }

    @Override
    public CiudadDTO inactivarCiudad(Integer ciudadId) throws CiudadException {
        CiudadDTO ciudadDTO = buscarCiudadPorId(ciudadId);

        ciudadDTO.setEstado(false);

        return guardarOActualizarCiudad(ciudadDTO);
    }

    @Override
    public CiudadDTO activarCiudad(Integer ciudadId) throws CiudadException {
        CiudadDTO ciudadDTO = buscarCiudadPorId(ciudadId);

        ciudadDTO.setEstado(true);

        return guardarOActualizarCiudad(ciudadDTO);
    }

    @Override
    public String eliminarCiudad(Integer ciudadId) throws CiudadException {
        CiudadDTO ciudadDTO = buscarCiudadPorId(ciudadId);

        String mensajeExito = String.format(CiudadValidate.CIUDAD_ELIMINADA, ciudadId);

        ciudadRepository.delete(CiudadMapper.dtoToDomain(ciudadDTO));

        return mensajeExito;
    }
}
