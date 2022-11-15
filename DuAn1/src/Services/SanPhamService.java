/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.SanPham;
import Repository.SanPhamRepo;
import ViewModels.QuanLySanPham;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class SanPhamService implements ISanPhamService {

    private final SanPhamRepo sanPhamRepo = new SanPhamRepo();

    public List<QuanLySanPham> getAllSps() {
        try {
            List<QuanLySanPham> listSp = new ArrayList<>();
            for (SanPham sp : sanPhamRepo.getAllSp()) {
                listSp.add(new QuanLySanPham(sp.getMa(), sp.getTen(), sp.getThuongHieu(), sp.getXuatXu(), sp.getGioiTinh(),
                        sp.getMauSac(), sp.getKichThuoc(), sp.getChatLieu(), sp.getNamBh(), sp.getDonGia(), sp.getSoLuong()));             
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
