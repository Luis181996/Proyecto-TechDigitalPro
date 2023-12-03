package cibertec.edu.pe.Proyecto.TechDigitalPro.model.request;
import lombok.Data;

import java.util.Date;

@Data
public class ClienteRequest {
    private Integer idclientes;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String correo_electronico;
    private String telefono;
    private Integer idventas;
    private Date fecha;
    private Integer cantidad;
    private Double preciototal;
}