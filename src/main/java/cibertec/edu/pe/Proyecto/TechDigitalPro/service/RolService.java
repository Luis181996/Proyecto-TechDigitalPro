package cibertec.edu.pe.Proyecto.TechDigitalPro.service;

import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Rol;
import cibertec.edu.pe.Proyecto.TechDigitalPro.model.response.ResultadoResponse;
import cibertec.edu.pe.Proyecto.TechDigitalPro.repository.RolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RolService {
    private RolRepository rolRepository;
    public List<Rol> listarol(){
        return rolRepository.findAll();
    }
    public ResultadoResponse registrarActualizarRol(Rol rol) {
        String mensaje = "Rol registrado correctamente";
        boolean respuesta = true;
        try {
            Rol nuevoRol = new Rol();
            if (rol.getIdrol() > 0) {
                nuevoRol.setIdrol(rol.getIdrol());
            }
            nuevoRol.setNomrol(rol.getNomrol());
            rolRepository.save(nuevoRol);
        } catch (Exception ex) {
            mensaje = "Rol no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().respuesta(respuesta)
                .mensaje(mensaje).build();
    }
    public void eliminarrol(Integer id){
        rolRepository.deleteById(id);
    }
}
