/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Bean.DanhMucBean;
import Views.BanHangJpanel;
import Views.HoaDonJpanel;
import Views.KhachHangJpanel;
import Views.KhuyenMaiJpanel;
import Views.NhanVienJpanel;
import Views.SanPhamJpanel;
import Views.ThongKeJpanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author levan
 */
public class ChuyenManHinhController {

    private JPanel root;
    private String kindSelected = "";
    private List<DanhMucBean> listItem = null;

    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "BanHang";

        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        

        root.validate();
        root.repaint();
        root.add(new BanHangJpanel());
    }

    public void setEvent(List<DanhMucBean> listItem) {
        this.listItem = listItem;

        for (DanhMucBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "ThongKe":
                    node = new ThongKeJpanel();
                    break;
                case "BanHang":
                    node = new BanHangJpanel();
                    break;
                case "HoaDon":
                    node = new HoaDonJpanel();
                    break;
                case "NhanVien":
                    node = new NhanVienJpanel();
                    break;
                case "SanPham":
                    node = new SanPhamJpanel();
                    break;
                case "KhachHang":
                    node = new KhachHangJpanel();
                    break;
                case "KhuyenMai":
                    node = new KhuyenMaiJpanel();
                    break;
                default:
                    node = new BanHangJpanel();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(255, 102, 51));
                jlbItem.setBackground(new Color(255, 102, 51));
            }
        }

        private void setChangeBackground(String kind) {
            for (DanhMucBean item : listItem) {
                if (item.getKind().equalsIgnoreCase(kind)) {
                    item.getJlb().setBackground(new Color(96, 100, 191));
                    item.getJpn().setBackground(new Color(96, 100, 191));
                } else {
                    item.getJlb().setBackground(new Color(255, 102, 51));
                    item.getJpn().setBackground(new Color(255, 102, 51));
                }
            }
        }

    }
}
