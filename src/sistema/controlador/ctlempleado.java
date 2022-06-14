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
import sistema.modelo.empleado;


/**
 *
 * @author wcaba
 */
public class ctlempleado {

    private conexion sql = new conexion();
    private Connection con = sql.getConexion();
    private String sSQL = ""; //variable para almacenar cadena de conexion
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo; //variable tipo defaultTableModel
        String[] titulos = {"ID", "Nombre", "Apellido","Tipo_Documento","Número_Documento","Dirección","Telefono","Correo","Sueldo","Acceso_Sistema","Usuario","Contraseña","Estado_Cuenta"};
        String[] registro = new String[13];
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT u.idpersona,u.nombre,u.apellido,u.tipo_documento,u.numero_documento,"+ //con la "u" le agregamos un prefijo para la tabla usuario
                "u.direccion,u.telefono,u.correo,e.sueldo,e.acceso_sistema,e.usuario,e.contraseña,e.estado_cuenta from usuario u inner join empleado e "+ //con el inner join unimos las tablas
                "on u.idpersona=e.idpersona where numero_documento like '%"+ 
                buscar + "%' order by idpersona desc"; //el "desc" es de manera descendiente, para que los usuarios mas recientes aparezcan al inicio

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("tipo_documento");
                registro[4] = rs.getString("numero_documento");
                registro[5] = rs.getString("direccion");
                registro[6] = rs.getString("telefono");
                registro[7] = rs.getString("correo");
                registro[8] = rs.getString("sueldo");
                registro[9] = rs.getString("acceso_sistema");
                registro[10] = rs.getString("usuario");
                registro[11] = rs.getString("contraseña");
                registro[12] = rs.getString("estado_cuenta");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(empleado dts) {
        sSQL = "INSERT INTO usuario (nombre,apellido,tipo_documento,numero_documento,direccion,telefono,correo)"
                + "VALUES (?,?,?,?,?,?,?)";
        sSQL2 = "INSERT INTO empleado (idpersona,sueldo,acceso_sistema,usuario,contraseña,estado_cuenta)"
                + "VALUES ((SELECT idpersona from usuario order by idpersona desc limit 1),?,?,?,?,?)"; //con el "limit 1" le digo que muestre el ultimo idpersona que se registro
                                                                                                          //y ese idpersona se almacena en la tabla empleado
        try {
            PreparedStatement ps = con.prepareStatement(sSQL);
            PreparedStatement ps2 = con.prepareStatement(sSQL2);    //la segunda instruccion SQL

            ps.setString(1, dts.getNombre());
            ps.setString(2, dts.getApellido());
            ps.setString(3, dts.getTipo_documento());
            ps.setString(4, dts.getNumero_documento());
            ps.setString(5, dts.getDireccion());
            ps.setString(6, dts.getTelefono());
            ps.setString(7, dts.getCorreo());

            ps2.setDouble(1, dts.getSueldo());
            ps2.setString(2, dts.getAcceso_sistema());
            ps2.setString(3, dts.getUsuario());
            ps2.setString(4, dts.getContraseña());
            ps2.setString(5, dts.getEstado_cuenta());

            int n = ps.executeUpdate(); //esta variable "n" va a guardar el resultado de ejecucion del Statement

            if (n != 0) {       //si es diferente a cero se va a insertar el registro
                int n2 = ps2.executeUpdate();

                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean modificar(empleado dts) {
        sSQL = "UPDATE usuario set nombre=?,apellido=?,tipo_documento=?,numero_documento=?,direccion=?,telefono=?,correo=?"
                + "where idpersona=?";       //le enviamos el valor a modificar "idpersona"
        sSQL2 = "UPDATE empleado set sueldo=?,acceso_sistema=?,usuario=?,contraseña=?,estado_cuenta=?"
                + "where idpersona=?";

        try {
            PreparedStatement ps = con.prepareStatement(sSQL);
            PreparedStatement ps2 = con.prepareStatement(sSQL2);    //la segunda instruccion SQL

            ps.setString(1, dts.getNombre());
            ps.setString(2, dts.getApellido());
            ps.setString(3, dts.getTipo_documento());
            ps.setString(4, dts.getNumero_documento());
            ps.setString(5, dts.getDireccion());
            ps.setString(6, dts.getTelefono());
            ps.setString(7, dts.getCorreo());
            ps.setInt(8, dts.getIdpersona());

            ps2.setDouble(1, dts.getSueldo());
            ps2.setString(2, dts.getAcceso_sistema());
            ps2.setString(3, dts.getUsuario());
            ps2.setString(4, dts.getContraseña());
            ps2.setString(5, dts.getEstado_cuenta());
            ps2.setInt(6, dts.getIdpersona());

            int n = ps.executeUpdate(); //esta variable "n" va a guardar el resultado de ejecucion del Statement

            if (n != 0) {       //si es diferente a cero se va a modificar el registro
                int n2 = ps2.executeUpdate();

                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(empleado dts) {
        sSQL = "Delete from empleado where idpersona=?"; //le indica con el where que empleado borrar, en este caso con el "idpersona"
        sSQL2 = "Delete from usuario where idpersona=?";

        try {
            PreparedStatement ps = con.prepareStatement(sSQL);
            PreparedStatement ps2 = con.prepareStatement(sSQL2);    //la segunda instruccion SQL

            ps.setInt(1, dts.getIdpersona());

            ps2.setInt(1, dts.getIdpersona());

            int n = ps.executeUpdate(); //esta variable "n" va a guardar el resultado de ejecucion del Statement

            if (n != 0) {       //si es diferente a cero se va a eliminar el registro
                int n2 = ps2.executeUpdate();

                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public DefaultTableModel login(String usuario,String contraseña) { //Va a recibir 2 parametros "usuario" y "contraseña"
        DefaultTableModel modelo; //variable tipo defaultTableModel
        String[] titulos = {"ID", "Nombre", "Apellido","Acceso_Sistema","Usuario","Contraseña","Estado_Cuenta"};
        String[] registro = new String[7];
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT u.idpersona,u.nombre,u.apellido,"+ //con la "u" le agregamos un prefijo para la tabla usuario
                "e.acceso_sistema,e.usuario,e.contraseña,e.estado_cuenta from usuario u inner join empleado e "+ //con el inner join unimos las tablas
                "on u.idpersona=e.idpersona where e.usuario='"+ //revisamos que el usuario esté registrado en la tabla empleado
                                                                            //buscamos con los parametros definidos "usuario" y "contraseña"
                                                                            //y tambien que la cuenta este activada
                usuario + "' and e.contraseña='" + contraseña + "' and e.estado_cuenta='A'"; 

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("acceso_sistema");
                registro[4] = rs.getString("usuario");
                registro[5] = rs.getString("contraseña");
                registro[6] = rs.getString("estado_cuenta");

                totalregistros = totalregistros + 1;        //Si tiene un registro ingresará al sistema
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
}
