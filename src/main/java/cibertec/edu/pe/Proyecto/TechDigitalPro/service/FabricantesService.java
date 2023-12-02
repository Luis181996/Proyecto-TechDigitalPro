package cibertec.edu.pe.Proyecto.TechDigitalPro.service;

import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Fabricantes;
import cibertec.edu.pe.Proyecto.TechDigitalPro.model.response.ResultadoResponse;
import cibertec.edu.pe.Proyecto.TechDigitalPro.repository.FabricantesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FabricantesService {
    private FabricantesRepository fabricantesRepository;
    public List<Fabricantes>listafabricantes(){
        return fabricantesRepository.findAll();
    }
        public ResultadoResponse registrarActualizarFabricante(Fabricantes fabricantes) {
            String mensaje = "Fabricante registrado correctamente";
            boolean respuesta = true;
            try {
                Fabricantes nuevoFabricante = new Fabricantes();
                if (fabricantes.getId() > 0) {
                    nuevoFabricante.setId(fabricantes.getId());
                }
                nuevoFabricante.setNombre(fabricantes.getNombre());
                nuevoFabricante.setPais(fabricantes.getPais());
                nuevoFabricante.setSitio_web(fabricantes.getSitio_web());
                fabricantesRepository.save(nuevoFabricante);
            } catch (Exception ex) {
                mensaje = "Fabricante no registrado";
                respuesta = false;
            }
            return ResultadoResponse.builder().respuesta(respuesta)
                    .mensaje(mensaje).build();
        }

    }

