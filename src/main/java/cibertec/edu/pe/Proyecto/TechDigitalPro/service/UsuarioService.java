package cibertec.edu.pe.Proyecto.TechDigitalPro.service;

import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Rol;
import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Usuario;
import cibertec.edu.pe.Proyecto.TechDigitalPro.repository.RolRepository;
import cibertec.edu.pe.Proyecto.TechDigitalPro.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder =
            new BCryptPasswordEncoder();
    public Usuario findByNomusuario(String nomusuario){
        return usuarioRepository.findByNomusuario(nomusuario);
    }
    public Usuario saveUser(Usuario usuario){
        usuario.setPassword(
                bCryptPasswordEncoder.encode(usuario.getPassword())
        );
        Rol usuarioRol = rolRepository.findByNomrol("USER");
        usuario.setActivo(true);
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        return usuarioRepository.save(usuario);
    }


}
