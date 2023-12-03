package cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rol")
public class Rol {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer idrol;
     @Column(name = "nomrol")
     private String nomrol;
}
