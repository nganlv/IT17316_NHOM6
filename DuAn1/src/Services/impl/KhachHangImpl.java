/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import Repository.KhachHangRepo;
import Services.KhachHangService;
import ViewModels.KhachHang;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class KhachHangImpl implements KhachHangService {
    private final KhachHangRepo KHRepo = new KhachHangRepo();
    @Override
    public ArrayList<KhachHang> getAll() {
        
        try {
            return KHRepo.getAll();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        return null;
    }
    
}
