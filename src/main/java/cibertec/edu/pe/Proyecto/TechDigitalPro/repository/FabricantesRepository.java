package cibertec.edu.pe.Proyecto.TechDigitalPro.repository;

import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Fabricantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricantesRepository extends JpaRepository<Fabricantes, Integer> {
}
