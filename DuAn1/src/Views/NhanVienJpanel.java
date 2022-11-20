/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModels.ChucVu;
import DomainModels.NhanVien;
import DomainModels.TaiKhoan;
import Services.QLNhanVien;
import Services.QLTaiKhoan;
import Services.QlChucVu;
import Services.impl.ChucVuServiceImpl;
import Services.impl.INhanVien;
import Services.impl.ITaiKhoan;
import ViewModels.QuanLyNhanVien;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author levan
 */
public class NhanVienJpanel extends javax.swing.JPanel {
private final QLNhanVien nvService=new INhanVien();
private final QLTaiKhoan tkService=new ITaiKhoan();
private final QlChucVu cvService=new ChucVuServiceImpl();
DefaultTableModel model = new DefaultTableModel();

    /**
    /**
     * Creates new form NhanVienJpanel
     */
    public NhanVienJpanel() {
        initComponents();
       
         LoadTable();
         loadComboBox();
        dpTime.getSettings().setAllowKeyboardEditing(false);
        dpTime.getSettings().setDateRangeLimits(LocalDate.MIN, LocalDate.now());
        dpTime.getSettings().setFormatForDatesCommonEra("dd-MM-yyyy");
    }

    public String formatDate(Date date){
    SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        String StrDate = formater.format(date);
        return StrDate;
}
public void LoadTable(){
    List<QuanLyNhanVien> listNV =nvService.getAll();
    
    DefaultTableModel model=new DefaultTableModel();
    model.setColumnCount(0);
    model.setRowCount(0);
    model.setColumnIdentifiers(new String[]{"Mã nhân viên", "Tên",  "Giới tính", "Ngày sinh","SDT", "Địa chỉ",  "Email", "TaiKhoan", "Chức vụ", "Trạng thái"});
    for (QuanLyNhanVien nv : listNV) {
        String trangThai;
        if(nv.getTrangthai()==1){
            trangThai="dang lam";
        }else{
            trangThai="Da nghi viec";
        }
        model.addRow(new Object[]{nv.getMa(),nv.getTen(),nv.getGioitinh(),formatDate(nv.getNgaysinh()),nv.getSdt(),nv.getDiachi(),nv.getEmail(),nv.getTaikhoan(),nv.getChucvu(),trangThai});
    }
  tblNhanVien.setModel(model);
    
}
  public List<QuanLyNhanVien> tim() {
        if (txtSearch.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "vui lòng nhập mã để tìm");
            return null;

        } else {

            String ma = txtSearch.getText();
            model.setColumnIdentifiers(new String[]{"Mã nhân viên", "Tên",  "Giới tính", "Ngày sinh","SDT", "Địa chỉ",  "Email", "TaiKhoan", "Chức vụ", "Trạng thái"});
            model.setRowCount(0);
            List<QuanLyNhanVien> dsnv = nvService.getTims(ma);
            for (QuanLyNhanVien kh : dsnv) {
                String trangThai;
        if(kh.getTrangthai()==1){
            trangThai="dang lam";
        }else{
            trangThai="Da nghi viec";
        }
                Object[] row = new Object[]{
                    kh.getMa(),
                    kh.getTen(),
                    kh.getGioitinh(),
                    kh.getNgaysinh(),
                    kh.getSdt(),
                    kh.getDiachi(),
                kh.getEmail(),
                kh.getTaikhoan(),
                kh.getChucvu(),
                trangThai};
                model.addRow(row);
            }
            tblNhanVien.setModel(model);
       
            return dsnv;
        }
    }
public void loadComboBox(){
    List<TaiKhoan> listtk=tkService.getAlls();
    cbTK.removeAllItems();
    for (TaiKhoan taiKhoan : listtk) {
        cbTK.addItem(taiKhoan);
        
    }
      List<ChucVu> listCV = cvService.getAlls();
        cbCV.removeAllItems();
        for (ChucVu cv : listCV) {
            cbCV.addItem(cv);
        }
}
 public NhanVien getData(){
        NhanVien nv = new NhanVien();
        nv.setMa(txtMa.getText().trim());
        nv.setTen(txtTen.getText().trim());
        
        if(rdNam.isSelected()){
            nv.setGioitinh("Nam");
        }else{
            nv.setGioitinh("Nữ");
        }
        
        try {
            nv.setNgaysinh(new SimpleDateFormat("dd-MM-yyyy").parse(dpTime.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(NhanVienForm.class.getName()).log(Level.SEVERE, null, ex);
        }
         nv.setSdt(txtSdt.getText().trim());
        nv.setDiachi(txtDiaChi.getText().trim());
       
        nv.setEmail(txtEmail.getText().trim());
        
       TaiKhoan ch = (TaiKhoan) cbTK.getSelectedItem();
        ChucVu cv = (ChucVu) cbCV.getSelectedItem();
        
        nv.setIdtk(ch.getId());
        nv.setIdcv(cv.getId());
        
        if(rdDanglam.isSelected()){
            nv.setTrangthai(1);
      }else{
         nv.setTrangthai(0);
      }
      
      return nv;
   }
 public void loadTextField(){
        int index = tblNhanVien.getSelectedRow();
        txtMa.setText(tblNhanVien.getValueAt(index, 0).toString());
        txtTen.setText(tblNhanVien.getValueAt(index, 1).toString());
       
        
        if(tblNhanVien.getValueAt(index, 2).toString().equalsIgnoreCase("Nam")){
            rdNam.setSelected(true);
        }else{
            rdNu.setSelected(true);
        }
        
        dpTime.setText(tblNhanVien.getValueAt(index, 3).toString());
          txtSdt.setText(tblNhanVien.getValueAt(index, 4).toString());
        txtDiaChi.setText(tblNhanVien.getValueAt(index, 5).toString());
      
        txtEmail.setText(tblNhanVien.getValueAt(index, 6).toString());
        
        for (int i = 0; i < cbTK.getItemCount(); i++) {
            TaiKhoan tk = cbTK.getItemAt(i);
            if (tk.getTen().equalsIgnoreCase(tblNhanVien.getValueAt(index, 7).toString())) {
                cbTK.setSelectedIndex(i);
                break;
            }
        }
        
        for (int i = 0; i < cbCV.getItemCount(); i++) {
            ChucVu cv = cbCV.getItemAt(i);
            if (cv.getTen().equalsIgnoreCase(tblNhanVien.getValueAt(index, 8).toString())) {
                cbCV.setSelectedIndex(i);
                break;
            }
        }
        
        if(tblNhanVien.getValueAt(index, 9).toString().equalsIgnoreCase("dang lam")){
            rdDanglam.setSelected(true);
        }else{
            rdDanghiviec.setSelected(true);
        }
        
    }
 public boolean CheckValidate(){
     if(txtMa.getText().isBlank()|| txtTen.getText().isBlank()|| txtSdt.getText().isBlank()||txtDiaChi.getText().isBlank()||txtEmail.getText().isBlank()){
         JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu ");
         return false;
     }
     if(txtMa.getText().trim().length()>10){
         JOptionPane.showMessageDialog(this, "mã nhân viên không quá 10 ký tu");
         return false;
     }
     if(!rdNam.isSelected()&&!rdNu.isSelected()){
         JOptionPane.showMessageDialog(this,"Phải chọn 1 giới tính");
         return false;
     }
     if(dpTime.getText().isBlank()){
         JOptionPane.showMessageDialog(this, "Phải chọn 1 ngày sinh");
            return false;
                 
     }
      String regexSDT = "\\d{10}";
      if(!txtSdt.getText().matches(regexSDT)){
            JOptionPane.showMessageDialog(this, "Số điện thoại có 10 số");
            return false;
        }
      return true;
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        cbCV = new javax.swing.JComboBox<>();
        rdDanglam = new javax.swing.JRadioButton();
        rdDanghiviec = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        dpTime = new com.github.lgooddatepicker.components.DatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        cbTK = new javax.swing.JComboBox<TaiKhoan>();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        cbCV.setModel(new javax.swing.DefaultComboBoxModel<ChucVu>());

        buttonGroup2.add(rdDanglam);
        rdDanglam.setText("DANG LAM");

        buttonGroup2.add(rdDanghiviec);
        rdDanghiviec.setText("DA NGHI VIEC");

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        btnThem.setText("THEM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("SUA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("XOA");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jButton4.setText("LAM MOI");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setText("EMAIL");

        jLabel10.setText("CHUC VU");

        jLabel11.setText("TRANG THAI");

        buttonGroup1.add(rdNam);
        rdNam.setText("NAM");

        buttonGroup1.add(rdNu);
        rdNu.setText("NU");

        jLabel1.setText("NHÂN VIÊN");
        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));

        jLabel2.setText("MA");

        jLabel3.setText("TEN");

        jLabel4.setText("GIOI TINH");

        jLabel5.setText("SÐT");

        jLabel6.setText("NGAY SINH");

        jLabel7.setText("DIA CHI");

        jLabel8.setText("TAI KHOAN");

        cbTK.setModel(new javax.swing.DefaultComboBoxModel<TaiKhoan>());

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(139, 139, 139))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXoa)
                            .addComponent(jButton4)
                            .addComponent(btnSua)
                            .addComponent(btnThem)
                            .addComponent(btnSearch))
                        .addGap(0, 245, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMa)
                                    .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                    .addComponent(txtSdt, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(dpTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                        .addComponent(cbTK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbCV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdDanglam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(rdDanghiviec, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(312, 312, 312)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(rdNam)
                            .addComponent(rdNu)
                            .addComponent(cbTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(dpTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdDanglam)
                            .addComponent(rdDanghiviec))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(30, 30, 30)
                        .addComponent(jButton4)
                        .addGap(338, 338, 338))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        loadTextField();
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if(CheckValidate()){
            if(nvService.checkMa(txtMa.getText().trim())){
                JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại ");
            }else{
                JOptionPane.showMessageDialog(this, nvService.add(getData()));
                LoadTable();
            }

        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        JOptionPane.showMessageDialog(this, nvService.update(getData()));
        LoadTable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, nvService.delete(txtMa.getText().trim()));
        LoadTable();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         txtMa.setText(" ");
        txtTen.setText(" ");
        txtSdt.setText(" ");
        txtDiaChi.setText(" ");
        txtEmail.setText(" ");
        dpTime.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
      tim();
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<ChucVu> cbCV;
    private javax.swing.JComboBox<TaiKhoan> cbTK;
    private com.github.lgooddatepicker.components.DatePicker dpTime;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdDanghiviec;
    private javax.swing.JRadioButton rdDanglam;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
