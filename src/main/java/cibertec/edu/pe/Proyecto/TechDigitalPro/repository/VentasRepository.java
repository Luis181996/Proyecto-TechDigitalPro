package cibertec.edu.pe.Proyecto.TechDigitalPro.repository;

import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer> {
}
