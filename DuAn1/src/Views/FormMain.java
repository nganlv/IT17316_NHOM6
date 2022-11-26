/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Bean.DanhMucBean;
import Controller.ChuyenManHinhController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class FormMain extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public FormMain() {
        initComponents();
        setTitle("QUẢN LÝ BÁN ĐỒNG HỒ");
        setLocationRelativeTo(null);
        ChuyenManHinhController controller=new ChuyenManHinhController(jpnView);
        controller.setView(jpnBanHang, jlbBanHang);
        
        List<DanhMucBean> listItem=new ArrayList<>();
        listItem.add(new DanhMucBean("BanHang", jpnBanHang, jlbBanHang));
        listItem.add(new DanhMucBean("SanPham", jpnSanPham, jlbSanPham));
        listItem.add(new DanhMucBean("HoaDon", jpnHoaDon, jlbHoaDon));
        listItem.add(new DanhMucBean("KhuyenMai", jpnKhuyenMai, jlbKhuyenMai));
        listItem.add(new DanhMucBean("KhachHang", jpnKhachHang, jlbKhachHang));
        listItem.add(new DanhMucBean("NhanVien", jpnNhanVien, jlbNhanVien));
        listItem.add(new DanhMucBean("ThongKe", jpnThongKe, jlbThongKe));
        controller.setEvent(listItem);
        chuChay();
    }
private void chuChay() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    String first = jlbDongHo.getText().substring(0, 1);
                    String last = jlbDongHo.getText().substring(1);
                    jlbDongHo.setText(last + first);
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                    }
                }
            }
        }.start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlbDongHo = new javax.swing.JLabel();
        jpnBanHang = new javax.swing.JPanel();
        jlbBanHang = new javax.swing.JLabel();
        jpnSanPham = new javax.swing.JPanel();
        jlbSanPham = new javax.swing.JLabel();
        jpnHoaDon = new javax.swing.JPanel();
        jlbHoaDon = new javax.swing.JLabel();
        jpnKhachHang = new javax.swing.JPanel();
        jlbKhachHang = new javax.swing.JLabel();
        jpnNhanVien = new javax.swing.JPanel();
        jlbNhanVien = new javax.swing.JLabel();
        jpnKhuyenMai = new javax.swing.JPanel();
        jlbKhuyenMai = new javax.swing.JLabel();
        jpnThongKe = new javax.swing.JPanel();
        jlbThongKe = new javax.swing.JLabel();
        jpnThoat = new javax.swing.JPanel();
        btnThoat = new javax.swing.JButton();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnRoot.setBackground(new java.awt.Color(255, 255, 153));

        jpnMenu.setBackground(new java.awt.Color(255, 153, 51));

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));

        jlbDongHo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbDongHo.setForeground(new java.awt.Color(0, 153, 153));
        jlbDongHo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jlbDongHo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\OneDrive\\Documents\\GitHub\\IT17316_NHOM6\\DuAn1\\src\\Image\\icons8-watch-48.png")); // NOI18N

      

        jlbDongHo.setText("QUẢN LÝ BÁN ĐỒNG HỒ  ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jlbDongHo, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbDongHo, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnBanHang.setBackground(new java.awt.Color(255, 102, 51));
        jpnBanHang.setPreferredSize(new java.awt.Dimension(0, 65));

        jlbBanHang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbBanHang.setForeground(new java.awt.Color(255, 255, 255));
        jlbBanHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbBanHang.setText("Bán hàng");

        javax.swing.GroupLayout jpnBanHangLayout = new javax.swing.GroupLayout(jpnBanHang);
        jpnBanHang.setLayout(jpnBanHangLayout);
        jpnBanHangLayout.setHorizontalGroup(
            jpnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBanHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnBanHangLayout.setVerticalGroup(
            jpnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBanHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnSanPham.setBackground(new java.awt.Color(255, 102, 51));
        jpnSanPham.setPreferredSize(new java.awt.Dimension(265, 65));

        jlbSanPham.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbSanPham.setForeground(new java.awt.Color(255, 255, 255));
        jlbSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbSanPham.setText("Sản phẩm");

        javax.swing.GroupLayout jpnSanPhamLayout = new javax.swing.GroupLayout(jpnSanPham);
        jpnSanPham.setLayout(jpnSanPhamLayout);
        jpnSanPhamLayout.setHorizontalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnSanPhamLayout.setVerticalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnHoaDon.setBackground(new java.awt.Color(255, 102, 51));
        jpnHoaDon.setPreferredSize(new java.awt.Dimension(265, 65));

        jlbHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        jlbHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbHoaDon.setText("Hóa đơn");

        javax.swing.GroupLayout jpnHoaDonLayout = new javax.swing.GroupLayout(jpnHoaDon);
        jpnHoaDon.setLayout(jpnHoaDonLayout);
        jpnHoaDonLayout.setHorizontalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnHoaDonLayout.setVerticalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHoaDonLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jlbHoaDon)
                .addGap(24, 24, 24))
        );

        jpnKhachHang.setBackground(new java.awt.Color(255, 102, 51));
        jpnKhachHang.setPreferredSize(new java.awt.Dimension(0, 65));

        jlbKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        jlbKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbKhachHang.setText("Khách hàng");

        javax.swing.GroupLayout jpnKhachHangLayout = new javax.swing.GroupLayout(jpnKhachHang);
        jpnKhachHang.setLayout(jpnKhachHangLayout);
        jpnKhachHangLayout.setHorizontalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnKhachHangLayout.setVerticalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnNhanVien.setBackground(new java.awt.Color(255, 102, 51));
        jpnNhanVien.setPreferredSize(new java.awt.Dimension(0, 65));

        jlbNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        jlbNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbNhanVien.setText("Nhân viên");

        javax.swing.GroupLayout jpnNhanVienLayout = new javax.swing.GroupLayout(jpnNhanVien);
        jpnNhanVien.setLayout(jpnNhanVienLayout);
        jpnNhanVienLayout.setHorizontalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnNhanVienLayout.setVerticalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnKhuyenMai.setBackground(new java.awt.Color(255, 102, 51));
        jpnKhuyenMai.setPreferredSize(new java.awt.Dimension(0, 65));

        jlbKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        jlbKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbKhuyenMai.setText("Khuyến mãi");

        javax.swing.GroupLayout jpnKhuyenMaiLayout = new javax.swing.GroupLayout(jpnKhuyenMai);
        jpnKhuyenMai.setLayout(jpnKhuyenMaiLayout);
        jpnKhuyenMaiLayout.setHorizontalGroup(
            jpnKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnKhuyenMaiLayout.setVerticalGroup(
            jpnKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbKhuyenMai)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jpnThongKe.setBackground(new java.awt.Color(255, 102, 51));
        jpnThongKe.setPreferredSize(new java.awt.Dimension(0, 65));

        jlbThongKe.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbThongKe.setForeground(new java.awt.Color(255, 255, 255));
        jlbThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbThongKe.setText("Thống kê");

        javax.swing.GroupLayout jpnThongKeLayout = new javax.swing.GroupLayout(jpnThongKe);
        jpnThongKe.setLayout(jpnThongKeLayout);
        jpnThongKeLayout.setHorizontalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnThongKeLayout.setVerticalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnThoat.setBackground(new java.awt.Color(153, 153, 153));
        jpnThoat.setPreferredSize(new java.awt.Dimension(244, 65));

        btnThoat.setBackground(new java.awt.Color(153, 153, 153));
        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnThoatLayout = new javax.swing.GroupLayout(jpnThoat);
        jpnThoat.setLayout(jpnThoatLayout);
        jpnThoatLayout.setHorizontalGroup(
            jpnThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnThoatLayout.setVerticalGroup(
            jpnThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
            .addComponent(jpnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
            .addComponent(jpnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
            .addComponent(jpnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
            .addComponent(jpnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
            .addComponent(jpnKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
            .addComponent(jpnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
            .addComponent(jpnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
        );

        jpnView.setBackground(new java.awt.Color(255, 255, 153));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1112, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

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
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThoat;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlbBanHang;
    private javax.swing.JLabel jlbDongHo;
    private javax.swing.JLabel jlbHoaDon;
    private javax.swing.JLabel jlbKhachHang;
    private javax.swing.JLabel jlbKhuyenMai;
    private javax.swing.JLabel jlbNhanVien;
    private javax.swing.JLabel jlbSanPham;
    private javax.swing.JLabel jlbThongKe;
    private javax.swing.JPanel jpnBanHang;
    private javax.swing.JPanel jpnHoaDon;
    private javax.swing.JPanel jpnKhachHang;
    private javax.swing.JPanel jpnKhuyenMai;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnNhanVien;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnSanPham;
    private javax.swing.JPanel jpnThoat;
    private javax.swing.JPanel jpnThongKe;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
