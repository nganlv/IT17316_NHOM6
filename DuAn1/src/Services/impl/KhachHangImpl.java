/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import Repository.KhachHangRepo;
import Services.KhachHangSer;
import ViewModels.KhachHang;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class KhachHangImpl implements KhachHangSer {

    private final KhachHangRepo KHR = new KhachHangRepo();

    @Override
    public ArrayList<KhachHang> getView() {
        try {
            return KHR.getAll();
        } catch (Exception ex) {
            Logger.getLogger(KhachHangImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Boolean checkMa(String maKhachHang) {
        ArrayList<KhachHang> list;
        try {
            list = KHR.getAll();
            for (KhachHang k : list) {
                if (k.getMaKH().equalsIgnoreCase(maKhachHang)) {
                    return true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public String add(KhachHang kH) {

        try {
            if (KHR.insert(kH) < 1) {
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
    public String delete(String KH) {
        if (KHR.deleteK(KH) < 1) {
            return "Xóa thất bại";
        } else {
            return "Xóa thành công";
        }
    }

    @Override
    public String update(KhachHang Kh) {
         if(KHR.updateK(Kh) < 1){
            return "Sửa thất bại";
        }else{
            return "Sửa thành công";
        }
    }

   

    @Override
    public ArrayList<KhachHang> Tim(String ma) {
          try {
            return KHR.getTim();
        } catch (Exception ex) {
            Logger.getLogger(KhachHangImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
