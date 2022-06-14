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
public class cliente extends usuario{
    String codigo_cliente;

    public cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public cliente() {
    }

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }


    
    
}
