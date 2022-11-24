/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.TheLoai;
import Repository.TheLoaiRepo;
import Services.QlTheLoai;
import ViewModels.QuanLyTheLoai;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class TheLoaiServiceImpl implements QlTheLoai{
    final TheLoaiRepo cvRepo = new TheLoaiRepo();

//    public List<TheLoai> getAll() {
//      
//    }

    @Override
    public Boolean checkMa(String maTheLoai) {
        List<TheLoai> listCV = cvRepo.getView();
        for (TheLoai cv : listCV) {
            if(cv.getMa().equalsIgnoreCase(maTheLoai)){
                return true;
            }
        }
        return false;
    }

//    public String addCV(TheLoai cv) throws SQLException {
//        if(cvRepo.addCV(cv) < 1){
//            return "Thêm thất bại";
//        }else{
//            return "Thêm thành công";
//        }
//    }

    @Override
    public String updateCV(TheLoai cv) {
        if(cvRepo.updateCV(cv) < 1){
            return "Sửa thất bại";
        }else{
            return "Sửa thành công";
        }
    }

    @Override
    public String deleteCV(String maTheLoai) {
        if(cvRepo.deleteCV(maTheLoai) < 1){
            return "Xóa thất bại";
        }else{
            return "Xóa thành công";
        }
    }

    @Override
    public TheLoai getOne(String maTheLoai) {
        return cvRepo.getOne(maTheLoai);
    }

    @Override
    public List<QuanLyTheLoai> getView() {
        return cvRepo.getAll();
    }

    @Override
    public List<TheLoai> getAlls() {
         return cvRepo.getView();
    }

    @Override
    public String addCVs(TheLoai cv) {
        try {
            if(cvRepo.addCV(cv) < 1){
                return "Thêm thất bại";
            }else{
                return "Thêm thành công";
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
       
    
}
