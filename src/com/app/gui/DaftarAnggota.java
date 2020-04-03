/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gui;

import com.app.dataakses.DataAksesAnggota;
import com.app.gui.Util.ConnectionityUtil;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class DaftarAnggota extends javax.swing.JFrame {
    private DataAksesAnggota dataAkses;
    private AnggotaTableModel tableModel;
    private AnggotaDetail detail;
    /**
     * Creates new form DaftarAnggota
     */
    public DaftarAnggota() {
        initComponents();
        try {
            dataAkses = new DataAksesAnggota(ConnectionityUtil.getConnection());
        } catch (SQLException ex) {
            
        }
        loadData();
    }
    
    public void loadData(){
        try {
            tableModel = new AnggotaTableModel(dataAkses.getALL());
            tableAnggota.setModel(tableModel);
        } catch (SQLException ex) {
            Logger.getLogger(DaftarAnggota.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableAnggota = new javax.swing.JTable();
        buttonAdd = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableAnggota.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableAnggota);

        buttonAdd.setText("ADD");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonDelete.setText("DELETE");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonEdit.setText("EDIT");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonExit.setText("EXIT");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDelete)
                    .addComponent(buttonEdit)
                    .addComponent(buttonAdd)
                    .addComponent(buttonExit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
      detail = new AnggotaDetail(this, true);
      detail.setVisible(true);
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        int row = tableAnggota.getSelectedRow();
        if(row > -1){
            String npm = tableAnggota.getValueAt(row, 0).toString();
            detail = new AnggotaDetail(this, true, npm);
            detail.setVisible(true);
       }
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
         int row = tableAnggota.getSelectedRow();
        if(row > -1){
            if(JOptionPane.showConfirmDialog(rootPane, "Are You Sure ?") == JOptionPane.YES_OPTION){
                try {
                    String npm = tableAnggota.getValueAt(row, 0).toString();
                    if(dataAkses.delete(npm)){
                       JOptionPane.showMessageDialog(rootPane, "Delete Data SUCCESS");
                       loadData();
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Delete Data FAIL");
                    }
                } catch (SQLException ex) {
                    
                }
            
            }
       }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
       dispose();
    }//GEN-LAST:event_buttonExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DaftarAnggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonExit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAnggota;
    // End of variables declaration//GEN-END:variables
}
