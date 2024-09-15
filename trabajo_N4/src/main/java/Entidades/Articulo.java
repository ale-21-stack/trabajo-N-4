package Entidades;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Setter
@ToString(exclude = "categorias") /*Tuve que agregar esto porque se me generaba una recursividad infinita*/
@Entity
@Table
@Audited

public class Articulo implements Serializable {
    @Column(name = "Cantidad")
    private int cantidad;

    @Column(name = "Denominacion")
    private String denominacion;

    @Column(name = "Precio")
    private int precio;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "articulo_categoria", joinColumns = @JoinColumn(name = "articulo_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    @Builder.Default
    private List<Categoria> categorias = new ArrayList<Categoria>();

    @OneToMany(mappedBy = "articulo")
    @Column(name = "Detalles de Facturas")
    @Builder.Default
    private List<DetalleFactura> detalleFacturas = new ArrayList<DetalleFactura>();


}
