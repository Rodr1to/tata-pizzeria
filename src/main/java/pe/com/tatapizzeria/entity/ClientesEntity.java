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
@Entity(name = "ClientesEntity")
@Table(name = "clientes")
public class ClientesEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres", length = 50, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 50, nullable = false)
    private String apellidos;

    @Column(name = "telefono_whatsapp", length = 20, nullable = false, unique = true)
    private String telefonoWhatsapp;

    @Column(name = "correo_electronico", length = 100)
    private String correoElectronico;

    @Column(name = "tipo_documento", length = 10, nullable = false)
    private String tipoDocumento;

    @Column(name = "numero_documento", length = 11, nullable = false)
    private String numeroDocumento;

    @Column(name = "puntos_fidelidad")
    private Integer puntosFidelidad;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @CreationTimestamp
    @Column(name = "fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro;
}
