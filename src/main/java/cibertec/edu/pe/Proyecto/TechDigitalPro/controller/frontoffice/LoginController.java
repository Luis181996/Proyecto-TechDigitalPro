package cibertec.edu.pe.Proyecto.TechDigitalPro.controller.frontoffice;

import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Usuario;
import cibertec.edu.pe.Proyecto.TechDigitalPro.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class LoginController {
    private UsuarioService usuarioService;
    @GetMapping("/login")
    public String login(){
        return "frontoffice/auth/login";
    }
    @GetMapping("/registrar")
    public String registro(){
        return "frontoffice/auth/registro";
    }
    @PostMapping("/guardarusuario")
    public String guardarUsuario(@ModelAttribute Usuario usuario){
        usuarioService.saveUser(usuario);
        return "redirect:/auth/login";
    }

    @GetMapping("/login-success")
    public String loginsuccess(){
        return "frontoffice/auth/dashboard";
    }
}
