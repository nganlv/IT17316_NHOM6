/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModels.ChucVu;
import DomainModels.NhanVien;
import DomainModels.TaiKhoan;
import Service.Interface.IChucVuSer;
import Services.QLTaiKhoan;
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
private final Services.QLNhanVien nvService=new INhanVien();
private final QLTaiKhoan tkService=new ITaiKhoan();
private final IChucVuSer cvService=new ChucVuServiceImpl();
DefaultTableModel model = new DefaultTableModel();
    /**
     * Creates new form NhanVienJpanel
     */
    public NhanVienJpanel() {
        initComponents();
        
         LoadTable();
         loadCombobox();
        
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

    private void loadCombobox() {
    List<TaiKhoan> Listtk=tkService.getAlls();
        cbTK.removeAllItems();
        for (TaiKhoan taiKhoan : Listtk) {
            cbTK.addItem(taiKhoan);
        }
          List<ChucVu> listCV = cvService.getAll();
        cbCV.removeAllItems();
        for (ChucVu cv : listCV) {
            cbCV.addItem(cv);
          cbLoc.addItem(cv);
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
            } else {
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
 public List<QuanLyNhanVien> tim() {
        if (txtSearch.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "vui lòng nhập mã để tìm");
            return null;

        } else {
//            RowFilter<DefaultTableModel,Object> rf=RowFilter.regexFilter(cbLoc.getSelectedItem().toString(),0);
//             sorter.setRowFilter(rf);
            String ten = txtSearch.getText();
            model.setColumnIdentifiers(new String[]{"Mã nhân viên", "Tên",  "Giới tính", "Ngày sinh","SDT", "Địa chỉ",  "Email", "TaiKhoan", "Chức vụ", "Trạng thái"});
            model.setRowCount(0);
            List<QuanLyNhanVien> dsnv = nvService.getTims(ten);
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

        
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbCV = new javax.swing.JComboBox<ChucVu>();
        rdDanglam = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        rdDanghiviec = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnLoad = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnTim = new javax.swing.JButton();
        cbLoc = new javax.swing.JComboBox<ChucVu>();
        jLabel11 = new javax.swing.JLabel();
        btnLoc = new javax.swing.JButton();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        dpTime = new com.github.lgooddatepicker.components.DatePicker();
        txtEmail = new javax.swing.JTextField();
        cbTK = new javax.swing.JComboBox<TaiKhoan>();
        jButton5 = new javax.swing.JButton();

        cbCV.setModel(new javax.swing.DefaultComboBoxModel<ChucVu>());

        rdDanglam.setText("DANG LAM");

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("NHÂN VIÊN");

        rdDanghiviec.setText("DA NGHI VIEC");

        jLabel2.setText("MA");

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

        jLabel3.setText("TEN");

        jLabel4.setText("GIOI TINH");

        btnThem.setText("THEM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel5.setText("SÐT");

        btnSua.setText("SUA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel6.setText("NGAY SINH");

        btnXoa.setText("XOA");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel7.setText("DIA CHI");

        btnLoad.setText("LOAD");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        jLabel8.setText("TAI KHOAN");

        jLabel9.setText("EMAIL");

        jLabel10.setText("CHUC VU");

        btnTim.setText("tim");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        cbLoc.setModel(new javax.swing.DefaultComboBoxModel<ChucVu>());

        jLabel11.setText("TRANG THAI");

        btnLoc.setText("loc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        rdNam.setText("NAM");

        rdNu.setText("NU");

        cbTK.setModel(new javax.swing.DefaultComboBoxModel<TaiKhoan>());

        jButton5.setText("LAM MOI");

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
                                .addComponent(cbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnLoc)
                                .addGap(31, 31, 31)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnTim)
                                .addGap(119, 119, 119)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnThem)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnXoa)
                                            .addComponent(btnSua))
                                        .addGap(51, 51, 51)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton5)
                                            .addComponent(btnLoad)))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 61, Short.MAX_VALUE))
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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdDanglam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdDanghiviec, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                            .addComponent(cbTK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbCV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(312, 312, 312)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
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
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoc)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTim)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(btnThem)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSua)
                            .addComponent(jButton5))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa)
                            .addComponent(btnLoad))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        tim();

    }//GEN-LAST:event_btnTimActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model=new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã nhân viên", "Tên",  "Giới tính", "Ngày sinh","SDT", "Địa chỉ",  "Email", "TaiKhoan", "Chức vụ", "Trạng thái"});
        List<QuanLyNhanVien> listQlnv=nvService.getLOCs(String.valueOf(cbLoc.getItemAt(cbLoc.getSelectedIndex())));
        for (QuanLyNhanVien nv : listQlnv) {
            String trangThai;
            if(nv.getTrangthai()==1){
                trangThai="dang lam";
            }else{
                trangThai="Da nghi viec";
            }
            model.addRow(new Object[]{nv.getMa(),nv.getTen(),nv.getGioitinh(),formatDate(nv.getNgaysinh()),nv.getSdt(),nv.getDiachi(),nv.getEmail(),nv.getTaikhoan(),nv.getChucvu(),trangThai});
        }
        tblNhanVien.setModel(model);
    }//GEN-LAST:event_btnLocActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        LoadTable();
    }//GEN-LAST:event_btnLoadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<ChucVu> cbCV;
    private javax.swing.JComboBox<ChucVu> cbLoc;
    private javax.swing.JComboBox<TaiKhoan> cbTK;
    private com.github.lgooddatepicker.components.DatePicker dpTime;
    private javax.swing.JButton jButton5;
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
