/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dulceria;

import dulceria.clases.Dulce;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kledioz
 */
public class Inventario extends javax.swing.JFrame {

    Opciones op;
    boolean mostrarCategorias;

    /**
     * Creates new form Inventario
     */
    public Inventario(Opciones op, boolean mostrarCategorias) {
        this.op = op;
        this.mostrarCategorias = mostrarCategorias;
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                op.setEnabled(true);
                dispose();
            }
        });

        if (!mostrarCategorias) {
            lblCategoria.setVisible(false);
            box_categoria_inventario.setVisible(false);
            actualizarTabla("todos", "Codigo", true);
            lbl_selecciona.setVisible(false);
        }

        op.setEnabled(false);

    }

    public void actualizarTabla(String categoria, String columna, boolean ascendente) {

        lbl_selecciona.setVisible(false);

        if (op.main.dulces.isEmpty()) {
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) tbl_inventario.getModel();
        modelo.setRowCount(0);
        
        double total = 0;

        Object[][] lista = new Object[35][2];

        int i = 0;

        for (Dulce dul : op.main.dulces) {
            
            
            if (!categoria.equals("todos")) {
                if (!categoria.equals(dul.getCategoria())) {
                    continue;
                }
            }

            double info = 0;

            switch (columna) {
                case "Codigo":
                    info  = dul.getCodigo();
                    break;
                case "Cantidad":
                    info  = dul.getCantidad();
                    break;
                case "Precio":
                    info = dul.getPrecio();
                    break;
            }

            lista[i][0] = info;
            lista[i][1] = dul;
            i++;
            total += dul.getPrecio() * dul.getCantidad();
        }

        op.main.quickSort(lista, 0, i - 1, ascendente);

        for (int j = 0; j < lista.length; j++) {
            Dulce dul = (Dulce) lista[j][1];
            if (dul == null) {
                break;
            }
            modelo.addRow(new Object[]{dul.getCodigo(), dul.getNombre(), dul.getCantidad(), dul.getPrecio(), dul.getCategoria()});
        }

        lbl_total_inventario.setText("Total: $" + new DecimalFormat("##.##").format(total));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_inventario = new javax.swing.JTable();
        btn_regresar_inventario = new javax.swing.JButton();
        lbl_total_inventario = new javax.swing.JLabel();
        box_categoria_inventario = new javax.swing.JComboBox();
        lblCategoria = new javax.swing.JLabel();
        lbl_selecciona = new javax.swing.JLabel();
        panel_inventario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        box_tipo_orden_inventario = new javax.swing.JComboBox();
        box_orden_inventario = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dulceria | Inventario");
        setIconImage(getIconImage());
        setMaximumSize(new java.awt.Dimension(846, 515));
        setMinimumSize(new java.awt.Dimension(846, 515));
        setPreferredSize(new java.awt.Dimension(846, 515));
        setResizable(false);
        getContentPane().setLayout(null);

        tbl_inventario.setBackground(new java.awt.Color(255, 204, 255));
        tbl_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Cantidad", "Precio", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_inventario.setColumnSelectionAllowed(true);
        tbl_inventario.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl_inventario);
        tbl_inventario.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tbl_inventario.getColumnModel().getColumnCount() > 0) {
            tbl_inventario.getColumnModel().getColumn(0).setResizable(false);
            tbl_inventario.getColumnModel().getColumn(1).setResizable(false);
            tbl_inventario.getColumnModel().getColumn(2).setResizable(false);
            tbl_inventario.getColumnModel().getColumn(3).setResizable(false);
            tbl_inventario.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 11, 823, 371);

        btn_regresar_inventario.setText("Regresar");
        btn_regresar_inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresar_inventarioActionPerformed(evt);
            }
        });
        getContentPane().add(btn_regresar_inventario);
        btn_regresar_inventario.setBounds(20, 440, 83, 32);

        lbl_total_inventario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_total_inventario.setText("Total: $0.00");
        getContentPane().add(lbl_total_inventario);
        lbl_total_inventario.setBounds(648, 388, 167, 24);

        box_categoria_inventario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dulce", "Salado", "Enchiloso" }));
        box_categoria_inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_categoria_inventarioActionPerformed(evt);
            }
        });
        getContentPane().add(box_categoria_inventario);
        box_categoria_inventario.setBounds(150, 393, 85, 26);

        lblCategoria.setText("Categoria:");
        getContentPane().add(lblCategoria);
        lblCategoria.setBounds(95, 396, 58, 16);

        lbl_selecciona.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_selecciona.setText("SELECCIONE UNA CATEGORIA");
        getContentPane().add(lbl_selecciona);
        lbl_selecciona.setBounds(51, 419, 274, 24);

        panel_inventario.setBackground(new java.awt.Color(255, 102, 102));
        panel_inventario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Columna");

        jLabel2.setText("Orden");

        box_tipo_orden_inventario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Codigo", "Cantidad", "Precio" }));
        box_tipo_orden_inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_tipo_orden_inventarioActionPerformed(evt);
            }
        });

        box_orden_inventario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ascendente", "Descendente" }));
        box_orden_inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_orden_inventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_inventarioLayout = new javax.swing.GroupLayout(panel_inventario);
        panel_inventario.setLayout(panel_inventarioLayout);
        panel_inventarioLayout.setHorizontalGroup(
            panel_inventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_inventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_inventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_inventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(box_orden_inventario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(box_tipo_orden_inventario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panel_inventarioLayout.setVerticalGroup(
            panel_inventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_inventarioLayout.createSequentialGroup()
                .addGroup(panel_inventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(box_tipo_orden_inventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_inventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(box_orden_inventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(panel_inventario);
        panel_inventario.setBounds(630, 410, 200, 70);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rj.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, -6, 850, 510);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void box_categoria_inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_categoria_inventarioActionPerformed
        if (mostrarCategorias) {
            actualizarTabla((String) box_categoria_inventario.getSelectedItem(), (String) box_tipo_orden_inventario.getModel().getSelectedItem(), box_orden_inventario.getModel().getSelectedItem().equals("Ascendente"));
        } else {
            actualizarTabla("todos", (String) box_tipo_orden_inventario.getModel().getSelectedItem(), box_orden_inventario.getModel().getSelectedItem().equals("Ascendente"));
        }
    }//GEN-LAST:event_box_categoria_inventarioActionPerformed

    private void btn_regresar_inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresar_inventarioActionPerformed
        op.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_btn_regresar_inventarioActionPerformed

    private void box_tipo_orden_inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_tipo_orden_inventarioActionPerformed
        if (mostrarCategorias) {
            actualizarTabla((String) box_categoria_inventario.getSelectedItem(), (String) box_tipo_orden_inventario.getModel().getSelectedItem(), box_orden_inventario.getModel().getSelectedItem().equals("Ascendente"));
        } else {
            actualizarTabla("todos", (String) box_tipo_orden_inventario.getModel().getSelectedItem(), box_orden_inventario.getModel().getSelectedItem().equals("Ascendente"));
        }
    }//GEN-LAST:event_box_tipo_orden_inventarioActionPerformed

    private void box_orden_inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_orden_inventarioActionPerformed
        if (mostrarCategorias) {
            actualizarTabla((String) box_categoria_inventario.getSelectedItem(), (String) box_tipo_orden_inventario.getModel().getSelectedItem(), box_orden_inventario.getModel().getSelectedItem().equals("Ascendente"));
        } else {
            actualizarTabla("todos", (String) box_tipo_orden_inventario.getModel().getSelectedItem(), box_orden_inventario.getModel().getSelectedItem().equals("Ascendente"));
        }
    }//GEN-LAST:event_box_orden_inventarioActionPerformed

@Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("imagenes/inventario.png"));


        return retValue;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox box_categoria_inventario;
    private javax.swing.JComboBox box_orden_inventario;
    private javax.swing.JComboBox box_tipo_orden_inventario;
    private javax.swing.JButton btn_regresar_inventario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lbl_selecciona;
    private javax.swing.JLabel lbl_total_inventario;
    private javax.swing.JPanel panel_inventario;
    private javax.swing.JTable tbl_inventario;
    // End of variables declaration//GEN-END:variables
}