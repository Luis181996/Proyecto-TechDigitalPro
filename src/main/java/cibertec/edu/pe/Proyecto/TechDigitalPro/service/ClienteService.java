package cibertec.edu.pe.Proyecto.TechDigitalPro.service;

import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Cliente;
import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Ventas;
import cibertec.edu.pe.Proyecto.TechDigitalPro.model.request.ClienteRequest;
import cibertec.edu.pe.Proyecto.TechDigitalPro.repository.ClientesRepository;
import cibertec.edu.pe.Proyecto.TechDigitalPro.repository.VentasRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClientesRepository clientesRepository;

    private VentasRepository ventasRepository;

    private VentasService ventasService;
    public List<Cliente> listarClientes(){
        return clientesRepository.findAll();
    }

    @Transactional
    public Boolean guardarCliente(ClienteRequest clienteRequest) {
        try {
            Cliente cliente = new Cliente();
            cliente.setIdclientes(clienteRequest.getIdclientes());
            cliente.setNombre(clienteRequest.getNombre());
            cliente.setApellidos(clienteRequest.getApellidos());
            cliente.setDireccion(clienteRequest.getDireccion());
            cliente.setCorreo_electronico(clienteRequest.getCorreo_electronico());
            cliente.setTelefono(clienteRequest.getTelefono());
            Cliente registrarcliente = clientesRepository.save(cliente);

            Ventas ventas = new Ventas();
            ventas.setIdventas(clienteRequest.getIdventas());
            ventas.setFecha(clienteRequest.getFecha());
            ventas.setCantidad(clienteRequest.getCantidad());
            ventas.setPreciototal(clienteRequest.getPreciototal());

            // Set the correct idventas for Ventas
            ventas.setIdventas(registrarcliente.getIdclientes());

            ventas.setCliente(cliente);
            ventasService.registrar(ventas);

            return registrarcliente.getIdclientes() > 0;
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            return false;
        }
    }

}