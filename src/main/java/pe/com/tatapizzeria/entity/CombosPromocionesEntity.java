package pe.com.tatapizzeria.entity;

import java.io.Serializable;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "CombosPromocionesEntity")
@Table(name = "combos_promociones")
public class CombosPromocionesEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_combo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_combo", length = 100, nullable = false)
    private String nombreCombo;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "precio_combo", nullable = false)
    private Double precioCombo;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
