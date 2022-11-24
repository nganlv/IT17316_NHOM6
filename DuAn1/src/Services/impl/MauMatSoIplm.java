/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import Repository.MauMatSoRepo;
import Services.MauMatSoSer;
import ViewModels.MauMatSo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Acer
 */
public class MauMatSoIplm implements MauMatSoSer {

    private final MauMatSoRepo mMSre = new MauMatSoRepo();

    @Override
    public ArrayList<MauMatSo> getView() {
        try {
            return mMSre.getAll();
        } catch (Exception ex) {
            Logger.getLogger(MauMatSoIplm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Boolean checkMa(String Ma) {
        ArrayList<MauMatSo> list;
        try {
            list = mMSre.getAll();
            for (MauMatSo m : list) {
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
    public String add(MauMatSo mau) {
        try {
            if (mMSre.insert(mau) < 1) {
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
        if (mMSre.delete(mau) < 1) {
            return "Xóa thất bại";
        } else {
            return "Xóa thành công";
        }
    }

    @Override
    public String update(MauMatSo mau) {
         if(mMSre.updateK(mau) < 1){
            return "Sửa thất bại";
        }else{
            return "Sửa thành công";
        }
    }

}
