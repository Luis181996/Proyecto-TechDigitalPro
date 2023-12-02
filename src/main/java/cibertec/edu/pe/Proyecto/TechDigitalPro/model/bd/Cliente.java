package cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
}
