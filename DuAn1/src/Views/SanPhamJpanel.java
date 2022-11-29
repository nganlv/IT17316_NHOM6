/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Service.Interface.IChatLieuDaySer;
import Services.ChiTietSanPhamService;
import Service.Interface.IChiTietSanPhamService;
import Service.Interface.IMauMatSoSer;
import Service.Interface.IMauVoSer;
import Service.Interface.IPhuKienSer;
import Service.Interface.ISanPhamSer;
import Service.Interface.ITheLoaiSer;
import Service.Interface.IThuongHieuSer;
import Service.Interface.ITinhNangSer;
import Service.Interface.IXuatXuSer;
import Services.ChatLieuDayService;
import Services.MauMatSoService;
import Services.MauVoService;
import Services.PhuKienService;
import Services.SanPhamService;
import Services.TheLoaiService;
import Services.ThuongHieuService;
import Services.TinhNangService;
import Services.XuatXuService;
import ViewModels.QlChatLieuDay;

import ViewModels.QlChiTietSanPham;
import ViewModels.QlMauMatSo;
import ViewModels.QlMauVo;
import ViewModels.QlPhuKien;
import ViewModels.QlSanPham;
import ViewModels.QlTheLoai;
import ViewModels.QlThuongHieu;
import ViewModels.QlTinhNang;
import ViewModels.QlXuatXu;

import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author levan
 */
public class SanPhamJpanel extends javax.swing.JPanel {

    private final IChiTietSanPhamService iChiTietSanPhamService = new ChiTietSanPhamService();
    private final ISanPhamSer iSanPhamSer = new SanPhamService();
    private final IThuongHieuSer iThuongHieuSer = new ThuongHieuService();
    private final IXuatXuSer iXuatXuSer = new XuatXuService();
    private final IChatLieuDaySer iChatLieuDaySer = new ChatLieuDayService();
    private IMauMatSoSer iMauMatSoSer = new MauMatSoService();
    private final IMauVoSer iMauVoSer = new MauVoService();
    private final IPhuKienSer iPhuKienSer = new PhuKienService();
    private final ITinhNangSer iTinhNangSer = new TinhNangService();
    private final ITheLoaiSer iTheLoaiSer = new TheLoaiService();

    /**
     * Creates new form SanPhamJpanel
     */
    public SanPhamJpanel() {
        initComponents();
        loadCombobox();
        loadCbSp();
        loadCbTh();
        loadCbXx();
        loadCbTl();
        loadCbCld();
        loadCbMms();
        loadCbMv();
        loadCbPk();
        loadCbTn();
        loadTableCtsp();
    }

    private void loadTableCtsp() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã", "Tên", "Thương hiệu", "Xuất xứ", "Giới tính", "Kiểu máy", "Thể loại", "Phụ kiện", "Tính năng", "Hình dạng mặt", "Chất liệu mặt", "Chất liệu dây", "Màu mặt số", "Màu vỏ", "Kích thước", "Đơn giá", "Năm bảo hành", "Số lượng tồn", "Tình trạng"});
        List<QlChiTietSanPham> listCtsp = iChiTietSanPhamService.getAllCtsps();
        if (listCtsp == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
            return;
        }
        for (QlChiTietSanPham ctsp : listCtsp) {
            model.addRow(new Object[]{ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.tinhTrange()});
        }
        tblChiTietSp.setModel(model);
    }
    

    private void loadCombobox() {
        String[] kieuMay = {"Pin", "Cơ", "Năng lượng ánh sáng"};
        String[] hinhDangMat = {"Vuông", "Chữ nhật", "Tròn"};
        String[] chatLieuMat = {"Kính cứng", "Kính Sapphire", "Kính nhựa"};
        String[] gioiTinh = {"Nam", "Nữ"};
        
        cboKieuMay.setModel(new DefaultComboBoxModel<>(kieuMay));
        cboHinhDangMat.setModel(new DefaultComboBoxModel<>(hinhDangMat));
        cboChatLieuMat.setModel(new DefaultComboBoxModel<>(chatLieuMat));
        cboGioiTinh.setModel(new DefaultComboBoxModel<>(gioiTinh));
    }

    private void loadCbSp() {
        List<QlSanPham> listSp = iSanPhamSer.getAllSps();
        if (listSp == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
        for (QlSanPham sp : listSp) {
            cboTen.addItem(sp.getTen());
        }
    }

    private void loadCbTh() {
        List<QlThuongHieu> listTh = iThuongHieuSer.getAllThs();
        if (listTh == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
        for (QlThuongHieu th : listTh) {
            cboThuongHieu.addItem(th.getTen());
            cboThuongHieu2.addItem(th.getTen());
        }

    }

    private void loadCbXx() {
        List<QlXuatXu> listXx = iXuatXuSer.getAllXxs();
        if (listXx == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
        for (QlXuatXu xx : listXx) {
            cboXuatXu.addItem(xx.getTen());
        }
    }

    private void loadCbTl() {
        List<QlTheLoai> listTl = iTheLoaiSer.getAllTls();
        if (listTl == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
        for (QlTheLoai tl : listTl) {
            cboTheLoai.addItem(tl.getTen());
        }
    }

    private void loadCbCld() {
        List<QlChatLieuDay> listCld = iChatLieuDaySer.getAllClds();
        if (listCld == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
        for (QlChatLieuDay cld : listCld) {
            cboChatLieuDay.addItem(cld.getTen());
        }
    }

    private void loadCbMms() {
        List<QlMauMatSo> listMms = iMauMatSoSer.getAllMmss();
        if (listMms == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
        for (QlMauMatSo mms : listMms) {
            cboMauMatSo.addItem(mms.getTen());
        }
    }

    private void loadCbMv() {
        List<QlMauVo> listMv = iMauVoSer.getAllMvs();
        if (listMv == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
        for (QlMauVo mv : listMv) {
            cboMauVo.addItem(mv.getTen());
        }
    }

    private void loadCbPk() {
        List<QlPhuKien> listPk = iPhuKienSer.getAllPks();
        if (listPk == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
        for (QlPhuKien pk : listPk) {
            cboPhuKien.addItem(pk.getTen());
        }
    }

    private void loadCbTn() {
        List<QlTinhNang> listTn = iTinhNangSer.getAllTns();
        if (listTn == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
        for (QlTinhNang tn : listTn) {
            cboTinhNang.addItem(tn.getTen());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        cboThuongHieu = new javax.swing.JComboBox<>();
        cboXuatXu = new javax.swing.JComboBox<>();
        rdoGioiTinh = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        cboKieuMay = new javax.swing.JComboBox<>();
        cboTheLoai = new javax.swing.JComboBox<>();
        txtKichThuoc = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        cboPhuKien = new javax.swing.JComboBox<>();
        cboTinhNang = new javax.swing.JComboBox<>();
        cboHinhDangMat = new javax.swing.JComboBox<>();
        cboChatLieuMat = new javax.swing.JComboBox<>();
        cboChatLieuDay = new javax.swing.JComboBox<>();
        txtNamBh = new javax.swing.JTextField();
        cboMauMatSo = new javax.swing.JComboBox<>();
        cboMauVo = new javax.swing.JComboBox<>();
        txtSoLuongTon = new javax.swing.JTextField();
        rdoTinhTrang = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChiTietSp = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboThuongHieu2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cboGioiTinh = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTimSp = new javax.swing.JTextField();
        btnTimSp = new javax.swing.JButton();
        rdoTinhTrang2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnTh = new javax.swing.JButton();
        btnXx = new javax.swing.JButton();
        btnTloai = new javax.swing.JButton();
        btnPk = new javax.swing.JButton();
        btnTn = new javax.swing.JButton();
        btnMv = new javax.swing.JButton();
        btnMms = new javax.swing.JButton();
        btnCld = new javax.swing.JButton();
        btnSp = new javax.swing.JButton();
        cboTen = new javax.swing.JComboBox<>();

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jLabel6.setText("Mã");

        jLabel7.setText("Tên");

        jLabel8.setText("Thương hiệu");

        jLabel9.setText("Xuất xứ");

        jLabel10.setText("Thể loại");

        jLabel11.setText("Chất liệu dây");

        jLabel12.setText("Màu mặt số");

        jLabel13.setText("Màu vỏ");

        jLabel14.setText("Phụ kiện");

        jLabel15.setText("Tính năng");

        jLabel16.setText("Hình dạng mặt số");

        jLabel17.setText("Chất liệu mặt kính");

        jLabel18.setText("Giới tính");

        jLabel19.setText("Kiểu máy");

        jLabel20.setText("Năm bảo hành");

        jLabel21.setText("Số lượng tồn");

        jLabel22.setText("Kích thước");

        jLabel23.setText("Đơn giá");

        jLabel24.setText("Tình trạng");

        buttonGroup1.add(rdoGioiTinh);
        rdoGioiTinh.setText("Nam");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Nữ");

        txtSoLuongTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongTonActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoTinhTrang);
        rdoTinhTrang.setText("Kinh doanh");

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Ngừng kinh doanh");

        tblChiTietSp.setModel(new javax.swing.table.DefaultTableModel(
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
        tblChiTietSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietSpMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblChiTietSp);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Lọc sản phẩm");

        cboThuongHieu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThuongHieu2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Thương hiệu");

        cboGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGioiTinhActionPerformed(evt);
            }
        });

        jLabel3.setText("Giới tính");

        jLabel4.setText("Tình trạng");

        btnTimSp.setBackground(new java.awt.Color(255, 255, 102));
        btnTimSp.setText("Tìm");
        btnTimSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimSpActionPerformed(evt);
            }
        });

        buttonGroup3.add(rdoTinhTrang2);
        rdoTinhTrang2.setText("Kinh doanh");

        buttonGroup3.add(jRadioButton3);
        jRadioButton3.setText("Ngừng kinh doanh");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel2)
                        .addGap(161, 161, 161)
                        .addComponent(jLabel3)
                        .addGap(82, 82, 82))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(cboThuongHieu2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(rdoTinhTrang2)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(btnTimSp)
                        .addGap(27, 27, 27)
                        .addComponent(txtTimSp, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboThuongHieu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimSp)
                    .addComponent(rdoTinhTrang2)
                    .addComponent(jRadioButton3))
                .addGap(24, 24, 24))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnThem.setBackground(new java.awt.Color(255, 255, 102));
        btnThem.setText("Thêm");

        btnSua.setBackground(new java.awt.Color(255, 255, 102));
        btnSua.setText("Sửa");

        btnXoa.setBackground(new java.awt.Color(255, 255, 102));
        btnXoa.setText("Xóa");

        btnReset.setBackground(new java.awt.Color(255, 255, 102));
        btnReset.setText("Làm mới");

        btnLoad.setBackground(new java.awt.Color(255, 255, 102));
        btnLoad.setText("Tất cả sản phẩm");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnLoad)
                        .addGap(73, 73, 73)))
                .addGap(42, 42, 42))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnTh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTh.setText("+");
        btnTh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThActionPerformed(evt);
            }
        });

        btnXx.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXx.setText("+");
        btnXx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXxActionPerformed(evt);
            }
        });

        btnTloai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTloai.setText("+");
        btnTloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTloaiActionPerformed(evt);
            }
        });

        btnPk.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPk.setText("+");
        btnPk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPkActionPerformed(evt);
            }
        });

        btnTn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTn.setText("+");
        btnTn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTnActionPerformed(evt);
            }
        });

        btnMv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMv.setText("+");
        btnMv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMvActionPerformed(evt);
            }
        });

        btnMms.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMms.setText("+");
        btnMms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMmsActionPerformed(evt);
            }
        });

        btnCld.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCld.setText("+");
        btnCld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCldActionPerformed(evt);
            }
        });

        btnSp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSp.setText("+");
        btnSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdoGioiTinh)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2))
                            .addComponent(cboKieuMay, 0, 132, Short.MAX_VALUE)
                            .addComponent(cboXuatXu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboThuongHieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboTen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMa)
                            .addComponent(cboTheLoai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSp)
                                    .addComponent(btnTh)
                                    .addComponent(btnXx)
                                    .addComponent(btnTloai))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboPhuKien, 0, 134, Short.MAX_VALUE)
                            .addComponent(cboMauMatSo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboChatLieuDay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboChatLieuMat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboHinhDangMat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboTinhNang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboMauVo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPk)
                            .addComponent(btnTn)
                            .addComponent(btnCld)
                            .addComponent(btnMms)
                            .addComponent(btnMv))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addGap(38, 38, 38)
                                        .addComponent(rdoTinhTrang)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton4))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23)
                                            .addComponent(jLabel22))
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel21))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNamBh, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 46, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel14)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPhuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(txtKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPk))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel15)
                    .addComponent(cboTinhNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTn)
                    .addComponent(btnSp)
                    .addComponent(cboTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel16)
                    .addComponent(cboThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboHinhDangMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamBh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTh)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel17)
                    .addComponent(cboXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboChatLieuMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXx))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel11)
                    .addComponent(rdoGioiTinh)
                    .addComponent(jRadioButton2)
                    .addComponent(cboChatLieuDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCld)
                    .addComponent(jLabel24)
                    .addComponent(rdoTinhTrang)
                    .addComponent(jRadioButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(cboKieuMay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(cboMauMatSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMms))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cboTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(cboMauVo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTloai)
                            .addComponent(btnMv)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sản phẩm chi tiết", jPanel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        loadTableCtsp();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void txtSoLuongTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongTonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongTonActionPerformed

    private void btnSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpActionPerformed
        new FormSanPham().setVisible(true);
    }//GEN-LAST:event_btnSpActionPerformed

    private void btnThActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThActionPerformed
        new FormThuongHieu().setVisible(true);
    }//GEN-LAST:event_btnThActionPerformed

    private void btnXxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXxActionPerformed
        new FormXuatXu().setVisible(true);
    }//GEN-LAST:event_btnXxActionPerformed

    private void btnTloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTloaiActionPerformed
        new FormTheLoai().setVisible(true);
    }//GEN-LAST:event_btnTloaiActionPerformed

    private void btnPkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPkActionPerformed
        new FormPhuKien().setVisible(true);
    }//GEN-LAST:event_btnPkActionPerformed

    private void btnTnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTnActionPerformed
        new FormTinhNang().setVisible(true);
    }//GEN-LAST:event_btnTnActionPerformed

    private void btnCldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCldActionPerformed
        new FormChatLieuDay().setVisible(true);
    }//GEN-LAST:event_btnCldActionPerformed

    private void btnMmsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMmsActionPerformed
        new FormMauMatSo().setVisible(true);
    }//GEN-LAST:event_btnMmsActionPerformed

    private void btnMvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMvActionPerformed
        new FormMauVo().setVisible(true);
    }//GEN-LAST:event_btnMvActionPerformed

    private void cboThuongHieu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThuongHieu2ActionPerformed
      locSpTheoTH();
    }//GEN-LAST:event_cboThuongHieu2ActionPerformed
   
    private void cboGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGioiTinhActionPerformed
        locSpTheoGT();
    }//GEN-LAST:event_cboGioiTinhActionPerformed

    private void btnTimSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimSpActionPerformed
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã", "Tên", "Thương hiệu", "Xuất xứ", "Giới tính", "Kiểu máy", "Thể loại", "Phụ kiện", "Tính năng", "Hình dạng mặt", "Chất liệu mặt", "Chất liệu dây", "Màu mặt số", "Màu vỏ", "Kích thước", "Đơn giá", "Năm bảo hành", "Số lượng tồn", "Tình trạng"});
        List<QlChiTietSanPham> listCtsp = iChiTietSanPhamService.timSps(txtTimSp.getText());
        if (listCtsp == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
            return;
        }
        for (QlChiTietSanPham ctsp : listCtsp) {
            model.addRow(new Object[]{ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.tinhTrange()});
        }
        tblChiTietSp.setModel(model);
    }//GEN-LAST:event_btnTimSpActionPerformed
private void fillCtsp(int index){
    List<QlChiTietSanPham> listCtsp = iChiTietSanPhamService.getAllCtsps();
    txtMa.setText(listCtsp.get(index).getMa());
    cboTen.getModel().setSelectedItem(listCtsp.get(index).getTen());
    cboThuongHieu.getModel().setSelectedItem(listCtsp.get(index).getThuongHieu());
    cboXuatXu.getModel().setSelectedItem(listCtsp.get(index).getXuatXu());
    cboTheLoai.getModel().setSelectedItem(listCtsp.get(index).getTheLoai());
    cboKieuMay.getModel().setSelectedItem(listCtsp.get(index).getKieuMay());
    cboPhuKien.getModel().setSelectedItem(listCtsp.get(index).getPhuKien());
    cboTinhNang.getModel().setSelectedItem(listCtsp.get(index).getTinhNang());
    cboHinhDangMat.getModel().setSelectedItem(listCtsp.get(index).getHinhDangMat());
    cboChatLieuMat.getModel().setSelectedItem(listCtsp.get(index).getChatLieuMat());
    cboChatLieuDay.getModel().setSelectedItem(listCtsp.get(index).getChatLieuDay());
    cboMauMatSo.getModel().setSelectedItem(listCtsp.get(index).getMauMat());
    cboMauVo.getModel().setSelectedItem(listCtsp.get(index).getMauVo());
    txtKichThuoc.setText(listCtsp.get(index).getKichThuoc());
    txtDonGia.setText(listCtsp.get(index).getDonGia());
    txtNamBh.setText(String.valueOf(listCtsp.get(index).getNamBh()));
    txtSoLuongTon.setText(String.valueOf(listCtsp.get(index).getSoLuong()));
}
    private void tblChiTietSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietSpMouseClicked
        int index=tblChiTietSp.getSelectedRow();
        fillCtsp(index);
    }//GEN-LAST:event_tblChiTietSpMouseClicked
    private void locSpTheoTH() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã", "Tên", "Thương hiệu", "Xuất xứ", "Giới tính", "Kiểu máy", "Thể loại", "Phụ kiện", "Tính năng", "Hình dạng mặt", "Chất liệu mặt", "Chất liệu dây", "Màu mặt số", "Màu vỏ", "Kích thước", "Đơn giá", "Năm bảo hành", "Số lượng tồn", "Tình trạng"});
        List<QlChiTietSanPham> listCtsp = iChiTietSanPhamService.locSpTheoTHs(cboThuongHieu2.getItemAt(cboThuongHieu2.getSelectedIndex()));
        if (listCtsp == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
            return;
        }
        for (QlChiTietSanPham ctsp : listCtsp) {
            model.addRow(new Object[]{ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.tinhTrange()});
        }
        tblChiTietSp.setModel(model);
    }

    private void locSpTheoGT() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã", "Tên", "Thương hiệu", "Xuất xứ", "Giới tính", "Kiểu máy", "Thể loại", "Phụ kiện", "Tính năng", "Hình dạng mặt", "Chất liệu mặt", "Chất liệu dây", "Màu mặt số", "Màu vỏ", "Kích thước", "Đơn giá", "Năm bảo hành", "Số lượng tồn", "Tình trạng"});
        List<QlChiTietSanPham> listCtsp = iChiTietSanPhamService.locSpTheoGTs(cboGioiTinh.getItemAt(cboGioiTinh.getSelectedIndex()));
        if (listCtsp == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
            return;
        }
        for (QlChiTietSanPham ctsp : listCtsp) {
            model.addRow(new Object[]{ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.tinhTrange()});
        }
        tblChiTietSp.setModel(model);
    }

    private void locSpTheoTT() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã", "Tên", "Thương hiệu", "Xuất xứ", "Giới tính", "Kiểu máy", "Thể loại", "Phụ kiện", "Tính năng", "Hình dạng mặt", "Chất liệu mặt", "Chất liệu dây", "Màu mặt số", "Màu vỏ", "Kích thước", "Đơn giá", "Năm bảo hành", "Số lượng tồn", "Tình trạng"});
        List<QlChiTietSanPham> listCtsp = iChiTietSanPhamService.locSpTheoTTs ( rdoTinhTrang2.isSelected()?0:1);
        if (listCtsp == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
            return;
        }
        for (QlChiTietSanPham ctsp : listCtsp) {
            model.addRow(new Object[]{ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.tinhTrange()});
        }
        tblChiTietSp.setModel(model);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCld;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnMms;
    private javax.swing.JButton btnMv;
    private javax.swing.JButton btnPk;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSp;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTh;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimSp;
    private javax.swing.JButton btnTloai;
    private javax.swing.JButton btnTn;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXx;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cboChatLieuDay;
    private javax.swing.JComboBox<String> cboChatLieuMat;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JComboBox<String> cboHinhDangMat;
    private javax.swing.JComboBox<String> cboKieuMay;
    private javax.swing.JComboBox<String> cboMauMatSo;
    private javax.swing.JComboBox<String> cboMauVo;
    private javax.swing.JComboBox<String> cboPhuKien;
    private javax.swing.JComboBox<String> cboTen;
    private javax.swing.JComboBox<String> cboTheLoai;
    private javax.swing.JComboBox<String> cboThuongHieu;
    private javax.swing.JComboBox<String> cboThuongHieu2;
    private javax.swing.JComboBox<String> cboTinhNang;
    private javax.swing.JComboBox<String> cboXuatXu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoGioiTinh;
    private javax.swing.JRadioButton rdoTinhTrang;
    private javax.swing.JRadioButton rdoTinhTrang2;
    private javax.swing.JTable tblChiTietSp;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtKichThuoc;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNamBh;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtTimSp;
    // End of variables declaration//GEN-END:variables
}
