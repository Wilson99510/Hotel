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
public class empleado extends usuario{
    Double sueldo;
    String acceso_sistema;
    String usuario;
    String contraseña;
    String estado_cuenta;

    public empleado(Double sueldo, String acceso_sistema, String usuario, String contraseña, String estado_cuenta) {
        this.sueldo = sueldo;
        this.acceso_sistema = acceso_sistema;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.estado_cuenta = estado_cuenta;
    }

    public empleado() {
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getAcceso_sistema() {
        return acceso_sistema;
    }

    public void setAcceso_sistema(String acceso_sistema) {
        this.acceso_sistema = acceso_sistema;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEstado_cuenta() {
        return estado_cuenta;
    }

    public void setEstado_cuenta(String estado_cuenta) {
        this.estado_cuenta = estado_cuenta;
    }
    
    
}
