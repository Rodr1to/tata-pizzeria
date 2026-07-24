package pe.com.tatapizzeria.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "PreciosVariantesEntity")
@Table(name = "precios_variantes")
public class PreciosVariantesEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_variante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private ProductosEntity producto;

    @ManyToOne
    @JoinColumn(name = "id_tamano", nullable = false)
    private TamanosEntity tamano;

    @Column(name = "precio_base", nullable = false)
    private Double precioBase;

    @Column(name = "stock_disponible", nullable = false)
    private Integer stockDisponible;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
