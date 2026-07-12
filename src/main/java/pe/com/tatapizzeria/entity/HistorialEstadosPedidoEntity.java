package pe.com.tatapizzeria.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "HistorialEstadosPedidoEntity")
@Table(name = "historial_estados_pedido")
public class HistorialEstadosPedidoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_historial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private PedidosEntity pedido;

    @Column(name = "estado", length = 30, nullable = false)
    private String estado;

    @Column(name = "fecha_hora_cambio")
    private LocalDateTime fechaHoraCambio;

    @ManyToOne
    @JoinColumn(name = "id_usuario_cambio", nullable = false)
    private UsuariosEntity usuarioCambio;
}
