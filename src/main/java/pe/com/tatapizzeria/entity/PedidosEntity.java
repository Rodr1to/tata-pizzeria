package pe.com.tatapizzeria.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "PedidosEntity")
@Table(name = "pedidos")
public class PedidosEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClientesEntity cliente;

    @ManyToOne
    @JoinColumn(name = "id_sede", nullable = false)
    private SedesEntity sede;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuariosEntity usuario;

    @ManyToOne
    @JoinColumn(name = "id_direccion")
    private DireccionesClienteEntity direccion;

    @ManyToOne
    @JoinColumn(name = "id_repartidor")
    private RepartidoresEntity repartidor;

    @Column(name = "fecha_hora_pedido")
    private LocalDateTime fechaHoraPedido;

    @Column(name = "tipo_entrega", length = 20, nullable = false)
    private String tipoEntrega;

    @Column(name = "origen_pedido", length = 20, nullable = false)
    private String origenPedido;

    @Column(name = "monto_subtotal", nullable = false)
    private Double montoSubtotal;

    @Column(name = "costo_delivery", nullable = false)
    private Double costoDelivery;

    @Column(name = "monto_total", nullable = false)
    private Double montoTotal;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
