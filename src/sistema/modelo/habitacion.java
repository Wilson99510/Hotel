/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelo;

/**
 *
 * @author wcaba
 */
public class habitacion {
    int idhabitacion;
    String numero_habitacion;
    String piso;
    String caracteristicas;
    Double precio_diario;
    String estado_habitacion;
    String tipo_habitacion;

    public habitacion(int idhabitacion, String numero_habitacion, String piso, String caracteristicas, Double precio_diario, String estado_habitacion, String tipo_habitacion) {
        this.idhabitacion = idhabitacion;
        this.numero_habitacion = numero_habitacion;
        this.piso = piso;
        this.caracteristicas = caracteristicas;
        this.precio_diario = precio_diario;
        this.estado_habitacion = estado_habitacion;
        this.tipo_habitacion = tipo_habitacion;
    }

    public habitacion() {
    }

    public int getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public String getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(String numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Double getPrecio_diario() {
        return precio_diario;
    }

    public void setPrecio_diario(Double precio_diario) {
        this.precio_diario = precio_diario;
    }

    public String getEstado_habitacion() {
        return estado_habitacion;
    }

    public void setEstado_habitacion(String estado_habitacion) {
        this.estado_habitacion = estado_habitacion;
    }

    public String getTipo_habitacion() {
        return tipo_habitacion;
    }

    public void setTipo_habitacion(String tipo_habitacion) {
        this.tipo_habitacion = tipo_habitacion;
    }

    

    
}
