package cibertec.edu.pe.Proyecto.TechDigitalPro.controller.administracion;

import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Fabricantes;
import cibertec.edu.pe.Proyecto.TechDigitalPro.model.response.ResultadoResponse;
import cibertec.edu.pe.Proyecto.TechDigitalPro.service.FabricantesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fabricantes")
@AllArgsConstructor
public class FabricantesController {
    private FabricantesService fabricantesService;

    @GetMapping("")
    public String frmfabricantes(Model model){
        model.addAttribute("listar",fabricantesService.listafabricantes());
        return "administracion/fabricantes";
    }

    @PostMapping("/registrar")
    @ResponseBody
    public ResultadoResponse registrarFabricantes(
            @RequestBody Fabricantes objFabricantes
    ){
        return fabricantesService.registrarActualizarFabricante(objFabricantes);
    }
}
