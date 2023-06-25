package com.midefensa.midefensaapp.repositories;

import com.midefensa.midefensaapp.domain.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
    boolean existsByTipoDocumentoIdAndEstado(Integer tipoDocumentoId, boolean estado);
    boolean existsByDescripcion(String descripcion);
    boolean existsByDescripcionAndEstado(String descripcion, boolean estado);
    TipoDocumento findByDescripcion(String descripcion);
    List<TipoDocumento> findAllByEstado(boolean estado);
}
