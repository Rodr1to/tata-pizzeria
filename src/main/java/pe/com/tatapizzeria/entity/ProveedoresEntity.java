package pe.com.tatapizzeria.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "ProveedoresEntity")
@Table(name = "proveedores")
public class ProveedoresEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_proveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ruc", length = 11, nullable = false, unique = true)
    private String ruc;

    @Column(name = "razon_social", length = 150, nullable = false)
    private String razonSocial;

    @Column(name = "contacto_nombre", length = 100, nullable = false)
    private String contactoNombre;

    @Column(name = "telefono", length = 20, nullable = false)
    private String telefono;

    @Column(name = "correo_electronico", length = 100)
    private String correoElectronico;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
}
