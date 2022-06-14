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
import sistema.modelo.pago;
import sistema.modelo.producto;

/**
 *
 * @author wcaba
 */
public class ctlpago {
    private conexion sql = new conexion();
    private Connection con = sql.getConexion();
    private String sSQL=""; //variable para almacenar cadena de conexion
    public Integer totalregistros;
    
    
    public DefaultTableModel mostrar (String buscar){
        DefaultTableModel modelo; //variable tipo defaultTableModel
        String [] titulos = {"ID","Idreserva","Tipo_Comprobante","Num_Comprobante","IGV","Total_Pago","Fecha_Emisión","Fecha_Pago"};
        
        String [] registro= new String [8];
        totalregistros=0;
        modelo= new DefaultTableModel(null,titulos);
        
        sSQL="SELECT * from pago where idreserva=" + buscar + " order by idpago desc"; //el "desc" es de manera descendiente, para que los productos mas recientes aparezcan al inicio
        
        try {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idpago");
                registro [1] = rs.getString("idreserva");
                registro [2] = rs.getString("tipo_comprobante");
                registro [3] = rs.getString("num_comprobante");
                registro [4] = rs.getString("igv");
                registro [5] = rs.getString("total_pago");
                registro [6] = rs.getString("fecha_emision");
                registro [7] = rs.getString("fecha_pago");
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(pago dts){
        sSQL="INSERT INTO pago (idreserva,tipo_comprobante,num_comprobante,igv,total_pago,fecha_emision,fecha_pago)"+
               "VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sSQL);
            ps.setInt(1, dts.getIdreserva());
            ps.setString(2, dts.getTipo_comprobante());
            ps.setString(3, dts.getNum_comprobante());
            ps.setDouble(4, dts.getIgv());
            ps.setDouble(5, dts.getTotal_pago());
            ps.setDate(6, dts.getFecha_emision());
            ps.setDate(7, dts.getFecha_pago());
            
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
    
    public boolean modificar(pago dts){
        sSQL="UPDATE pago set idreserva=?,tipo_comprobante=?,num_comprobante=?,igv=?,total_pago=?,fecha_emision=?,fecha_pago=?"+
                "where idpago=?";       //le enviamos el valor a modificar "idpago"
        try{
            PreparedStatement ps = con.prepareStatement(sSQL);
            
            ps.setInt(1, dts.getIdreserva());
            ps.setString(2, dts.getTipo_comprobante());
            ps.setString(3, dts.getNum_comprobante());
            ps.setDouble(4, dts.getIgv());
            ps.setDouble(5, dts.getTotal_pago());
            ps.setDate(6, dts.getFecha_emision());
            ps.setDate(7, dts.getFecha_pago());
            ps.setInt(8, dts.getIdpago());
            
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
    
    public boolean eliminar(pago dts){
        sSQL="Delete from pago where idpago=?"; //le indica con el where que pago borrar, en este caso con el "idpago"
        
        try{
            PreparedStatement ps = con.prepareStatement(sSQL);
            
            ps.setInt(1, dts.getIdpago());
            
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
}
