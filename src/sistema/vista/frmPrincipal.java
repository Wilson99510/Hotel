/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.vista;

/**
 *
 * @author wcaba
 */
public class frmPrincipal extends javax.swing.JFrame {

    /** Creates new form frmPrincipal */
    public frmPrincipal() {
        initComponents();
        this.setExtendedState(frmPrincipal.MAXIMIZED_BOTH); //Con esta instruccion le decimos que el formulario ocupe toda la pantalla
        this.setTitle("SISTEMA RESERVA DE HABITACIONES - VIP PALACE HOTEL"); //Le agregamos un titulo al formulario
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        etiIdpersona = new javax.swing.JLabel();
        etiNombre = new javax.swing.JLabel();
        etiApellido = new javax.swing.JLabel();
        etiAcceso = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mnuArchivos = new javax.swing.JMenu();
        mnuItemhabitaciones = new javax.swing.JMenuItem();
        mnuItemproductos = new javax.swing.JMenuItem();
        mnuReservas = new javax.swing.JMenu();
        mnuItemreservasyconsumos = new javax.swing.JMenuItem();
        mnuItemclientes = new javax.swing.JMenuItem();
        mnuConfiguracion = new javax.swing.JMenu();
        mnuItemusuariosyaccesos = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Escritorio.setBackground(new java.awt.Color(102, 102, 102));
        Escritorio.setForeground(new java.awt.Color(255, 255, 255));

        etiIdpersona.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        etiIdpersona.setForeground(new java.awt.Color(255, 255, 255));
        etiIdpersona.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Escritorio.add(etiIdpersona);
        etiIdpersona.setBounds(10, 40, 150, 20);

        etiNombre.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        etiNombre.setForeground(new java.awt.Color(255, 255, 255));
        etiNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Escritorio.add(etiNombre);
        etiNombre.setBounds(10, 70, 150, 20);

        etiApellido.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        etiApellido.setForeground(new java.awt.Color(255, 255, 255));
        etiApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Escritorio.add(etiApellido);
        etiApellido.setBounds(10, 100, 150, 20);

        etiAcceso.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        etiAcceso.setForeground(new java.awt.Color(255, 255, 255));
        etiAcceso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Escritorio.add(etiAcceso);
        etiAcceso.setBounds(10, 130, 150, 20);

        mnuArchivos.setMnemonic('e');
        mnuArchivos.setText("Archivos");

        mnuItemhabitaciones.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        mnuItemhabitaciones.setMnemonic('t');
        mnuItemhabitaciones.setText("Habitaciones");
        mnuItemhabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemhabitacionesActionPerformed(evt);
            }
        });
        mnuArchivos.add(mnuItemhabitaciones);

        mnuItemproductos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mnuItemproductos.setMnemonic('y');
        mnuItemproductos.setText("Productos");
        mnuItemproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemproductosActionPerformed(evt);
            }
        });
        mnuArchivos.add(mnuItemproductos);

        menuBar.add(mnuArchivos);

        mnuReservas.setMnemonic('h');
        mnuReservas.setText("Reservas");

        mnuItemreservasyconsumos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mnuItemreservasyconsumos.setMnemonic('c');
        mnuItemreservasyconsumos.setText("Reservas y Consumos");
        mnuItemreservasyconsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemreservasyconsumosActionPerformed(evt);
            }
        });
        mnuReservas.add(mnuItemreservasyconsumos);

        mnuItemclientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mnuItemclientes.setMnemonic('a');
        mnuItemclientes.setText("Clientes");
        mnuItemclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemclientesActionPerformed(evt);
            }
        });
        mnuReservas.add(mnuItemclientes);

        menuBar.add(mnuReservas);

        mnuConfiguracion.setText("Configuraci??n");

        mnuItemusuariosyaccesos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        mnuItemusuariosyaccesos.setText("Usuarios y Accesos");
        mnuItemusuariosyaccesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemusuariosyaccesosActionPerformed(evt);
            }
        });
        mnuConfiguracion.add(mnuItemusuariosyaccesos);

        menuBar.add(mnuConfiguracion);

        mnuAyuda.setText("Ayuda");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Acerca de..");
        mnuAyuda.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Ayuda");
        mnuAyuda.add(jMenuItem4);

        menuBar.add(mnuAyuda);

        mnuSalir.setText("Salir");
        mnuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSalirMouseClicked(evt);
            }
        });
        menuBar.add(mnuSalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1241, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuItemclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemclientesActionPerformed
        // TODO add your handling code here:
        frmCliente frmc = new frmCliente();                //instanciamos el frmCliente con el objeto frmc
        Escritorio.add(frmc);                              //le agregamos el objeto frmc al Escritorio
        frmc.toFront();                                    //le decimos que aparezca en frente
        frmc.setVisible(true);                             //le decimos que este visible
    }//GEN-LAST:event_mnuItemclientesActionPerformed

    private void mnuItemhabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemhabitacionesActionPerformed
        // TODO add your handling code here:
        frmhabitaciones frmh = new frmhabitaciones();      //instanciamos el frmhabitaciones con el objeto frmh
        Escritorio.add(frmh);                              //le agregamos el objeto frmh al Escritorio
        frmh.toFront();                                    //le decimos que aparezca en frente
        frmh.setVisible(true);                             //le decimos que este visible
    }//GEN-LAST:event_mnuItemhabitacionesActionPerformed

    private void mnuItemproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemproductosActionPerformed
        // TODO add your handling code here:
        frmProducto frmp = new frmProducto();              //instanciamos el frmProducto con el objeto frmp
        Escritorio.add(frmp);                              //le agregamos el objeto frmp al Escritorio
        frmp.toFront();                                    //le decimos que aparezca en frente
        frmp.setVisible(true);                             //le decimos que este visible
    }//GEN-LAST:event_mnuItemproductosActionPerformed

    private void mnuItemusuariosyaccesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemusuariosyaccesosActionPerformed
        // TODO add your handling code here:
        frmEmpleado frme = new frmEmpleado();              //instanciamos el frmEmpleado con el objeto frme
        Escritorio.add(frme);                              //le agregamos el objeto frme al Escritorio
        frme.toFront();                                    //le decimos que aparezca en frente
        frme.setVisible(true);                             //le decimos que este visible
    }//GEN-LAST:event_mnuItemusuariosyaccesosActionPerformed

    private void mnuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_mnuSalirMouseClicked

    private void mnuItemreservasyconsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemreservasyconsumosActionPerformed
        // TODO add your handling code here:
        frmReserva frmr = new frmReserva();                //instanciamos el frmReserva con el objeto frmr
        Escritorio.add(frmr);                              //le agregamos el objeto frmr al Escritorio
        frmr.toFront();                                    //le decimos que aparezca en frente
        frmr.setVisible(true);                             //le decimos que este visible
        frmReserva.txtIdempleado.setText(etiIdpersona.getText());
        frmReserva.txtNombre_empleado.setText(etiNombre.getText()+ " " + etiApellido.getText());
        frmReserva.idusuario=Integer.parseInt(etiIdpersona.getText());
    }//GEN-LAST:event_mnuItemreservasyconsumosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane Escritorio;
    public static javax.swing.JLabel etiAcceso;
    public static javax.swing.JLabel etiApellido;
    public static javax.swing.JLabel etiIdpersona;
    public static javax.swing.JLabel etiNombre;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuBar menuBar;
    public static javax.swing.JMenu mnuArchivos;
    private javax.swing.JMenu mnuAyuda;
    public static javax.swing.JMenu mnuConfiguracion;
    private javax.swing.JMenuItem mnuItemclientes;
    private javax.swing.JMenuItem mnuItemhabitaciones;
    private javax.swing.JMenuItem mnuItemproductos;
    private javax.swing.JMenuItem mnuItemreservasyconsumos;
    private javax.swing.JMenuItem mnuItemusuariosyaccesos;
    private javax.swing.JMenu mnuReservas;
    private javax.swing.JMenu mnuSalir;
    // End of variables declaration//GEN-END:variables

}
