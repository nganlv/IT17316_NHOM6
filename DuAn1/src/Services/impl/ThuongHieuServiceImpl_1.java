/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.ThuongHieu;
import Repository.ThuongHieuRepo;
import Services.QlThuongHieu;
import ViewModels.QuanLyThuongHieu;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ThuongHieuServiceImpl_1 implements QlThuongHieu{
    final ThuongHieuRepo cvRepo = new ThuongHieuRepo();

//    public List<ThuongHieu> getAll() {
//      
//    }

    @Override
    public Boolean checkMa(String maThuongHieu) {
        List<ThuongHieu> listCV = cvRepo.getView();
        for (ThuongHieu cv : listCV) {
            if(cv.getMa().equalsIgnoreCase(maThuongHieu)){
                return true;
            }
        }
        return false;
    }

//    public String addCV(ThuongHieu cv) throws SQLException {
//        if(cvRepo.addCV(cv) < 1){
//            return "Thêm thất bại";
//        }else{
//            return "Thêm thành công";
//        }
//    }

    @Override
    public String updateCV(ThuongHieu cv) {
        if(cvRepo.updateCV(cv) < 1){
            return "Sửa thất bại";
        }else{
            return "Sửa thành công";
        }
    }

    @Override
    public String deleteCV(String maThuongHieu) {
        if(cvRepo.deleteCV(maThuongHieu) < 1){
            return "Xóa thất bại";
        }else{
            return "Xóa thành công";
        }
    }

    @Override
    public ThuongHieu getOne(String maThuongHieu) {
        return cvRepo.getOne(maThuongHieu);
    }

    @Override
    public List<QuanLyThuongHieu> getView() {
        return cvRepo.getAll();
    }

    @Override
    public List<ThuongHieu> getAlls() {
         return cvRepo.getView();
    }

    @Override
    public String addCVs(ThuongHieu cv) {
        try {
            if(cvRepo.addCV(cv) < 1){
                return "Thêm thất bại";
            }else{
                return "Thêm thành công";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThuongHieuServiceImpl_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
       
    
}
