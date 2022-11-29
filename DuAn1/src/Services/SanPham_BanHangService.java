/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Service.Interface.ISanPham_BanHangService;
import DomainModels.SanPham_BanHang;
import Repository.Interface.ISanPham_BanHangRepo;
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

    @Override
    public List<QLSanPham_BanHang> getAllSps() {
        try {
            List<QLSanPham_BanHang> listSp = new ArrayList<>();
            for (SanPham_BanHang sp : iSanPham_BanHangRepo.getAllSp()) {

                listSp.add(new QLSanPham_BanHang(sp.getMa(), sp.getTen(), sp.getDonGia(), sp.getGiamGia(), sp.getHinhDangMat(),
                        sp.getChatLieuMat(), sp.getKichThuoc(), sp.getMauVo(), sp.getTheLoai(), sp.getGioiTinh(), sp.getKieuMay(), sp.getSoLuong()));

            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<QLSanPham_BanHang> timSpTheoMas(String ma) {
        try {
            List<QLSanPham_BanHang> listSp = new ArrayList<>();
            for (SanPham_BanHang sp : iSanPham_BanHangRepo.timSpTheoMa(ma)) {

                listSp.add(new QLSanPham_BanHang(sp.getMa(), sp.getTen(), sp.getDonGia(), sp.getGiamGia(), sp.getHinhDangMat(),
                        sp.getChatLieuMat(), sp.getKichThuoc(), sp.getMauVo(), sp.getTheLoai(), sp.getGioiTinh(), sp.getKieuMay(), sp.getSoLuong()));

            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
