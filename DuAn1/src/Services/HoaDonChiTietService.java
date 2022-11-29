/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDonChiTiet;
import Repository.HoaDonChiTietRepo;
import Repository.Interface.IHoaDonChiTietRepo;
import Repository.Interface.IHoaDonChoRepo;
import Service.Interface.IHoaDonChiTietSer;
import ViewModels.QlHoaDonChiTiet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class HoaDonChiTietService implements IHoaDonChiTietSer{
    private final IHoaDonChiTietRepo iHoaDonChiTietRepo=(IHoaDonChiTietRepo) new HoaDonChiTietRepo();
    @Override
    public List<QlHoaDonChiTiet> getAllHdcts(String ma){
        try {
            List<QlHoaDonChiTiet> listHdct=new ArrayList<>();
            for(HoaDonChiTiet hdct:iHoaDonChiTietRepo.getAllHdct(ma)){
                listHdct.add(new QlHoaDonChiTiet(hdct.getMaSp(), hdct.getTenSp(), hdct.getDonGia(),hdct.getGiamGia(), hdct.getSoLuong(), hdct.getThanhTien()));
            }
            return listHdct;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Integer updateSls(QlHoaDonChiTiet hdct){
        try {
           return iHoaDonChiTietRepo.updateSl(new HoaDonChiTiet(hdct.getMaSp(), hdct.getTenSp(), hdct.getDonGia(),hdct.getGiamGia(), hdct.getSoLuong(), hdct.getThanhTien()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<QlHoaDonChiTiet> deletes(){
         try {
            List<QlHoaDonChiTiet> listHdct=new ArrayList<>();
            for(HoaDonChiTiet hdct:iHoaDonChiTietRepo.delete()){
                listHdct.add(new QlHoaDonChiTiet(hdct.getMaSp(), hdct.getTenSp(), hdct.getDonGia(),hdct.getGiamGia(), hdct.getSoLuong(), hdct.getThanhTien()));
            }
            return listHdct;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
