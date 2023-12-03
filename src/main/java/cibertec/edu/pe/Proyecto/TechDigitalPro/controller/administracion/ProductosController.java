package cibertec.edu.pe.Proyecto.TechDigitalPro.controller.administracion;

import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Productos;
import cibertec.edu.pe.Proyecto.TechDigitalPro.model.request.ProductoRequest;
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
    public String frmproductos(Model model) {
        model.addAttribute("listar", productosService.listaproductos());
        return "administracion/productos";
    }

    @PostMapping("/registrar")
    @ResponseBody
    public ResultadoResponse registrarProductos(
            @RequestBody Productos objProductos
    ) {
        return productosService.registrarActualizarProducto(objProductos);
    }
    @DeleteMapping("/eliminar")
    @ResponseBody
    public ResultadoResponse eliminarproducto(@RequestBody ProductoRequest productoRequest) {
        String mensaje = "Eliminado tu producto";
        Boolean respuesta = true;
        try{
            productosService.eliminarproducto(productoRequest.getIdproductos());
        }catch (Exception ex ){
            mensaje="Error al eliminar";
            respuesta=false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}

