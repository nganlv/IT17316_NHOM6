/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.NhanVien;
import Repository.NhanVienRepo;
import Services.QLNhanVien;
import ViewModels.QuanLyNhanVien;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class INhanVien implements QLNhanVien{
   private NhanVienRepo nvRepo=new NhanVienRepo();
    
    @Override
   
    
    public List<QuanLyNhanVien> getAll() {
        return nvRepo.getAllNV();
    }
    @Override
    public String add(NhanVien nv) {
       try {
           if(nvRepo.addNV(nv) < 1){
               return "Thêm nhân viên thất bại";
           }else{
               return "Thêm nhân viên thành công";
           }
       } catch (SQLException ex) {
           Logger.getLogger(INhanVien.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
    }
    @Override
    public String update(NhanVien nv) {
        if(nvRepo.updates(nv) < 1){
            return "Sửa nhân viên thất bại";
        }else{
            return "Sửa nhân viên thành công";
        }
    }
    @Override
    public String delete(String maNV) {
        if(nvRepo.deletes(maNV) < 1){
            return "Xóa nhân viên thất bại";
        }else{
            return "Xóa nhân viên thành công";
        }
    }
}
