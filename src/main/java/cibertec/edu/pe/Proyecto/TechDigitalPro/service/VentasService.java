package cibertec.edu.pe.Proyecto.TechDigitalPro.service;

import cibertec.edu.pe.Proyecto.TechDigitalPro.repository.VentasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VentasService {

    private VentasRepository ventasRepository;
}
