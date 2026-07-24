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
@Entity(name = "UsuariosEntity")
@Table(name = "usuarios")
public class UsuariosEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_empleado", nullable = false, unique = true)
    private EmpleadosEntity empleado;

    @Column(name = "correo_electronico", length = 100, nullable = false, unique = true)
    private String correoElectronico;

    @Column(name = "contrasena_hash", length = 255, nullable = false)
    private String contrasenaHash;

    @Column(name = "rol", length = 30, nullable = false)
    private String rol;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @CreationTimestamp
    @Column(name = "fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro;
}
