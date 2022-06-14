/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema.db.conexion;
import sistema.modelo.producto;
import sistema.modelo.reserva;

/**
 *
 * @author wcaba
 */
public class ctlreserva {
    private conexion sql = new conexion();
    private Connection con = sql.getConexion();
    private String sSQL=""; //variable para almacenar cadena de conexion
    public Integer totalregistros;
    
    
    public DefaultTableModel mostrar (String buscar){
        DefaultTableModel modelo; //variable tipo defaultTableModel
        String [] titulos = {"ID","Idhabitación","Número_Habitación","Idcliente","Nombre_Cliente","Idempleado","Nombre_Empleado","Tipo_Reserva","Fecha_Reserva","Fecha_Entrada","Fecha_Salida","Costo_Reserva","Estado"};
        
        String [] registro= new String [13]; //Tenemos 13 indices
        totalregistros=0;
        modelo= new DefaultTableModel(null,titulos);
        
        sSQL="SELECT r.idreserva,r.idhabitacion,h.numero_habitacion,r.idcliente,"+
                "(select nombre from usuario where idpersona=r.idcliente)as ncliente,"+
                "(select apellido from usuario where idpersona=r.idcliente)as apcliente,"+
                "r.idempleado,(select nombre from usuario where idpersona=r.idempleado)as nempleado,"+
                "(select apellido from usuario where idpersona=r.idempleado)as apempleado,"+
                "r.tipo_reserva,r.fecha_reserva,r.fecha_entrada,r.fecha_salida,"+
                "r.costo_reserva,r.estado from reserva r inner join habitacion h on r.idhabitacion=h.idhabitacion where r.fecha_reserva like '%"+buscar+"%' order by idreserva desc"; //el "desc" es de manera descendiente, para que las reservas mas recientes aparezcan al inicio
        
        try {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idreserva");
                registro [1] = rs.getString("idhabitacion");
                registro [2] = rs.getString("numero_habitacion");
                registro [3] = rs.getString("idcliente");
                registro [4] = rs.getString("ncliente")+ " "+ rs.getString("apcliente"); //ya que pedimos el nombre del cliente le concateno con un espacio
                                                                                         //en blanco y luego concatenamos con el apellido del cliente
                registro [5] = rs.getString("idempleado");
                registro [6] = rs.getString("nempleado")+ " "+ rs.getString("apempleado");//ya que pedimos el nombre del empleado le concateno con un espacio
                                                                                          //en blanco y luego concatenamos con el apellido del empleado
                registro [7] = rs.getString("tipo_reserva");
                registro [8] = rs.getString("fecha_reserva");
                registro [9] = rs.getString("fecha_entrada");
                registro [10] = rs.getString("fecha_salida");
                registro [11] = rs.getString("costo_reserva");
                registro [12] = rs.getString("estado");
                
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(reserva dts){
        sSQL="INSERT INTO reserva (idhabitacion,idcliente,idempleado,tipo_reserva,fecha_reserva,fecha_entrada,fecha_salida,costo_reserva,estado)"+
               "VALUES (?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sSQL);
            ps.setInt(1, dts.getIdhabitacion());
            ps.setInt(2, dts.getIdcliente());
            ps.setInt(3, dts.getIdempleado());
            ps.setString(4, dts.getTipo_reserva());
            ps.setDate(5, dts.getFecha_reserva());
            ps.setDate(6, dts.getFecha_entrada());
            ps.setDate(7, dts.getFecha_salida());
            ps.setDouble(8, dts.getCosto_reserva());
            ps.setString(9, dts.getEstado());
            
            int n = ps.executeUpdate(); //esta variable "n" va a guardar el resultado de ejecucion del Statement
            
            if(n!=0){       //si es diferente a cero se va a insertar el registro
                return true;
            }
            else{
                return false;  
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean modificar(reserva dts){
        sSQL="UPDATE reserva set idhabitacion=?,idcliente=?,idempleado=?,tipo_reserva=?,fecha_reserva=?,fecha_entrada=?,fecha_salida=?,costo_reserva=?,estado=?"+
                "where idreserva=?";       //le enviamos el valor a modificar "idrerseva"
        try{
            PreparedStatement ps = con.prepareStatement(sSQL);
            
            ps.setInt(1, dts.getIdhabitacion());
            ps.setInt(2, dts.getIdcliente());
            ps.setInt(3, dts.getIdempleado());
            ps.setString(4, dts.getTipo_reserva());
            ps.setDate(5, dts.getFecha_reserva());
            ps.setDate(6, dts.getFecha_entrada());
            ps.setDate(7, dts.getFecha_salida());
            ps.setDouble(8, dts.getCosto_reserva());
            ps.setString(9, dts.getEstado());
            ps.setInt(10, dts.getIdreserva());
            
            int n = ps.executeUpdate(); //esta variable "n" va a guardar el resultado de ejecucion del Statement
            
            if(n!=0){       //si es diferente a cero se va a modificar el registro
                return true;
            }
            else{
                return false;  
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean eliminar(reserva dts){
        sSQL="Delete from reserva where idreserva=?"; //le indica con el where que reserva borrar, en este caso con el "idreserva"
        
        try{
            PreparedStatement ps = con.prepareStatement(sSQL);
            
            ps.setInt(1, dts.getIdreserva());
            
            int n = ps.executeUpdate();
            
            if(n!=0){
                return true;
            }
            else{
                return false;  
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean pagar_reserva(reserva dts){
        sSQL="UPDATE reserva set estado='PAGADA'"+
                "where idreserva=?";       //le enviamos el valor a modificar "idrerseva"
        try{
            PreparedStatement ps = con.prepareStatement(sSQL);
            
            ps.setInt(1, dts.getIdreserva());
            
            int n = ps.executeUpdate(); //esta variable "n" va a guardar el resultado de ejecucion del Statement
            
            if(n!=0){       //si es diferente a cero se va a modificar el registro
                return true;
            }
            else{
                return false;  
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
