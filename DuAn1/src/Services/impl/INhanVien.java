/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import Repository.NhanVienRepo;
import Services.QLNhanVien;
import ViewModels.QuanLyNhanVien;
import java.util.List;

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
}
