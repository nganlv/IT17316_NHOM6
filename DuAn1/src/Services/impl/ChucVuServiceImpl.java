/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.ChucVu;
import DomainModels.ChucVu;
import DomainModels.ChucVu;
import Repository.ChucVuRepo;

import Repository.ChucVuRepo;

import Repository.ChucVuRepo;
import Service.Interface.IChucVuSer;




import ViewModels.QuanLyChucVu;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class ChucVuServiceImpl implements IChucVuSer{
     
    private final ChucVuRepo iChucVuRepo = new ChucVuRepo();

    @Override
    public List<QuanLyChucVu> getAllThs() {
        try {
            List<QuanLyChucVu> listTh = new ArrayList<>();
            for (ChucVu th : iChucVuRepo.getAllTh()) {
                listTh.add(new QuanLyChucVu(th.getId(), th.getMa(), th.getTen()));
            }
            return listTh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addThs(QuanLyChucVu th) {
        try {
            return iChucVuRepo.addTh(new ChucVu(th.getId(), th.getMa(), th.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateThs(QuanLyChucVu th) {
        try {
            return iChucVuRepo.updateTh(new ChucVu(th.getId(), th.getMa(), th.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer deleteThs(String ma) {
        try {
            return iChucVuRepo.deleteTh(ma);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
}
