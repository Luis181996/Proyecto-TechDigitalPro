package cibertec.edu.pe.Proyecto.TechDigitalPro.repository;

import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos ,Integer> {
}
