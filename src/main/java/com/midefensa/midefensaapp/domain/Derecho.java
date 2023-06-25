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
@Table(name = "derecho")
public class Derecho {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "derecho_id", nullable = false, unique = true)
    private Integer derechoId;

    @ManyToOne
    @JoinColumn(name = "tipo_derecho_id", referencedColumnName = "tipo_derecho_id")
    private TipoDerecho tipoDerecho;

    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;

    @Column(name = "estado", nullable = false, length = 1)
    private boolean estado;
}
