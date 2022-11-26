/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.TaiKhoan;
import Repository.TaiKhoanRepo;
import Services.QLTaiKhoan;
import ViewModels.QuanLyTaiKhoan;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;


/**
 *
 * @author nguye
 */
public class ITaiKhoan implements QLTaiKhoan{
     private TaiKhoanRepo TKRepo=new TaiKhoanRepo();
    @Override
    public List<QuanLyTaiKhoan> getView() {
        return TKRepo.getAll();
    }
    @Override
    public List<TaiKhoan> getAlls() {
        return TKRepo.getView();
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
              }} catch (Exception ex) {
            ex.printStackTrace();
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

    @Override
    public TaiKhoan getOne(String maTK) {
        return TKRepo.getOne(maTK);
    }
}
