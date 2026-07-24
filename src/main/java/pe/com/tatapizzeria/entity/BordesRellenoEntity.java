package pe.com.tatapizzeria.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "BordesRellenoEntity")
@Table(name = "bordes_relleno")
public class BordesRellenoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_borde")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_borde", length = 50, nullable = false, unique = true)
    private String tipoBorde;

    @Column(name = "precio_adicional", nullable = false)
    private Double precioAdicional;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
