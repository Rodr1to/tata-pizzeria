package pe.com.tatapizzeria.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "RepartidoresEntity")
@Table(name = "repartidores")
public class RepartidoresEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_repartidor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_sede", nullable = false)
    private SedesEntity sede;

    @Column(name = "nombre_completo", length = 100, nullable = false)
    private String nombreCompleto;

    @Column(name = "dni", length = 8, nullable = false, unique = true)
    private String dni;

    @Column(name = "telefono", length = 20, nullable = false)
    private String telefono;

    @Column(name = "tipo_vehiculo", length = 20, nullable = false)
    private String tipoVehiculo;

    @Column(name = "placa_vehiculo", length = 15)
    private String placaVehiculo;

    @Column(name = "estado_disponibilidad", length = 20, nullable = false)
    private String estadoDisponibilidad;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
}
