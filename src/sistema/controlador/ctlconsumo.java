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
import sistema.modelo.consumo;


/**
 *
 * @author wcaba
 */
public class ctlconsumo {
    private conexion sql = new conexion();
    private Connection con = sql.getConexion();
    private String sSQL=""; //variable para almacenar cadena de conexion
    public Integer totalregistros;
    public Double totalconsumo;     //se declara una variable de tipo Double llamada totalconsumo
    
    
    public DefaultTableModel mostrar (String buscar){
        DefaultTableModel modelo; //variable tipo defaultTableModel
        String [] titulos = {"ID","Idreserva","Idproducto","Nombre_Producto","Cantidad","Precio_Venta","Estado"};
        
        String [] registro= new String [7];
        totalregistros=0;
        totalconsumo=0.0;
        modelo= new DefaultTableModel(null,titulos);
        
        sSQL="SELECT c.idconsumo,c.idreserva,c.idproducto,p.nombre,c.cantidad,c.precio_venta "
                + " ,c.estado from consumo c inner join producto p on c.idproducto=p.idproducto"
                + " where c.idreserva="+buscar+" order by c.idconsumo desc"; //el "desc" es de manera descendiente, para que los productos mas recientes aparezcan al inicio
        
        try {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idconsumo");
                registro [1] = rs.getString("idreserva");
                registro [2] = rs.getString("idproducto");
                registro [3] = rs.getString("nombre");
                registro [4] = rs.getString("cantidad");
                registro [5] = rs.getString("precio_venta");
                registro [6] = rs.getString("estado");
                
                totalregistros = totalregistros+1;
                totalconsumo = totalconsumo+(rs.getDouble("cantidad") * rs.getDouble("precio_venta")); //cantidad de compra multiplica por el precio de venta
                modelo.addRow(registro);
            }
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(consumo dts){
        sSQL="INSERT INTO consumo (idreserva,idproducto,cantidad,precio_venta,estado)"+
               "VALUES (?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sSQL);
            ps.setInt(1, dts.getIdreserva());
            ps.setInt(2, dts.getIdproducto());
            ps.setDouble(3, dts.getCantidad());
            ps.setDouble(4, dts.getPrecio_venta());
            ps.setString(5, dts.getEstado());
            
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
    
    public boolean modificar(consumo dts){
        sSQL="UPDATE consumo set idreserva=?,idproducto=?,cantidad=?,precio_venta=?,estado=?"+
                "where idconsumo=?";       //le enviamos el valor a modificar "idconsumo"
        try{
            PreparedStatement ps = con.prepareStatement(sSQL);
            
            ps.setInt(1, dts.getIdreserva());
            ps.setInt(2, dts.getIdproducto());
            ps.setDouble(3, dts.getCantidad());
            ps.setDouble(4, dts.getPrecio_venta());
            ps.setString(5, dts.getEstado());
            
            ps.setInt(6, dts.getIdconsumo());
            
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
    
    public boolean eliminar(consumo dts){
        sSQL="Delete from consumo where idconsumo=?"; //le indica con el where que consumo borrar, en este caso con el "idconsumo"
        
        try{
            PreparedStatement ps = con.prepareStatement(sSQL);
            
            ps.setInt(1, dts.getIdconsumo());
            
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
