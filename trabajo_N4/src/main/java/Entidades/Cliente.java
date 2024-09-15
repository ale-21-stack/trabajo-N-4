package Entidades;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
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
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = " Apellido ")
    private String apellido;

    @Column(name = "DNI", unique = true)
    private int dni;

    @Column(name = "Nombre")
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "cliente")
    @Column(name = "Factura")
    @Builder.Default
    private List<Factura> facturas = new ArrayList<Factura>();


}
