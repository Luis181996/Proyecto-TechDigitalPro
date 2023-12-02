package cibertec.edu.pe.Proyecto.TechDigitalPro.controller.administracion;

import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Productos;
import cibertec.edu.pe.Proyecto.TechDigitalPro.model.response.ResultadoResponse;
import cibertec.edu.pe.Proyecto.TechDigitalPro.service.ProductosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductosController {
    private ProductosService productosService;

    @GetMapping("")
    public String frmproductos(Model model){
        model.addAttribute("listar",productosService.listaproductos());
        return "administracion/productos";
    }

    @PostMapping("/registrar")
    @ResponseBody
    public ResultadoResponse registrarProductos(
            @RequestBody Productos objProductos
    ){
        return productosService.registrarActualizarProducto(objProductos);
    }
}

