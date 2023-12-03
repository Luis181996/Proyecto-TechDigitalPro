package cibertec.edu.pe.Proyecto.TechDigitalPro.model.request;

import lombok.Data;

@Data
public class ProductoRequest {
    private Integer idproductos ;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
}
