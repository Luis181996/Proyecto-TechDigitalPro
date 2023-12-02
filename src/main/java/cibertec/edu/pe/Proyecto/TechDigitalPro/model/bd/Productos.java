package cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "nombre")
    private String nombre;
    @Column (name = "descripcion")
    private String descripcion;
    @Column (name = "precio")
    private Double precio;
    @Column (name = "stock")
    private Integer stock;
}
