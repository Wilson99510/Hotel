/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.vista;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema.controlador.ctlconsumo;
import sistema.controlador.ctlhabitaciones;
import sistema.controlador.ctlpago;
import sistema.controlador.ctlreserva;
import sistema.modelo.habitacion;
import sistema.modelo.pago;
import sistema.modelo.reserva;

/**
 *
 * @author wcaba
 */
public class frmPago extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmPago
     */
    public frmPago() {
        initComponents();
        mostrar(idreserva); //le enviamos como parametro el idreserva
        deshabilitar();
        txtIdreserva.setText(idreserva);
        txtNombrecliente.setText(cliente);
        txtIdhabitacion.setText(idhabitacion);
        txtHabitacion.setText(habitacion);
        txtTotalreserva.setText(Double.toString(totalreserva));

        ctlconsumo funcion = new ctlconsumo();  //hago una instancia a mi clase ctlconsumo para obtener el total de los consumos
        funcion.mostrar(idreserva); //mostrar solamente los consumos de la reserva en específica

        txtTotalpago.setText(Double.toString(totalreserva + funcion.totalconsumo));
    }

    private String accion = "guardar"; //se declara una variable de tipo String para determinar una accion
    //se declara 6 variables para asignarle valores 
    public static String idreserva;
    public static String cliente;
    public static String idhabitacion;
    public static String habitacion;
    public static Double totalreserva;

    void ocultar_columnas() {                // la columna a no mostrar es de idpago
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);

        // la columna a no mostrar es de idreserva
        tablalistado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(0);
    }

    void ocultar_columnas_consumo() {        // la columna a no mostrar es de idconsumo
        tablalistadoconsumo.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(0).setPreferredWidth(0);

        // la columna a no mostrar es de idreserva
        tablalistadoconsumo.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(1).setPreferredWidth(0);

        // la columna a no mostrar es de idproducto
        tablalistadoconsumo.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(2).setPreferredWidth(0);
    }

    void deshabilitar() {      //metodo para deshabilitar botones
        txtIdpago.setVisible(false);

        txtIdreserva.setVisible(false);
        txtNombrecliente.setEnabled(false);
        txtNumerocomprobante.setEnabled(false);
        cboTipocomprobante.setEnabled(false);
        txtIgv.setEnabled(false);
        txtTotalpago.setEnabled(false);
        txtTotalreserva.setEnabled(false);
        jDateFechaemision.setEnabled(false);
        jDateFechapago.setEnabled(false);

        txtIdhabitacion.setVisible(false);
        txtHabitacion.setEnabled(false);

        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtIdpago.setText("");
        txtIgv.setText("");
        txtNumerocomprobante.setText("");
        txtTotalpago.setText("");
    }

    void habilitar() {       //metodo para habilitar botones
        txtIdpago.setVisible(false);

        txtIdreserva.setVisible(true);
        txtNombrecliente.setEnabled(true);
        txtNumerocomprobante.setEnabled(true);
        cboTipocomprobante.setEnabled(true);
        txtIgv.setEnabled(true);
        txtTotalpago.setEnabled(true);
        txtTotalreserva.setEnabled(true);
        jDateFechaemision.setEnabled(true);
        jDateFechapago.setEnabled(true);

        txtIdhabitacion.setVisible(true);
        txtHabitacion.setEnabled(true);

        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);
        txtIdpago.setText("");
        txtIgv.setText("");
        txtNumerocomprobante.setText("");
    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            ctlpago funcion = new ctlpago();
            modelo = funcion.mostrar(buscar);
            tablalistado.setModel(modelo);
            ocultar_columnas();
            etiTotalregistros.setText("Total Pagos: " + Integer.toString(funcion.totalregistros));

            //Vamos a mostrar los datos de los consumos
            ctlconsumo funcion2 = new ctlconsumo();
            modelo = funcion2.mostrar(buscar);
            tablalistadoconsumo.setModel(modelo);
            ocultar_columnas_consumo();
            etiTotalregistrosconsumo.setText("Total Consumos: " + funcion2.totalregistros);
            etiTotalconsumo.setText("Consumo Total: $." + funcion2.totalconsumo);

        } catch (Exception e) {
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

        jPanel1 = new javax.swing.JPanel();
        txtIdpago = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIdreserva = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNumerocomprobante = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboTipocomprobante = new javax.swing.JComboBox<>();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNombrecliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTotalreserva = new javax.swing.JTextField();
        txtIdhabitacion = new javax.swing.JTextField();
        txtHabitacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIgv = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTotalpago = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jDateFechaemision = new com.toedter.calendar.JDateChooser();
        jDateFechapago = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        etiTotalregistros = new javax.swing.JLabel();
        btnReporte = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablalistadoconsumo = new javax.swing.JTable();
        etiTotalregistrosconsumo = new javax.swing.JLabel();
        etiTotalconsumo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTRO DE PAGOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setToolTipText("");

        txtIdpago.setBackground(new java.awt.Color(102, 102, 102));
        txtIdpago.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtIdpago.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total Reserva:");

        txtIdreserva.setBackground(new java.awt.Color(102, 102, 102));
        txtIdreserva.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtIdreserva.setForeground(new java.awt.Color(255, 255, 255));
        txtIdreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdreservaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Habitación");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tipo de Comprobante:");

        txtNumerocomprobante.setBackground(new java.awt.Color(102, 102, 102));
        txtNumerocomprobante.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtNumerocomprobante.setForeground(new java.awt.Color(255, 255, 255));
        txtNumerocomprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumerocomprobanteActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Número de Comprobante:");

        cboTipocomprobante.setBackground(new java.awt.Color(102, 102, 102));
        cboTipocomprobante.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cboTipocomprobante.setForeground(new java.awt.Color(255, 255, 255));
        cboTipocomprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TICKET", "FACTURA", "RECIBO" }));
        cboTipocomprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipocomprobanteActionPerformed(evt);
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

        txtNombrecliente.setBackground(new java.awt.Color(102, 102, 102));
        txtNombrecliente.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtNombrecliente.setForeground(new java.awt.Color(255, 255, 255));
        txtNombrecliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreclienteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Reserva:");

        txtTotalreserva.setBackground(new java.awt.Color(102, 102, 102));
        txtTotalreserva.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtTotalreserva.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalreservaActionPerformed(evt);
            }
        });

        txtIdhabitacion.setBackground(new java.awt.Color(102, 102, 102));
        txtIdhabitacion.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtIdhabitacion.setForeground(new java.awt.Color(255, 255, 255));
        txtIdhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdhabitacionActionPerformed(evt);
            }
        });

        txtHabitacion.setBackground(new java.awt.Color(102, 102, 102));
        txtHabitacion.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtHabitacion.setForeground(new java.awt.Color(255, 255, 255));
        txtHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHabitacionActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("IGV:");

        txtIgv.setBackground(new java.awt.Color(102, 102, 102));
        txtIgv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtIgv.setForeground(new java.awt.Color(255, 255, 255));
        txtIgv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIgvActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total de Pago:");

        txtTotalpago.setBackground(new java.awt.Color(102, 102, 102));
        txtTotalpago.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtTotalpago.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalpagoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Fecha de Emisión:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fecha de Pago:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotalpago)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdreserva)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtIdpago, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumerocomprobante)
                            .addComponent(cboTipocomprobante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdhabitacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtIgv, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(txtTotalreserva)
                            .addComponent(jDateFechaemision, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateFechapago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIdpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTotalreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboTipocomprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNumerocomprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTotalpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jDateFechaemision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jDateFechapago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(89, 89, 89))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTADO DE PAGOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

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

        btnReporte.setBackground(new java.awt.Color(102, 102, 102));
        btnReporte.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnReporte.setText("Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etiTotalregistros)
                .addGap(62, 62, 62))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar)
                            .addComponent(btnReporte))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiTotalregistros)
                .addGap(108, 108, 108))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTADO DE CONSUMOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        tablalistadoconsumo.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistadoconsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoconsumoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablalistadoconsumo);

        etiTotalregistrosconsumo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        etiTotalregistrosconsumo.setForeground(new java.awt.Color(255, 255, 255));
        etiTotalregistrosconsumo.setText("Registros");

        etiTotalconsumo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        etiTotalconsumo.setForeground(new java.awt.Color(255, 255, 255));
        etiTotalconsumo.setText("Consumos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etiTotalconsumo)
                .addGap(96, 96, 96)
                .addComponent(etiTotalregistrosconsumo)
                .addGap(64, 64, 64))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiTotalregistrosconsumo)
                    .addComponent(etiTotalconsumo))
                .addGap(91, 91, 91))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdreservaActionPerformed
        // TODO add your handling code here:
        txtIdreserva.transferFocus();
    }//GEN-LAST:event_txtIdreservaActionPerformed

    private void txtNumerocomprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumerocomprobanteActionPerformed
        // TODO add your handling code here:
        txtNumerocomprobante.transferFocus();
    }//GEN-LAST:event_txtNumerocomprobanteActionPerformed

    private void cboTipocomprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipocomprobanteActionPerformed
        // TODO add your handling code here:
        cboTipocomprobante.transferFocus();
    }//GEN-LAST:event_cboTipocomprobanteActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnGuardar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtIgv.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Ingresar el IGV del Comprobante a ser Generado");
            txtIgv.requestFocus();
            return;
        }

        if (txtTotalpago.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Ingresar Total de Pago del Comprobante");
            txtTotalpago.requestFocus();
            return;
        }

        if (txtNumerocomprobante.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Ingresar Número de Comprobante");
            txtNumerocomprobante.requestFocus();
            return;
        }

        pago dts = new pago();  //instanciamos la clase pago para crear un nuevo objeto
        ctlpago funcion = new ctlpago();    //instanciamos la clase ctlpago para llamar a todas las funciones

        //empezamos a enviar los datos
        dts.setIdreserva(Integer.parseInt(txtIdreserva.getText()));

        //para enviar de un combo box, hay que seleccionar un indice y se declara una variable de tipo int llamado "seleccionado"
        int seleccionado = cboTipocomprobante.getSelectedIndex();
        dts.setTipo_comprobante((String) cboTipocomprobante.getItemAt(seleccionado));
        dts.setNum_comprobante(txtNumerocomprobante.getText());

        dts.setIgv(Double.parseDouble(txtIgv.getText())); //se le agrega el Double ya que espera un valor numerico
        dts.setTotal_pago(Double.parseDouble(txtTotalpago.getText())); //se le agrega el Double ya que espera un valor numerico

        Calendar calendar;  //Se declara un tipo de dato Calendar
        int d, m, a;          //Se declara tres variables de tipo int para el dia,mes y año
        calendar = jDateFechaemision.getCalendar();  //Obtener la fecha seleccionada
        d = calendar.get(Calendar.DAY_OF_MONTH);  //Le decimos que obtenga un dia del mes
        m = calendar.get(Calendar.MONTH);         //Le decimos que obtenga un mes
        a = calendar.get(Calendar.YEAR) - 1900;
        dts.setFecha_emision(new Date(a, m, d)); //Le convertimos a una Fecha con el new Date

        calendar = jDateFechapago.getCalendar();  //Obtener la fecha seleccionada
        d = calendar.get(Calendar.DAY_OF_MONTH);  //Le decimos que obtenga un dia del mes
        m = calendar.get(Calendar.MONTH);         //Le decimos que obtenga un mes
        a = calendar.get(Calendar.YEAR) - 1900;
        dts.setFecha_pago(new Date(a, m, d)); //Le convertimos a una Fecha con el new Date

        if (accion.equals("guardar")) {     //usamos el equals para comparar cadena de caracteres
            if (funcion.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Pago por $. " + txtTotalpago.getText()
                        + " Del Cliente " + txtNombrecliente.getText() + " Ha sido Realizado Exitosamente");
                mostrar(idreserva);
                deshabilitar();

                //Hacer que se pague o se cancele la reserva
                ctlreserva funcion3 = new ctlreserva();
                reserva dts3 = new reserva();

                dts3.setIdreserva(Integer.parseInt(txtIdreserva.getText()));
                funcion3.pagar_reserva(dts3);
            }
        } else if (accion.equals("modificar")) {      //determinamos si la accion es modificar
            dts.setIdpago(Integer.parseInt(txtIdpago.getText())); //Se convierte a entero por la incompatibilidad de variables
            if (funcion.modificar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Pago del Cliente " + txtNombrecliente.getText()
                        + "Ha sido Modificado Exitosamente");
                mostrar(idreserva);
                deshabilitar();
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnGuardar.setText("Modificar");
        habilitar();
        btnEliminar.setEnabled(true);
        accion = "modificar";
        int fila = tablalistado.rowAtPoint(evt.getPoint()); //punto o fila donde se hace clic en la variable fila
        txtIdpago.setText(tablalistado.getValueAt(fila, 0).toString());
//        txtIdreserva.setText(tablalistado.getValueAt(fila, 1).toString());

        cboTipocomprobante.setSelectedItem(tablalistado.getValueAt(fila, 2).toString());
        txtNumerocomprobante.setText(tablalistado.getValueAt(fila, 3).toString());
        txtIgv.setText(tablalistado.getValueAt(fila, 4).toString());
        txtTotalpago.setText(tablalistado.getValueAt(fila, 5).toString());
        jDateFechaemision.setDate(Date.valueOf(tablalistado.getValueAt(fila, 6).toString())); //Convertir a fecha con el Date ValueOf
        jDateFechapago.setDate(Date.valueOf(tablalistado.getValueAt(fila, 7).toString())); //Convertir a fecha con el Date ValueOf
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (!txtIdpago.getText().equals("")) { // si no es igual a (espacio en blanco) se procede a eliminar el producto
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Desea Eliminar el Pago?", "Confirmar", 2);

            if (confirmacion == 0) {
                ctlpago funcion = new ctlpago();
                pago dts = new pago();
                dts.setIdpago(Integer.parseInt(txtIdpago.getText()));
                funcion.eliminar(dts);
                mostrar(idreserva);     //mostrar solo los pagos que corresponda a la reserva seleccionada
                deshabilitar(); //para desactivar todas las cajas
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose(); //para cerrar el formulario
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtNombreclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreclienteActionPerformed

    private void txtTotalreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalreservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalreservaActionPerformed

    private void txtIdhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdhabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdhabitacionActionPerformed

    private void txtHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHabitacionActionPerformed

    private void txtIgvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgvActionPerformed
        // TODO add your handling code here:
        txtIgv.transferFocus();
    }//GEN-LAST:event_txtIgvActionPerformed

    private void txtTotalpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalpagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalpagoActionPerformed

    private void tablalistadoconsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoconsumoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistadoconsumoMouseClicked

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Documents/NetBeansProjects/dbhotel/Reporte_Comprobante.pdf"));
            documento.open();

            PdfPTable tabla = new PdfPTable(11);
            tabla.addCell("Cantidad");
            tabla.addCell("Descripción");
            tabla.addCell("Cliente");
            tabla.addCell("Num_Documento");
            tabla.addCell("Dirección");
            tabla.addCell("Costo_Reserva");
            tabla.addCell("Tipo_Comprobante");
            tabla.addCell("Num_Comprobante");
            tabla.addCell("Total_Pago");
            tabla.addCell("Fecha_Emisión");
            tabla.addCell("Fecha_Pago");
            try {
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/dbhotel", "root", "5975706");
                PreparedStatement pst = cn.prepareStatement("SELECT '1' as Cantidad, 'Reserva' as Descripcion, concat(u.nombre, ' ',u.apellido, '')as Cliente, u.numero_documento as Num_Documento, u.direccion as Dirección, r.costo_reserva as Costo_Reserva,\n"
                        + "p.tipo_comprobante as Tipo_Comprobante, p.num_comprobante as Num_Comprobante, p.total_pago as Total_Pago, p.fecha_emision as Fecha_Emisión,\n"
                        + "p.fecha_pago as Fecha_Pago FROM usuario u inner join cliente c on u.idpersona=c.idpersona\n"
                        + "inner join reserva r on c.idpersona=r.idcliente inner join pago p on r.idreserva=p.idreserva where idpago=idpago");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                        tabla.addCell(rs.getString(8));
                        tabla.addCell(rs.getString(9));
                        tabla.addCell(rs.getString(10));
                        tabla.addCell(rs.getString(11));

                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        }
    }//GEN-LAST:event_btnReporteActionPerformed

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
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnReporte;
    public javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboTipocomprobante;
    private javax.swing.JLabel etiTotalconsumo;
    private javax.swing.JLabel etiTotalregistros;
    private javax.swing.JLabel etiTotalregistrosconsumo;
    private com.toedter.calendar.JDateChooser jDateFechaemision;
    private com.toedter.calendar.JDateChooser jDateFechapago;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable tablalistado;
    public javax.swing.JTable tablalistadoconsumo;
    public javax.swing.JTextField txtHabitacion;
    public javax.swing.JTextField txtIdhabitacion;
    public javax.swing.JTextField txtIdpago;
    public javax.swing.JTextField txtIdreserva;
    public javax.swing.JTextField txtIgv;
    public javax.swing.JTextField txtNombrecliente;
    public javax.swing.JTextField txtNumerocomprobante;
    public javax.swing.JTextField txtTotalpago;
    public javax.swing.JTextField txtTotalreserva;
    // End of variables declaration//GEN-END:variables
}
