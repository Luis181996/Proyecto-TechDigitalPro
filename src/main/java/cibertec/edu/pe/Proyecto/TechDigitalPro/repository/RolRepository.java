package cibertec.edu.pe.Proyecto.TechDigitalPro.repository;

import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Rol findByNomrol(String nomrol);
}
