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
@Table(name = "persona")
public class Persona {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id", nullable = false, unique = true)
    private Integer personaId;

    @ManyToOne
    @JoinColumn(name = "tipo_documento_id", referencedColumnName = "tipo_documento_id")
    private TipoDocumento tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "ciudad_id", referencedColumnName = "ciudad_id")
    private Ciudad ciudad;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name = "no_documento", nullable = false, length = 50)
    private String noDocumento;

    @Column(name = "telefono_fijo", nullable = false, length = 10)
    private String telefonoFijo;

    @Column(name = "telefono_celular", nullable = false, length = 10)
    private String telefonoCelular;

    @Column(name = "tipo_persona", nullable = false, length = 50)
    private String tipoPersona;

    @Column(name = "estado", nullable = false, length = 1)
    private boolean estado;
}
