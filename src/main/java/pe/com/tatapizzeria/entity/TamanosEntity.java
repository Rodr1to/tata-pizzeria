package pe.com.tatapizzeria.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "TamanosEntity")
@Table(name = "tamanos")
public class TamanosEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_tamano")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 30, nullable = false, unique = true)
    private String nombre;

    @Column(name = "porciones_estimadas", nullable = false)
    private Integer porcionesEstimadas;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}