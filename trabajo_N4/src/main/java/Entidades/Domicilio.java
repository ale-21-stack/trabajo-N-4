package Entidades;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;


@AllArgsConstructor
@Getter
@Builder
@Setter
@ToString
@Entity
@Table
@Audited
@NoArgsConstructor
public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre:calle")
    private String nombreCalle;

    @Column(name = "numero")
    private int numero;

    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;


}