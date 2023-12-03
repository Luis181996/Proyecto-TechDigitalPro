package cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idclientes;
    @Column (name = "nombre")
    private String nombre;
    @Column (name = "apellidos")
    private String apellidos;
    @Column (name = "direccion")
    private String direccion;
    @Column (name = "correo_electronico")
    private String correo_electronico;
    @Column (name = "telefono")
    private String telefono;
    @ManyToOne
    @JoinColumn(name = "idproductos")
    private Productos productos;
}