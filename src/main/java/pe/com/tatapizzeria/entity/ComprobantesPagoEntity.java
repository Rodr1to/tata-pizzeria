package pe.com.tatapizzeria.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "ComprobantesPagoEntity")
@Table(name = "comprobantes_pago")
public class ComprobantesPagoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_comprobante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private PedidosEntity pedido;

    @ManyToOne
    @JoinColumn(name = "id_tipo_comprobante", nullable = false)
    private TiposComprobanteEntity tipoComprobante;

    @Column(name = "serie", length = 4, nullable = false)
    private String serie;

    @Column(name = "numero_correlativo", nullable = false)
    private Integer numeroCorrelativo;

    @Column(name = "fecha_emision")
    private LocalDateTime fechaEmision;

    @Column(name = "metodo_pago", length = 30, nullable = false)
    private String metodoPago;

    @Column(name = "monto_pagado", nullable = false)
    private Double montoPagado;

    @Column(name = "vuelto", nullable = false)
    private Double vuelto;

    @Column(name = "estado_pago", length = 20, nullable = false)
    private String estadoPago;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
