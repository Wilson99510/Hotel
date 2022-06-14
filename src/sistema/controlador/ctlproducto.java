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

/**
 *
 * @author wcaba
 */
public class ctlproducto {
    private conexion sql = new conexion();
    private Connection con = sql.getConexion();
    private String sSQL=""; //variable para almacenar cadena de conexion
    public Integer totalregistros;
    
    
    public DefaultTableModel mostrar (String buscar){
        DefaultTableModel modelo; //variable tipo defaultTableModel
        String [] titulos = {"ID","Producto","Descripción","Unidad Medida","Precio Venta"};
        
        String [] registro= new String [5];
        totalregistros=0;
        modelo= new DefaultTableModel(null,titulos);
        
        sSQL="SELECT * from producto where nombre like '%"+buscar+"%' order by idproducto desc"; //el "desc" es de manera descendiente, para que los productos mas recientes aparezcan al inicio
        
        try {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idproducto");
                registro [1] = rs.getString("nombre");
                registro [2] = rs.getString("descripcion");
                registro [3] = rs.getString("uni_medida");
                registro [4] = rs.getString("precio_venta");
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(producto dts){
        sSQL="INSERT INTO producto (nombre,descripcion,uni_medida,precio_venta)"+
               "VALUES (?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sSQL);
            ps.setString(1, dts.getNombre());
            ps.setString(2, dts.getDescripcion());
            ps.setString(3, dts.getUni_medida());
            ps.setDouble(4, dts.getPrecio_venta());
            
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
    
    public boolean modificar(producto dts){
        sSQL="UPDATE producto set nombre=?,descripcion=?,uni_medida=?,precio_venta=?"+
                "where idproducto=?";       //le enviamos el valor a modificar "idproducto"
        try{
            PreparedStatement ps = con.prepareStatement(sSQL);
            
            ps.setString(1, dts.getNombre());
            ps.setString(2, dts.getDescripcion());
            ps.setString(3, dts.getUni_medida());
            ps.setDouble(4, dts.getPrecio_venta());
            ps.setInt(5, dts.getIdproducto());
            
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
    
    public boolean eliminar(producto dts){
        sSQL="Delete from producto where idproducto=?"; //le indica con el where que producto borrar, en este caso con el "idproducto"
        
        try{
            PreparedStatement ps = con.prepareStatement(sSQL);
            
            ps.setInt(1, dts.getIdproducto());
            
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
