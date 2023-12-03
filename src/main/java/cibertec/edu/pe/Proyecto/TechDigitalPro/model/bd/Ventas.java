package cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idventas;

    @Column (name = "fecha")
    private Date fecha;

    @Column (name = "cantidad")
    private Integer cantidad;

    @Column (name = "preciototal")
    private Double preciototal;

    @ManyToOne
    @JoinColumn(name = "idclientes")
    private Cliente cliente;

}
