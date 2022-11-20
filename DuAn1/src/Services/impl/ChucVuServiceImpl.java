/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.ChucVu;
import Repository.ChucVuRepo;
import Services.QlChucVu;
import ViewModels.QuanLyChucVu;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ChucVuServiceImpl implements QlChucVu{
    final ChucVuRepo cvRepo = new ChucVuRepo();

//    public List<ChucVu> getAll() {
//      
//    }

    @Override
    public Boolean checkMa(String maChucVu) {
        List<ChucVu> listCV = cvRepo.getView();
        for (ChucVu cv : listCV) {
            if(cv.getMa().equalsIgnoreCase(maChucVu)){
                return true;
            }
        }
        return false;
    }

//    public String addCV(ChucVu cv) throws SQLException {
//        if(cvRepo.addCV(cv) < 1){
//            return "Thêm thất bại";
//        }else{
//            return "Thêm thành công";
//        }
//    }

    @Override
    public String updateCV(ChucVu cv) {
        if(cvRepo.updateCV(cv) < 1){
            return "Sửa thất bại";
        }else{
            return "Sửa thành công";
        }
    }

    @Override
    public String deleteCV(String maChucVu) {
        if(cvRepo.deleteCV(maChucVu) < 1){
            return "Xóa thất bại";
        }else{
            return "Xóa thành công";
        }
    }

    @Override
    public ChucVu getOne(String maChucVu) {
        return cvRepo.getOne(maChucVu);
    }

    @Override
    public List<QuanLyChucVu> getView() {
        return cvRepo.getAll();
    }

    @Override
    public List<ChucVu> getAlls() {
         return cvRepo.getView();
    }

    @Override
    public String addCVs(ChucVu cv) {
        try {
            if(cvRepo.addCV(cv) < 1){
                return "Thêm thất bại";
            }else{
                return "Thêm thành công";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChucVuServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
       
    
}
