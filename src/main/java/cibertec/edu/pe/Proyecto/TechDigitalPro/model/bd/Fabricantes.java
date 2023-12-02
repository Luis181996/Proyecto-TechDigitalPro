package cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fabricantes")
public class Fabricantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "nombre")
    private String nombre;
    @Column (name = "pais")
    private String pais;
    @Column (name = "sitio_web")
    private String sitio_web;
}
