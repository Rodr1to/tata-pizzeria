package pe.com.tatapizzeria.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "EmpleadosEntity")
@Table(name = "empleados")
public class EmpleadosEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_empleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_sede", nullable = false)
    private SedesEntity sede;

    @Column(name = "nombres", length = 50, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 50, nullable = false)
    private String apellidos;

    @Column(name = "dni", length = 8, nullable = false, unique = true)
    private String dni;

    @Column(name = "telefono", length = 20, nullable = false)
    private String telefono;

    @Column(name = "cargo", length = 50, nullable = false)
    private String cargo;

    @Column(name = "sueldo", nullable = false)
    private Double sueldo;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @CreationTimestamp
    @Column(name = "fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro;
}
