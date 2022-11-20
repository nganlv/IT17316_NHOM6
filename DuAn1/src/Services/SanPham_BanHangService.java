/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.SanPham_BanHang;
import Repository.ISanPham_BanHangRepo;
import Repository.SanPham_BanHangRepo;
import ViewModels.QLSanPham_BanHang;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class SanPham_BanHangService implements ISanPham_BanHangService {

    private final ISanPham_BanHangRepo iSanPham_BanHangRepo = new SanPham_BanHangRepo();

    public List<QLSanPham_BanHang> getAllSps() {
        try {
            List<QLSanPham_BanHang> listSp = new ArrayList<>();
            for (SanPham_BanHang sp : iSanPham_BanHangRepo.getAllSp()) {
                listSp.add(new QLSanPham_BanHang(sp.getMa(), sp.getTen(), sp.getDonGia(),sp.getGiamGia(),sp.getMauSac(), 
                        sp.getChatLieu(), sp.getKichThuoc(), sp.getLoai(),sp.getGioiTinh(),sp.getKieuMay(), sp.getSoLuong()));             
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<QLSanPham_BanHang> timSpTheoMas(String ma) {
        try {
            List<QLSanPham_BanHang> listSp = new ArrayList<>();
            for (SanPham_BanHang sp : iSanPham_BanHangRepo.timSpTheoMa(ma)) {
                listSp.add(new QLSanPham_BanHang(sp.getMa(), sp.getTen(), sp.getDonGia(),sp.getGiamGia(),sp.getMauSac(), 
                        sp.getChatLieu(), sp.getKichThuoc(), sp.getLoai(),sp.getGioiTinh(),sp.getKieuMay(), sp.getSoLuong()));             
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<QLSanPham_BanHang> timSpTheoMas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
