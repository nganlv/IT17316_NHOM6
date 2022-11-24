/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import Repository.ChucVuRepo;
import Services.QlChucVu;
import ViewModels.QuanLyChucVu;
import java.util.List;

/**
 *
 * @author nguye
 */
public class IChucVu implements QlChucVu{
private ChucVuRepo cvRepo=new ChucVuRepo();
    @Override
    public List<QuanLyChucVu> getView() {
        return cvRepo.getAll();
    }
    
    @Override
    public Boolean checkMa(String maChucVu) {
        List<QuanLyChucVu> listCV = cvRepo.getAll();
        for (QuanLyChucVu cv : listCV) {
            if(cv.getMa().equalsIgnoreCase(maChucVu)){
                return true;
            }
        }
        return false;
    }
}
