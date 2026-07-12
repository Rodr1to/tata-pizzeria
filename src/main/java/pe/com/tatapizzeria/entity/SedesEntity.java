package pe.com.tatapizzeria.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "SedesEntity")
@Table(name = "sedes")

public class SedesEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_sede")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "direccion", length = 255, nullable = false)
    private String direccion;

    @Column(name = "telefono", length = 20, nullable = false)
    private String telefono;

    @Column(name = "ruc_sucursal", length = 11, nullable = false)
    private String rucSucursal;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
}