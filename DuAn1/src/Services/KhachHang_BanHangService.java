/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Service.Interface.IKhachHang_BanHangService;
import DomainModels.KhachHang_BanHang;
import Repository.Interface.IKhachHang_BanHangRepo;
import Repository.KhachHang_BanHangRepo;
import ViewModels.QlKhachHang_BanHang;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class KhachHang_BanHangService implements IKhachHang_BanHangService {

    private final IKhachHang_BanHangRepo iKhachHang_BanHangRepo = new KhachHang_BanHangRepo();

    public List<QlKhachHang_BanHang> getAllKhs() {
        try {
            List<QlKhachHang_BanHang> listKh = new ArrayList<>();
            for (KhachHang_BanHang kh : iKhachHang_BanHangRepo.getAllKh()) {
                listKh.add(new QlKhachHang_BanHang(kh.getMa(), kh.getHoTen(), kh.getGioiTinh(), kh.getNgaySinh(), kh.getSdt(),
                        kh.getDiaChi(), kh.getEmail(), kh.getNgayTao(), kh.getNgayHh(), kh.getDiem()));
            }
            return listKh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer addKhs(QlKhachHang_BanHang kh) {
        try {
            return iKhachHang_BanHangRepo.addKh(new KhachHang_BanHang(kh.getMa(), kh.getHoTen(), kh.getGioiTinh(), kh.getNgaySinh(), kh.getSdt(),
                    kh.getDiaChi(), kh.getEmail(), kh.getNgayTao(), kh.getNgayHh(), kh.getDiem()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Integer updateKhs(QlKhachHang_BanHang kh) {
        try {
            return iKhachHang_BanHangRepo.updateKh(new KhachHang_BanHang(kh.getMa(), kh.getHoTen(), kh.getGioiTinh(), kh.getNgaySinh(), kh.getSdt(),
                    kh.getDiaChi(), kh.getEmail(), kh.getNgayTao(), kh.getNgayHh(), kh.getDiem()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<QlKhachHang_BanHang> timKhs(String ten) {
        try {
            List<QlKhachHang_BanHang> listKh = new ArrayList<>();
            for (KhachHang_BanHang kh : iKhachHang_BanHangRepo.timKh(ten)) {
                listKh.add(new QlKhachHang_BanHang(kh.getMa(), kh.getHoTen(), kh.getGioiTinh(), kh.getNgaySinh(), kh.getSdt(),
                        kh.getDiaChi(), kh.getEmail(), kh.getNgayTao(), kh.getNgayHh(), kh.getDiem()));
            }
            return listKh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
