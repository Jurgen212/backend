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
@Table(name = "correo_tribunal")
public class CorreoTribunal {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "correo_tribunal_id", nullable = false, unique = true)
    private Integer correoTribunalId;

    @ManyToOne
    @JoinColumn(name = "ciudad_id", referencedColumnName = "ciudad_id")
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name = "tipo_derecho_id", referencedColumnName = "tipo_derecho_id")
    private TipoDerecho tipoDerecho;

    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @Column(name = "estado", nullable = false, length = 1)
    private boolean estado;
}
