package cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "fecha")
    private Date fecha;
    @Column (name = "producto_id")
    private Integer producto_id;
    @Column (name = "cliente_id")
    private Integer cliente_id;
    @Column (name = "cantidad")
    private Integer cantidad;
    @Column (name = "precio_total")
    private Boolean precio_total;
}
