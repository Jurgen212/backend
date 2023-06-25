package com.midefensa.midefensaapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "mensaje")
public class Mensaje {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mensaje_id", nullable = false, unique = true)
    private Integer mensajeId;

    @ManyToOne
    @JoinColumn(name = "credencial_id", referencedColumnName = "credencial_id")
    private Credencial credencial;

    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;

    @Column(name = "estado", nullable = false, length = 1)
    private boolean estado;
}
