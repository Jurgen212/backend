package com.midefensa.midefensaapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tutela")
public class Tutela {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tutela_id", nullable = false, unique = true)
    private Integer tutelaId;

    @ManyToOne
    @JoinColumn(name = "demandante_persona_id", referencedColumnName = "persona_id")
    private Persona demandantePersona;

    @ManyToOne
    @JoinColumn(name = "demandado_persona_id", referencedColumnName = "persona_id")
    private Persona demandadoPersona;

    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;

    @Column(name = "necesidad", nullable = false, length = 250)
    private String necesidad;

    @Column(name = "pdf", nullable = false)
    private MediaType pdf;

    @Column(name = "estado", nullable = false, length = 1)
    private boolean estado;
}
