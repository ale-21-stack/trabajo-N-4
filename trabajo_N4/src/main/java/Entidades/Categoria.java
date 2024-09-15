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
@ToString
@Entity
@Table
@Audited

public class Categoria implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(name = "Denominacion")
private String denomicion;

@ManyToMany(mappedBy = "categorias")
private List<Articulo > articulos = new ArrayList<Articulo>();




}
