package pe.com.tatapizzeria.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "DireccionesClienteEntity")
@Table(name = "direcciones_cliente")
public class DireccionesClienteEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_direccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClientesEntity cliente;

    @Column(name = "direccion_texto", length = 255, nullable = false)
    private String direccionTexto;

    @Column(name = "referencia", length = 255)
    private String referencia;

    @Column(name = "distrito", length = 50, nullable = false)
    private String distrito;

    @Column(name = "coordenadas_gps", length = 100)
    private String coordenadasGps;

    @Column(name = "etiqueta", length = 20, nullable = false)
    private String etiqueta;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
