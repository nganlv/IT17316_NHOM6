/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChiTietSanPham;
import Repository.ChiTietSanPhamRepo;
import Repository.IChiTietSanPhamRepo;
import ViewModels.QlChiTietSanPham;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class ChiTietSanPhamService implements IChiTietSanPhamService{
    private final IChiTietSanPhamRepo iChiTietSanPhamRepo=(IChiTietSanPhamRepo) new ChiTietSanPhamRepo();
   @Override
    public List<QlChiTietSanPham> getAllCtsps(){
        try {
            List<QlChiTietSanPham> listCtsp=new ArrayList<>();
            for(ChiTietSanPham ctsp: iChiTietSanPhamRepo.getAllCtsp()){
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
}
