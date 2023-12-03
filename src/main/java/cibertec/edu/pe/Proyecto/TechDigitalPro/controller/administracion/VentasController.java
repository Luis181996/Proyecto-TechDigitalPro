package cibertec.edu.pe.Proyecto.TechDigitalPro.controller.administracion;

import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Fabricantes;
import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Ventas;
import cibertec.edu.pe.Proyecto.TechDigitalPro.model.response.ResultadoResponse;
import cibertec.edu.pe.Proyecto.TechDigitalPro.service.VentasService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ventas")
@AllArgsConstructor
public class VentasController {

    private VentasService ventasService;

    @GetMapping("")
    public String frmventas(Model model){
        model.addAttribute("listar",ventasService.listaventas());
        return "administracion/ventas";
    }
    @GetMapping("/listadoventas")
    @ResponseBody
    private List<Ventas> listarventas(){
        return ventasService.listaventas();
    }


}
