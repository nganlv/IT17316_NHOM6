/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.ChucVu;
import DomainModels.TaiKhoan;
import Repository.ChucVuRepo;
import Repository.TaiKhoanRepo;
import Services.QLTaiKhoan;
import ViewModels.QuanLyTaiKhoan;
import ViewModels.QuanLyTaiKhoan;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class ITaiKhoan implements  QLTaiKhoan{
    private TaiKhoanRepo TKRepo=new TaiKhoanRepo();
    @Override
    public List<QuanLyTaiKhoan> getView() {
        return TKRepo.getAll();
    }
    
    @Override
    public Boolean checkMa(String maChucVu) {
        List<QuanLyTaiKhoan> listCV = TKRepo.getAll();
        for (QuanLyTaiKhoan cv : listCV) {
            if(cv.getMa().equalsIgnoreCase(maChucVu)){
                return true;
            }
        }
        return false;
    }
     @Override
    public String addCVs(TaiKhoan tk) {
          try {
              if(TKRepo.addTT(tk) < 1){
                  return "Thêm thất bại";
              }else{
                  return "Thêm thành công";
              } } catch (SQLException ex) {
              Logger.getLogger(QuanLyTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }
     @Override
    public String updateCV(TaiKhoan tk) {
        if(TKRepo.updateCV(tk) < 1){
            return "Sửa thất bại";
        }else{
            return "Sửa thành công";
        }
    }

    @Override
    public String deleteCV(String tk) {
        if(TKRepo.deleteCV(tk) < 1){
            return "Xóa thất bại";
        }else{
            return "Xóa thành công";
        }
    }
}
