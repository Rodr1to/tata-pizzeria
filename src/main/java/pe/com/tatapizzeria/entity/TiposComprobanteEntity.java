package pe.com.tatapizzeria.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "TiposComprobanteEntity")
@Table(name = "tipos_comprobante")
public class TiposComprobanteEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_tipo_comprobante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 30, nullable = false, unique = true)
    private String nombre;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
