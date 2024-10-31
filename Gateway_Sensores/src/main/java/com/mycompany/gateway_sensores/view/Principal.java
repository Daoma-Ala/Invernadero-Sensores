/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gateway_sensores.view;

import com.mycompany.gateway_sensores.dao.GatewayDAO;
import com.mycompany.gateway_sensores.dao.impl.GatewayDAOImpl;
import com.mycompany.gateway_sensores.gateway.impl.Gateway;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daniel
 */
public final class Principal extends javax.swing.JFrame {

    // private List<Gateway> gateways;
    private final GatewayDAO gatewayDAO = GatewayDAOImpl.getInstance();
    private final List<Monitor> monitors = new ArrayList<>();

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        cargarDatosTabla();
        agregarTableModelListener();
    }

    protected void cargarDatosTabla() {
        List<Gateway> gateways = gatewayDAO.readAllGateways();
        DefaultTableModel model = (DefaultTableModel) tblGateway.getModel();
        model.setRowCount(0);
        for (Gateway gateway : gateways) {
            model.addRow(crearObjetoTabla(gateway));
        }
    }

    private Object[] crearObjetoTabla(Gateway gateway) {
        String serie = gateway.getSeries();
        boolean estatus = gateway.isStatus();
        return new Object[]{serie, estatus};
    }

    private void agregarTableModelListener() {
        tblGateway.getModel().addTableModelListener(e -> {
            int row = e.getFirstRow();
            int column = e.getColumn();

            if (column == 1) {
                Boolean activo = (Boolean) tblGateway.getValueAt(row, column);
                String serie = (String) tblGateway.getValueAt(row, 0);
                // Gateway gateway = findGateway(serie);
                Gateway gateway = GatewayDAOImpl.getInstance().readGateway(serie);

                if (gateway != null) {
                    Monitor monitor = validarMonitor(gateway);
                    if (activo && monitor == null) {
                        monitor = new Monitor(gateway, this);
                        monitors.add(monitor);
                        monitor.setVisible(true);
                    } else if (!activo && monitor != null) {
                        monitor.dispose();
                        monitors.remove(monitor);
                    } else if (activo && monitor != null) {
                        monitor.validarMonitor();
                    }
                }
            }

        });
    }

    private Monitor validarMonitor(Gateway gateway) {
        for (Monitor monitor : monitors) {
            if (monitor.getGateway().getSeries().equals(gateway.getSeries())) {
                return monitor;
            }
        }
        return null;
    }

//    private Gateway findGateway(String serie) {
//        for (Gateway gateway : gateways) {
//            if (gateway.getSeries().equals(serie)) {
//                return gateway;
//            }
//        }
//        return null;
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGateway = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(42, 50, 60));

        tblGateway.setBackground(new java.awt.Color(255, 255, 255));
        tblGateway.setForeground(new java.awt.Color(51, 51, 51));
        tblGateway.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serie", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGateway.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tblGateway.setSelectionForeground(new java.awt.Color(51, 51, 51));
        tblGateway.getTableHeader().setResizingAllowed(false);
        tblGateway.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblGateway);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gateway IoT");

        btnRegistrar.setBackground(new java.awt.Color(93, 162, 113));
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrar))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        RegistrarGateway registrarGateway = new RegistrarGateway(this);
        registrarGateway.setVisible(true);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        EliminarGateway eliminarGateway = new EliminarGateway(this);
        eliminarGateway.setVisible(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cerrarGateways() {
        for (Monitor monitor : monitors) {
            monitor.gateway.finishGateway();
            gatewayDAO.updateGateway(monitor.gateway);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        cerrarGateways();
        System.exit(0);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblGateway;
    // End of variables declaration//GEN-END:variables
}
