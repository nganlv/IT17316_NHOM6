/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Service.Interface.IChiTietSanPhamService;
import DomainModels.ChiTietSanPham;
import Repository.ChiTietSanPhamRepo;
import Repository.Interface.IChiTietSanPhamRepo;
import ViewModels.QlChiTietSanPham;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class ChiTietSanPhamService implements IChiTietSanPhamService {

    private final IChiTietSanPhamRepo iChiTietSanPhamRepo = (IChiTietSanPhamRepo) new ChiTietSanPhamRepo();

    @Override
    public List<QlChiTietSanPham> getAllCtsps() {
        try {
            List<QlChiTietSanPham> listCtsp = new ArrayList<>();
            for (ChiTietSanPham ctsp : iChiTietSanPhamRepo.getAllCtsp()) {
                listCtsp.add(new QlChiTietSanPham(ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                        ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                        ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                        ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.getTinhTrang()));
            }
            return listCtsp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<QlChiTietSanPham> timSps(String ma) {
        try {
            List<QlChiTietSanPham> timSp = new ArrayList<>();
            for (ChiTietSanPham ctsp : iChiTietSanPhamRepo.timSp(ma)) {
                timSp.add(new QlChiTietSanPham(ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                        ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                        ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                        ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.getTinhTrang()));
            }
            return timSp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<QlChiTietSanPham> locSpTheoTHs(String th) {
        try {
            List<QlChiTietSanPham> listSp = new ArrayList<>();
            for (ChiTietSanPham ctsp : iChiTietSanPhamRepo.locSpTheoTH(th)) {
                listSp.add(new QlChiTietSanPham(ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                        ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                        ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                        ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.getTinhTrang()));
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<QlChiTietSanPham> locSpTheoGTs(String gt) {
        try {
            List<QlChiTietSanPham> listSp = new ArrayList<>();
            for (ChiTietSanPham ctsp : iChiTietSanPhamRepo.locSpTheoGT(gt)) {
                listSp.add(new QlChiTietSanPham(ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                        ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                        ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                        ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.getTinhTrang()));
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<QlChiTietSanPham> locSpTheoTTs(Integer tt) {
        try {
            List<QlChiTietSanPham> listSp = new ArrayList<>();
            for (ChiTietSanPham ctsp : iChiTietSanPhamRepo.locSpTheoTT(tt)) {
                listSp.add(new QlChiTietSanPham(ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                        ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                        ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                        ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.getTinhTrang()));
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
