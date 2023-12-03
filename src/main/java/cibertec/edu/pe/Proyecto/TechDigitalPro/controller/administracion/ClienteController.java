package cibertec.edu.pe.Proyecto.TechDigitalPro.controller.administracion;

import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Cliente;
import cibertec.edu.pe.Proyecto.TechDigitalPro.model.request.ClienteRequest;
import cibertec.edu.pe.Proyecto.TechDigitalPro.model.response.ResultadoResponse;
import cibertec.edu.pe.Proyecto.TechDigitalPro.service.ClienteService;
import cibertec.edu.pe.Proyecto.TechDigitalPro.service.VentasService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    private VentasService ventasService;
    @GetMapping("/listarclientes")
    public String listadototal(Model model){
        model.addAttribute("listadocliente", clienteService.listarClientes());
        model.addAttribute("listadoventa", ventasService.listaventas());
        return "administracion/clientes";
    }
    @GetMapping("/frmcliente")
    @ResponseBody
    public String frmcliente(){
        return "administracion/clientes";

    }

    @GetMapping("/listarcliente")
    @ResponseBody
    public List<Cliente> listarcliente(){
        return clienteService.listarClientes();
    }

    @PostMapping("/guardarcliente")
    @ResponseBody
    public ResultadoResponse guardarCliente(@RequestBody ClienteRequest clienteRequest){
        String mensaje = "";
        Boolean respuesta;
        respuesta = clienteService.guardarCliente(clienteRequest);
        mensaje = respuesta ? "Se realizo la transacción correctamente" : "Error en la transacción";
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}