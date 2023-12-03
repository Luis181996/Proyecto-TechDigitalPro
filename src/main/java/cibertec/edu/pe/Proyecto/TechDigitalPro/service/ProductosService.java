package cibertec.edu.pe.Proyecto.TechDigitalPro.service;

import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Fabricantes;
import cibertec.edu.pe.Proyecto.TechDigitalPro.model.bd.Productos;
import cibertec.edu.pe.Proyecto.TechDigitalPro.model.response.ResultadoResponse;
import cibertec.edu.pe.Proyecto.TechDigitalPro.repository.FabricantesRepository;
import cibertec.edu.pe.Proyecto.TechDigitalPro.repository.ProductosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductosService {
    private ProductosRepository productosRepository;
    public List<Productos> listaproductos(){
        return productosRepository.findAll();
    }
    public ResultadoResponse registrarActualizarProducto(Productos productos) {
        String mensaje = "Producto registrado correctamente";
        boolean respuesta = true;
        try {
            Productos nuevoProductos = new Productos();
            if (productos.getIdproductos() > 0) {
                nuevoProductos.setIdproductos(productos.getIdproductos());
            }
            nuevoProductos.setNombre(productos.getNombre());
            nuevoProductos.setDescripcion(productos.getDescripcion());
            nuevoProductos.setPrecio(productos.getPrecio());
            nuevoProductos.setStock(productos.getStock());
            productosRepository.save(nuevoProductos);
        } catch (Exception ex) {
            mensaje = "Producto no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().respuesta(respuesta)
                .mensaje(mensaje).build();
    }
    public void eliminarproducto(Integer id){
        productosRepository.deleteById(id);
    }

}


