/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;


import Repository.MauVoRepo;
import Services.MauVoSer;
import ViewModels.MauVo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;





/**
 *
 * @author Acer
 */
public class MauVoIplm implements MauVoSer {

    private final MauVoRepo mVre = new MauVoRepo();

    @Override
    public ArrayList<MauVo> getView() {
        try {
            return mVre.getAll();
        } catch (Exception ex) {
            Logger.getLogger(MauVoIplm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Boolean checkMa(String Ma) {
        ArrayList<MauVo> list;
        try {
            list = mVre.getAll();
            for (MauVo m : list) {
                if (m.getMa().equalsIgnoreCase(Ma)) {
                    return true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public String add(MauVo mau) {
        try {
            if (mVre.insert(mau) < 1) {
                return "Thêm thất bại";
            } else {
                return "Thêm thành công";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public String delete(String mau) {
        if (mVre.delete(mau) < 1) {
            return "Xóa thất bại";
        } else {
            return "Xóa thành công";
        }
    }

    @Override
    public String update(MauVo mau) {
         if(mVre.updateK(mau) < 1){
            return "Sửa thất bại";
        }else{
            return "Sửa thành công";
        }
    }

}
