package pe.com.tatapizzeria.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "DetallePedidosEntity")
@Table(name = "detalle_pedidos")
public class DetallePedidosEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_detalle")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private PedidosEntity pedido;

    @ManyToOne
    @JoinColumn(name = "id_variante", nullable = false)
    private PreciosVariantesEntity variante;

    @ManyToOne
    @JoinColumn(name = "id_borde", nullable = false)
    private BordesRellenoEntity borde;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario_historico", nullable = false)
    private Double precioUnitarioHistorico;

    @Column(name = "precio_borde_historico", nullable = false)
    private Double precioBordeHistorico;

    @Column(name = "monto_subtotal", nullable = false)
    private Double montoSubtotal;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
