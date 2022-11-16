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
    public String Insert(KhachHang kh) {
        try {
            if(KHR.insert(kh)<1){
                return "Theem that bai";
            }else{
                return "Them thanh cong";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
