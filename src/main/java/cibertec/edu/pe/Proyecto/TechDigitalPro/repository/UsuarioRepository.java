package cibertec.edu.pe.Proyecto.TechDigitalPro.repository;

import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNomusuario(String nomusuario);
}
