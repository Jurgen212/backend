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
@Table(name = "servicio_tutela")
public class ServicioTutela {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servicio_tutela_id", nullable = false, unique = true)
    private Integer servicioTutelaId;

    @ManyToOne
    @JoinColumn(name = "tutela_id", referencedColumnName = "tutela_id")
    private Tutela tutela;

    @ManyToOne
    @JoinColumn(name = "credencial_id", referencedColumnName = "credencial_id")
    private Credencial credencial;

    @Column(name = "estado", nullable = false, length = 1)
    private boolean estado;
}
