package Entidades;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Setter
@ToString
@Entity
@Table
@Audited
@NoArgsConstructor
@AllArgsConstructor

public class Factura implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = " Numero")
    private int numero;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "Total")
    private int total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Fk_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();


}