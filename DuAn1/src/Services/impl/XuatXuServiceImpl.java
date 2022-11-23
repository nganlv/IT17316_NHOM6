/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.XuatXu;
import Repository.XuatXuRepo;
import Services.QlXuatXu;
import ViewModels.QuanLyXuatXu;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class XuatXuServiceImpl implements QlXuatXu{
    final XuatXuRepo cvRepo = new XuatXuRepo();

//    public List<XuatXu> getAll() {
//      
//    }

    @Override
    public Boolean checkMa(String maXuatXu) {
        List<XuatXu> listCV = cvRepo.getView();
        for (XuatXu cv : listCV) {
            if(cv.getMa().equalsIgnoreCase(maXuatXu)){
                return true;
            }
        }
        return false;
    }

//    public String addCV(XuatXu cv) throws SQLException {
//        if(cvRepo.addCV(cv) < 1){
//            return "Thêm thất bại";
//        }else{
//            return "Thêm thành công";
//        }
//    }

    @Override
    public String updateCV(XuatXu cv) {
        if(cvRepo.updateCV(cv) < 1){
            return "Sửa thất bại";
        }else{
            return "Sửa thành công";
        }
    }

    @Override
    public String deleteCV(String maXuatXu) {
        if(cvRepo.deleteCV(maXuatXu) < 1){
            return "Xóa thất bại";
        }else{
            return "Xóa thành công";
        }
    }

    @Override
    public XuatXu getOne(String maXuatXu) {
        return cvRepo.getOne(maXuatXu);
    }

    @Override
    public List<QuanLyXuatXu> getView() {
        return cvRepo.getAll();
    }

    @Override
    public List<XuatXu> getAlls() {
         return cvRepo.getView();
    }

    @Override
    public String addCVs(XuatXu cv) {
        try {
            if(cvRepo.addCV(cv) < 1){
                return "Thêm thất bại";
            }else{
                return "Thêm thành công";
            }
        } catch (SQLException ex) {
            Logger.getLogger(XuatXuServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
       
    
}
