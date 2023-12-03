package cibertec.edu.pe.Proyecto.TechDigitalPro.service;

import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Ventas;
import cibertec.edu.pe.Proyecto.TechDigitalPro.repository.VentasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VentasService {

    private VentasRepository ventasRepository;

    public List<Ventas> listaventas(){
        return ventasRepository.findAll();
    }

    public Ventas registrar(Ventas ventas){
        return ventasRepository.save(ventas);
    }
}
