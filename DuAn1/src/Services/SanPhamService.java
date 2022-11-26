/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.SanPham;
import Repository.Interface.ISanPhamRepo;
import Repository.SanPhamRepo;
import Service.Interface.ISanPhamSer;
import ViewModels.QlSanPham;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class SanPhamService implements ISanPhamSer {

    private final ISanPhamRepo iSanPhamRepo = new SanPhamRepo();

    @Override
    public List<QlSanPham> getAllSps() {
        try {
            List<QlSanPham> listSp = new ArrayList<>();
            for (SanPham sp : iSanPhamRepo.getAllSp()) {
                listSp.add(new QlSanPham(sp.getId(), sp.getMa(), sp.getTen()));
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addSps(QlSanPham sp) {
        try {
            return iSanPhamRepo.addSp(new SanPham(sp.getId(), sp.getMa(), sp.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateSps(QlSanPham sp) {
        try {
            return iSanPhamRepo.updateSp(new SanPham(sp.getId(), sp.getMa(), sp.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer deleteSps(String ma) {
        try {
            return iSanPhamRepo.deleteSp(ma);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
