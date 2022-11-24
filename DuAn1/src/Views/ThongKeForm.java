/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import javax.swing.table.DefaultTableModel;
import Services.IThongKeSV;
import ViewModels.QuanLyThongKe;
import java.util.*;
import javax.swing.JOptionPane;
import Services.impl.ThongKeService;

/**
 *
 * @author pc
 */
public class ThongKeForm extends javax.swing.JFrame {

    public final IThongKeSV service = new ThongKeService();
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form NhanVienFrom
     */
    public ThongKeForm() {
        initComponents();
        setLocationRelativeTo(null);

    }

  


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtseach = new javax.swing.JTextField();
        btnseach = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbbang = new javax.swing.JTable();
        txtlammoi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setText("Quản Lý Thống kê");

        jLabel2.setText("Seach");

        txtseach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtseachActionPerformed(evt);
            }
        });

        btnseach.setText("seach");
        btnseach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseachActionPerformed(evt);
            }
        });

        tbbang.setModel(new javax.swing.table.DefaultTableModel(
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
        tbbang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbbang);

        txtlammoi.setText("Load");
        txtlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlammoiActionPerformed(evt);
            }
        });

        jLabel3.setText("Tháng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtlammoi))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(59, 59, 59)
                .addComponent(txtseach, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnseach)
                .addGap(251, 251, 251))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtseach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnseach))
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtlammoi)
                .addGap(102, 102, 102))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbbangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbbangMouseClicked

    private void btnseachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseachActionPerformed
        tim();       // TODO add your handling code here:
    }//GEN-LAST:event_btnseachActionPerformed

    private void txtlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlammoiActionPerformed
       layds(); // TODO add your handling code here:
    }//GEN-LAST:event_txtlammoiActionPerformed

    private void txtseachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtseachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtseachActionPerformed
    public List<QuanLyThongKe> layds() {
        model.setColumnIdentifiers(new String[]{"Mã", "Tên", "Ngày TT", "Số Lượng", "Đơn Gía","Thành Tiền"});
        model.setRowCount(0);
        List<QuanLyThongKe> dsnv = service.getAll();
        for (QuanLyThongKe kh : dsnv) {
            Object[] row = new Object[]{
                kh.getMaSP(),
                kh.getTenSP(),
                kh.getNgay(),
                kh.getSoLuong(),
                kh.getDongia(),
                kh.getThanhTien(),};
            model.addRow(row);
        }
        tbbang.setModel(model);
        return dsnv;
    }

    public List<QuanLyThongKe> tim() {
        try {
              if (txtseach.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "vui lòng nhập mã để tìm");
            return null;

        } else {

            String ma = txtseach.getText();
            model.setColumnIdentifiers(new String[]{"Mã", "Tên", "Ngày TT", "Số Lượng", "Đơn Gía","Thành Tiền"});
        model.setRowCount(0);
        List<QuanLyThongKe> dsnv = service.tim(ma);
        for (QuanLyThongKe kh : dsnv) {
            Object[] row = new Object[]{
                kh.getMaSP(),
                kh.getTenSP(),
                kh.getNgay(),
                kh.getSoLuong(),
                kh.getDongia(),
                kh.getThanhTien(),};
            model.addRow(row);
        }
        tbbang.setModel(model);
        return dsnv;
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"k Thay sp can tim");
            return null;
        }
    }

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
            java.util.logging.Logger.getLogger(ThongKeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnseach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbbang;
    private javax.swing.JButton txtlammoi;
    private javax.swing.JTextField txtseach;
    // End of variables declaration//GEN-END:variables
}
