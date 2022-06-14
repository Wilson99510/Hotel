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
import sistema.modelo.habitacion;

/**
 *
 * @author wcaba
 */
public class ctlhabitaciones {
    private conexion sql = new conexion();
    private Connection con = sql.getConexion();
    private String sSQL=""; //variable para almacenar cadena de conexion
    public Integer totalregistros;
    
    
    public DefaultTableModel mostrar (String buscar){
        DefaultTableModel modelo; //variable tipo defaultTableModel
        String [] titulos = {"ID","Número","Piso","Características","PrecioDiario","Estado","Tipo"};
        
        String [] registro= new String [7];
        totalregistros=0;
        modelo= new DefaultTableModel(null,titulos);
        
        sSQL="SELECT * from habitacion where piso like '%"+buscar+"%' order by idhabitacion";
        
        try {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idhabitacion");
                registro [1] = rs.getString("numero_habitacion");
                registro [2] = rs.getString("piso");
                registro [3] = rs.getString("caracteristicas");
                registro [4] = rs.getString("precio_diario");
                registro [5] = rs.getString("estado_habitacion");
                registro [6] = rs.getString("tipo_habitacion");
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(habitacion dts){
        sSQL="INSERT INTO habitacion (numero_habitacion,piso,caracteristicas,precio_diario,estado_habitacion,tipo_habitacion)"+
               "VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sSQL);
            ps.setString(1, dts.getNumero_habitacion());
            ps.setString(2, dts.getPiso());
            ps.setString(3, dts.getCaracteristicas());
            ps.setDouble(4, dts.getPrecio_diario());
            ps.setString(5, dts.getEstado_habitacion());
            ps.setString(6, dts.getTipo_habitacion());
            
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
    
    public boolean modificar(habitacion dts){
        sSQL="UPDATE habitacion set numero_habitacion=?,piso=?,caracteristicas=?,precio_diario=?,estado_habitacion=?,tipo_habitacion=?"+
                "where idhabitacion=?";
        try{
            PreparedStatement ps = con.prepareStatement(sSQL);
            
            ps.setString(1, dts.getNumero_habitacion());
            ps.setString(2, dts.getPiso());
            ps.setString(3, dts.getCaracteristicas());
            ps.setDouble(4, dts.getPrecio_diario());
            ps.setString(5, dts.getEstado_habitacion());
            ps.setString(6, dts.getTipo_habitacion());
            ps.setInt(7, dts.getIdhabitacion());
            
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
    
    public boolean eliminar(habitacion dts){
        sSQL="Delete from habitacion where idhabitacion=?"; //le indica con el where que habitacion borrar, en este caso con el "idhabitacion"
        
        try{
            PreparedStatement ps = con.prepareStatement(sSQL);
            
            ps.setInt(1, dts.getIdhabitacion());
            
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
    
    public DefaultTableModel mostrar_vista (String buscar){
        DefaultTableModel modelo; //variable tipo defaultTableModel
        String [] titulos = {"ID","Número","Piso","Características","PrecioDiario","Estado","Tipo"};
        
        String [] registro= new String [7];
        totalregistros=0;
        modelo= new DefaultTableModel(null,titulos);
        
        sSQL="SELECT * from habitacion where piso like '%" + buscar + "%' order by idhabitacion"; 
        
        try {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idhabitacion");
                registro [1] = rs.getString("numero_habitacion");
                registro [2] = rs.getString("piso");
                registro [3] = rs.getString("caracteristicas");
                registro [4] = rs.getString("precio_diario");
                registro [5] = rs.getString("estado_habitacion");
                registro [6] = rs.getString("tipo_habitacion");
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
 
}


