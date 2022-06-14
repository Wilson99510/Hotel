/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.vista;

import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema.controlador.ctlhabitaciones;
import sistema.controlador.ctlreserva;
import sistema.modelo.habitacion;
import sistema.modelo.reserva;

/**
 *
 * @author wcaba
 */
public class frmReserva extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmReserva
     */
    public frmReserva() {
        initComponents();
        mostrar("");
        deshabilitar();
    }
    
    private String accion ="guardar"; //se declara una variable de tipo String para determinar una accion
    public static int idusuario;      //se declara una variable de tipo Int para trabajar con el usuario que ingresa al sistema
    
    void ocultar_columnas(){        // la columna a no mostrar es de idreserva
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0); 
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0); 
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);
                                    // la columna a no mostrar es de idhabitacion
        tablalistado.getColumnModel().getColumn(1).setMaxWidth(0); 
        tablalistado.getColumnModel().getColumn(1).setMinWidth(0); 
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(0);
                                    // la columna a no mostrar es de idcliente
        tablalistado.getColumnModel().getColumn(3).setMaxWidth(0); 
        tablalistado.getColumnModel().getColumn(3).setMinWidth(0); 
        tablalistado.getColumnModel().getColumn(3).setPreferredWidth(0);
                                    // la columna a no mostrar es de idempleado
        tablalistado.getColumnModel().getColumn(5).setMaxWidth(0); 
        tablalistado.getColumnModel().getColumn(5).setMinWidth(0); 
        tablalistado.getColumnModel().getColumn(5).setPreferredWidth(0);
    }
    
    void deshabilitar(){      //metodo para deshabilitar botones
        txtIdreserva.setVisible(false);
        txtIdhabitacion.setVisible(false);
        txtIdcliente.setVisible(false);
        txtIdempleado.setVisible(false);
        
        txtNumero_habitacion.setEnabled(false);
        txtNombre_cliente.setEnabled(false);
        txtNombre_empleado.setEnabled(false);
        cboTipo_reserva.setEnabled(false);
        jDateFecha_reserva.setEnabled(false);
        jDateFecha_entrada.setEnabled(false);
        jDateFecha_salida.setEnabled(false);
        txtCosto_reserva.setEnabled(false);
        cboEstado_reserva.setEnabled(false);
        
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnBusca_habitacion.setEnabled(false);
        btnBusca_Nombrecliente.setEnabled(false);
        
        txtIdreserva.setText("");
        txtIdhabitacion.setText("");
        txtNumero_habitacion.setText("");
        txtIdcliente.setText("");
        txtIdempleado.setText("");
        txtCosto_reserva.setText("");
    }
    
    void habilitar(){       //metodo para habilitar botones
        txtIdreserva.setVisible(false);
        txtIdhabitacion.setVisible(false);
        txtIdcliente.setVisible(false);
        txtIdempleado.setVisible(false);
        
        txtNumero_habitacion.setEnabled(false);
        txtNombre_cliente.setEnabled(false);
        txtNombre_empleado.setEnabled(false);
        
        cboTipo_reserva.setEnabled(true);
        jDateFecha_reserva.setEnabled(true);
        jDateFecha_entrada.setEnabled(true);
        jDateFecha_salida.setEnabled(true);
        txtCosto_reserva.setEnabled(true);
        cboEstado_reserva.setEnabled(true);
        
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnBuscar.setEnabled(true);
        btnBusca_habitacion.setEnabled(true);
        btnBusca_Nombrecliente.setEnabled(true);
        
        txtIdreserva.setText("");
        txtIdhabitacion.setText("");
        txtNumero_habitacion.setText("");
        txtIdcliente.setText("");
        txtIdempleado.setText("");
        txtCosto_reserva.setText(""); 
    }
    
    void mostrar (String buscar){
        try {
            DefaultTableModel modelo;
            ctlreserva funcion= new ctlreserva();
            modelo = funcion.mostrar(buscar);
            
            tablalistado.setModel(modelo);
            ocultar_columnas();
            etiTotalregistros.setText("Total Registros: " + Integer.toString(funcion.totalregistros));
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        etiTotalregistros = new javax.swing.JLabel();
        btnVerconsumos = new javax.swing.JButton();
        btnRealizarpago = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtIdreserva = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIdhabitacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCosto_reserva = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboTipo_reserva = new javax.swing.JComboBox<>();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNumero_habitacion = new javax.swing.JTextField();
        txtIdcliente = new javax.swing.JTextField();
        txtNombre_cliente = new javax.swing.JTextField();
        txtIdempleado = new javax.swing.JTextField();
        txtNombre_empleado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jDateFecha_reserva = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jDateFecha_entrada = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jDateFecha_salida = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cboEstado_reserva = new javax.swing.JComboBox<>();
        btnBusca_habitacion = new javax.swing.JButton();
        btnBusca_Nombrecliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTADO DE RESERVAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablalistado);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Buscar:");

        txtBuscar.setBackground(new java.awt.Color(102, 102, 102));
        txtBuscar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(102, 102, 102));
        btnBuscar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(102, 102, 102));
        btnEliminar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(102, 102, 102));
        btnSalir.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        etiTotalregistros.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        etiTotalregistros.setForeground(new java.awt.Color(255, 255, 255));
        etiTotalregistros.setText("Registros");

        btnVerconsumos.setText("Ver Consumos");
        btnVerconsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerconsumosActionPerformed(evt);
            }
        });

        btnRealizarpago.setText("Realizar Pagos");
        btnRealizarpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarpagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnVerconsumos)
                .addGap(18, 18, 18)
                .addComponent(btnRealizarpago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etiTotalregistros)
                .addGap(59, 59, 59))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(btnSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnEliminar))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiTotalregistros)
                    .addComponent(btnVerconsumos)
                    .addComponent(btnRealizarpago))
                .addGap(30, 30, 30))
        );

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTRO DE RESERVAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setToolTipText("");

        txtIdreserva.setBackground(new java.awt.Color(102, 102, 102));
        txtIdreserva.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtIdreserva.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Habitación:");

        txtIdhabitacion.setBackground(new java.awt.Color(102, 102, 102));
        txtIdhabitacion.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtIdhabitacion.setForeground(new java.awt.Color(255, 255, 255));
        txtIdhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdhabitacionActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cliente:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tipo de Reserva:");

        txtCosto_reserva.setBackground(new java.awt.Color(102, 102, 102));
        txtCosto_reserva.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtCosto_reserva.setForeground(new java.awt.Color(255, 255, 255));
        txtCosto_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCosto_reservaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha de Reserva:");

        cboTipo_reserva.setBackground(new java.awt.Color(102, 102, 102));
        cboTipo_reserva.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cboTipo_reserva.setForeground(new java.awt.Color(255, 255, 255));
        cboTipo_reserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INDIVIDUAL", "VIP", "FAMILIAR" }));
        cboTipo_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipo_reservaActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(102, 102, 102));
        btnNuevo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(102, 102, 102));
        btnGuardar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(102, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtNumero_habitacion.setBackground(new java.awt.Color(102, 102, 102));
        txtNumero_habitacion.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtNumero_habitacion.setForeground(new java.awt.Color(255, 255, 255));
        txtNumero_habitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumero_habitacionActionPerformed(evt);
            }
        });

        txtIdcliente.setBackground(new java.awt.Color(102, 102, 102));
        txtIdcliente.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtIdcliente.setForeground(new java.awt.Color(255, 255, 255));
        txtIdcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdclienteActionPerformed(evt);
            }
        });

        txtNombre_cliente.setBackground(new java.awt.Color(102, 102, 102));
        txtNombre_cliente.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtNombre_cliente.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre_clienteActionPerformed(evt);
            }
        });

        txtIdempleado.setBackground(new java.awt.Color(102, 102, 102));
        txtIdempleado.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtIdempleado.setForeground(new java.awt.Color(255, 255, 255));
        txtIdempleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdempleadoActionPerformed(evt);
            }
        });

        txtNombre_empleado.setBackground(new java.awt.Color(102, 102, 102));
        txtNombre_empleado.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtNombre_empleado.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre_empleadoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Empleado:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Fecha de Entrada:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Fecha de Salida:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Costo de Reserva:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Estado de Reserva:");

        cboEstado_reserva.setBackground(new java.awt.Color(102, 102, 102));
        cboEstado_reserva.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cboEstado_reserva.setForeground(new java.awt.Color(255, 255, 255));
        cboEstado_reserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RESERVADA", "PAGADA", "CANCELADA", " " }));
        cboEstado_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEstado_reservaActionPerformed(evt);
            }
        });

        btnBusca_habitacion.setText("...");
        btnBusca_habitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusca_habitacionActionPerformed(evt);
            }
        });

        btnBusca_Nombrecliente.setText("...");
        btnBusca_Nombrecliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusca_NombreclienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCosto_reserva)
                                    .addComponent(cboEstado_reserva, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(jDateFecha_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDateFecha_entrada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jDateFecha_reserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboTipo_reserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtIdempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtIdcliente, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                                        .addComponent(txtIdhabitacion)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNombre_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                            .addComponent(txtNumero_habitacion))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnBusca_habitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnBusca_Nombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtNombre_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(95, 95, 95))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtIdreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btnNuevo)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(txtIdreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIdhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumero_habitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBusca_habitacion))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBusca_Nombrecliente)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIdempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(cboTipo_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jDateFecha_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel3))
                        .addGap(21, 21, 21)
                        .addComponent(jDateFecha_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDateFecha_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCosto_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cboEstado_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(146, 146, 146))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnGuardar.setText("Modificar");
        habilitar();
        btnEliminar.setEnabled(true);
        accion="modificar";
        int fila = tablalistado.rowAtPoint(evt.getPoint()); //punto o fila donde se hace clic en la variable fila
        txtIdreserva.setText(tablalistado.getValueAt(fila, 0).toString());
        txtIdhabitacion.setText(tablalistado.getValueAt(fila, 1).toString());
        txtNumero_habitacion.setText(tablalistado.getValueAt(fila, 2).toString());
        txtIdcliente.setText(tablalistado.getValueAt(fila, 3).toString());
        txtNombre_cliente.setText(tablalistado.getValueAt(fila, 4).toString());
        txtIdempleado.setText(tablalistado.getValueAt(fila, 5).toString());
        txtNombre_empleado.setText(tablalistado.getValueAt(fila, 6).toString());
        cboTipo_reserva.setSelectedItem(tablalistado.getValueAt(fila, 7).toString());
        jDateFecha_reserva.setDate(Date.valueOf(tablalistado.getValueAt(fila, 8).toString())); //Convertimos el dato a un tipo de dato Date
        jDateFecha_entrada.setDate(Date.valueOf(tablalistado.getValueAt(fila, 9).toString())); //Convertimos el dato a un tipo de dato Date
        jDateFecha_salida.setDate(Date.valueOf(tablalistado.getValueAt(fila, 10).toString())); //Convertimos el dato a un tipo de dato Date
        txtCosto_reserva.setText(tablalistado.getValueAt(fila, 11).toString());
        cboEstado_reserva.setSelectedItem(tablalistado.getValueAt(fila, 12).toString());
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //        // TODO add your handling code here:
        mostrar(txtBuscar.getText()); //le envia al metodo lo que se escribe en la caja de texto buscar
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if(!txtIdreserva.getText().equals("")) { // si no es igual a (espacio en blanco) se procede a eliminar el producto
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Desea Eliminar la Reserva?","Confirmar",2);

            if(confirmacion==0){
                ctlreserva funcion = new ctlreserva();
                reserva dts= new reserva();
                dts.setIdreserva(Integer.parseInt(txtIdreserva.getText()));
                funcion.eliminar(dts);
                mostrar("");
                deshabilitar(); //para desactivar todas las cajas
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose(); //para cerrar el formulario
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtIdhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdhabitacionActionPerformed
        // TODO add your handling code here:
        txtIdhabitacion.transferFocus();
    }//GEN-LAST:event_txtIdhabitacionActionPerformed

    private void txtCosto_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCosto_reservaActionPerformed
        // TODO add your handling code here:
        txtCosto_reserva.transferFocus();
    }//GEN-LAST:event_txtCosto_reservaActionPerformed

    private void cboTipo_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipo_reservaActionPerformed
        // TODO add your handling code here:
        cboTipo_reserva.transferFocus();
    }//GEN-LAST:event_cboTipo_reservaActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnGuardar.setText("Guardar");
        accion="guardar";
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtIdhabitacion.getText().length()== 0){
            JOptionPane.showConfirmDialog(rootPane, "Seleccionar una Habitación");
            txtIdhabitacion.requestFocus();
            return;
        }

        if (txtIdcliente.getText().length()== 0){
            JOptionPane.showConfirmDialog(rootPane, "Seleccionar un Cliente");
            txtIdcliente.requestFocus();
            return;
        }

        if (txtCosto_reserva.getText().length()== 0){
            JOptionPane.showConfirmDialog(rootPane, "Ingresar Costo de la Reserva");
            txtCosto_reserva.requestFocus();
            return;
        }

        reserva dts = new reserva();  //instanciamos la clase reserva para crear un nuevo objeto
        ctlreserva funcion = new ctlreserva();    //instanciamos la clase ctlreserva para llamar a todas las funciones

        //empezamos a enviar los datos
        dts.setIdhabitacion(Integer.parseInt(txtIdhabitacion.getText()));
        
        dts.setIdcliente(Integer.parseInt(txtIdcliente.getText()));
        
        dts.setIdempleado(idusuario);
        //para enviar de un combo box, hay que seleccionar un indice y se declara una variable de tipo int llamado "seleccionado"

        int seleccionado=cboTipo_reserva.getSelectedIndex();
        dts.setTipo_reserva((String) cboTipo_reserva.getItemAt(seleccionado));

        dts.setCosto_reserva(Double.parseDouble(txtCosto_reserva.getText())); //se le agrega el Double ya que espera un valor numerico
        
        Calendar calendar;  //Se declara un tipo de dato Calendar
        int d,m,a;          //Se declara tres variables de tipo int para el dia,mes y año
        calendar=jDateFecha_reserva.getCalendar();  //Obtener la fecha seleccionada
        d=calendar.get(Calendar.DAY_OF_MONTH);  //Le decimos que obtenga un dia del mes
        m=calendar.get(Calendar.MONTH);         //Le decimos que obtenga un mes
        a=calendar.get(Calendar.YEAR) - 1900;
        dts.setFecha_reserva(new Date (a,m,d)); //Le convertimos a una Fecha con el new Date
        
        calendar=jDateFecha_entrada.getCalendar();  //Obtener la fecha seleccionada
        d=calendar.get(Calendar.DAY_OF_MONTH);  //Le decimos que obtenga un dia del mes
        m=calendar.get(Calendar.MONTH);         //Le decimos que obtenga un mes
        a=calendar.get(Calendar.YEAR) - 1900;
        dts.setFecha_entrada(new Date (a,m,d)); //Le convertimos a una Fecha con el new Date
        
        calendar=jDateFecha_salida.getCalendar();  //Obtener la fecha seleccionada
        d=calendar.get(Calendar.DAY_OF_MONTH);  //Le decimos que obtenga un dia del mes
        m=calendar.get(Calendar.MONTH);         //Le decimos que obtenga un mes
        a=calendar.get(Calendar.YEAR) - 1900;
        dts.setFecha_salida(new Date (a,m,d)); //Le convertimos a una Fecha con el new Date
        
        dts.setCosto_reserva(Double.parseDouble(txtCosto_reserva.getText())); //se le agrega el Double ya que espera un valor numerico
        
        seleccionado=cboEstado_reserva.getSelectedIndex();
        dts.setEstado((String) cboEstado_reserva.getItemAt(seleccionado));

        if  (accion.equals("guardar")){             //usamos el equals para comparar cadena de caracteres
            if(funcion.insertar(dts)){
                JOptionPane.showMessageDialog(rootPane,"Registro Exitoso");
                mostrar("");
                deshabilitar();
            }
        }else if (accion.equals("modificar")){      //determinamos si la accion es modificar
            dts.setIdreserva(Integer.parseInt(txtIdreserva.getText())); //Se convierte a entero por la incompatibilidad de variables
            dts.setIdempleado(Integer.parseInt(txtIdempleado.getText())); //Para saber que trabajador esta editando la reserva
            if (funcion.modificar(dts)){
                JOptionPane.showMessageDialog(rootPane,"Modificación Exitosa");
                mostrar("");
                deshabilitar();
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNumero_habitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumero_habitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumero_habitacionActionPerformed

    private void txtIdclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdclienteActionPerformed

    private void txtNombre_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre_clienteActionPerformed

    private void txtIdempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdempleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdempleadoActionPerformed

    private void txtNombre_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre_empleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre_empleadoActionPerformed

    private void cboEstado_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEstado_reservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboEstado_reservaActionPerformed

    private void btnBusca_habitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusca_habitacionActionPerformed
        // TODO add your handling code here:
        frmVistaHabitaciones frmVH = new frmVistaHabitaciones(); //Instancio a mi frmVistaHabitaciones creando un nuevo objeto
        frmVH.toFront();
        frmVH.setVisible(true);
    }//GEN-LAST:event_btnBusca_habitacionActionPerformed

    private void btnBusca_NombreclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusca_NombreclienteActionPerformed
        // TODO add your handling code here:
        frmVistaCliente frmVC = new frmVistaCliente(); //Instancio a mi frmVistaCliente creando un nuevo objeto
        frmVC.toFront();
        frmVC.setVisible(true);
    }//GEN-LAST:event_btnBusca_NombreclienteActionPerformed

    private void btnVerconsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerconsumosActionPerformed
        // TODO add your handling code here:
        int fila = tablalistado.getSelectedRow();
        frmConsumo.idreserva=tablalistado.getValueAt(fila, 0).toString();
        frmConsumo.cliente=tablalistado.getValueAt(fila, 4).toString();
        
        frmConsumo frmC = new frmConsumo();
        frmPrincipal.Escritorio.add(frmC);//le decimos que mi frmC aparezca dentro de mi formulario Principal
        frmC.toFront();
        frmC.setVisible(true);
    }//GEN-LAST:event_btnVerconsumosActionPerformed

    private void btnRealizarpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarpagoActionPerformed
        // TODO add your handling code here:
        int fila= tablalistado.getSelectedRow();
        frmPago.idreserva= tablalistado.getValueAt(fila, 0).toString();
        frmPago.cliente= tablalistado.getValueAt(fila, 4).toString();
        frmPago.totalreserva= Double.parseDouble(tablalistado.getValueAt(fila, 11).toString());
        frmPago.idhabitacion= tablalistado.getValueAt(fila, 1).toString();
        frmPago.habitacion= tablalistado.getValueAt(fila, 2).toString();
        
        frmPago frmP = new frmPago();
        frmPrincipal.Escritorio.add(frmP); //muestro mi frmPago dentro de mi Escritorio
        frmP.toFront();
        frmP.setVisible(true);
    }//GEN-LAST:event_btnRealizarpagoActionPerformed

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
            java.util.logging.Logger.getLogger(frmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusca_Nombrecliente;
    private javax.swing.JButton btnBusca_habitacion;
    public javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRealizarpago;
    public javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerconsumos;
    private javax.swing.JComboBox<String> cboEstado_reserva;
    private javax.swing.JComboBox<String> cboTipo_reserva;
    private javax.swing.JLabel etiTotalregistros;
    private com.toedter.calendar.JDateChooser jDateFecha_entrada;
    private com.toedter.calendar.JDateChooser jDateFecha_reserva;
    private com.toedter.calendar.JDateChooser jDateFecha_salida;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tablalistado;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtCosto_reserva;
    public static javax.swing.JTextField txtIdcliente;
    public static javax.swing.JTextField txtIdempleado;
    public static javax.swing.JTextField txtIdhabitacion;
    public javax.swing.JTextField txtIdreserva;
    public static javax.swing.JTextField txtNombre_cliente;
    public static javax.swing.JTextField txtNombre_empleado;
    public static javax.swing.JTextField txtNumero_habitacion;
    // End of variables declaration//GEN-END:variables
}
