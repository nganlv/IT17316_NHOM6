/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.ChucVu;
import Repository.ChucVuRepo;
import Services.QlChucVu;
import ViewModels.QuanLyChucVu;

import java.util.List;



public class ChucVuServiceImpl implements QlChucVu{
    final ChucVuRepo cvRepo = new ChucVuRepo();

    @Override
    public List<ChucVu> getAll() {
        return cvRepo.getAlls();
    }

    @Override
    public Boolean checkMa(String maChucVu) {
        List<ChucVu> listCV = cvRepo.getAlls();
        for (ChucVu cv : listCV) {
            if(cv.getMa().equalsIgnoreCase(maChucVu)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String addCV(ChucVu cv) {
        if(cvRepo.addCV(cv) < 1){
            return "Thêm thất bại";
        }else{
            return "Thêm thành công";
        }
    }

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
    
}
