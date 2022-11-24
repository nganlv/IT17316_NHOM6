/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.PhuKienQ;
import Repository.PhuKienQRepository;
import Services.IPhuKienQ;
import ViewModels.QuanLyPhuKienQ;
import java.awt.List;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguyenhongphong
 */
public class PhuKienQService implements IPhuKienQ {

    private PhuKienQRepository PKRepos = new PhuKienQRepository();

    @Override
    public ArrayList<QuanLyPhuKienQ>getAll(){
        try {
            ArrayList <QuanLyPhuKienQ> listMs = new ArrayList<>();
            for (PhuKienQ ms : PKRepos.getAll()) {
                listMs.add(new QuanLyPhuKienQ(ms.getId(), ms.getMa(), ms.getTen()));
            }
            return listMs;
        } catch (SQLException ex) {
            Logger.getLogger(PhuKienQService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }

    @Override
    public void add(QuanLyPhuKienQ sp) {
        try {
             PKRepos.add(new PhuKienQ(sp.getId(), sp.getMa(), sp.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
          
        }
    }

    @Override
    public void sua(QuanLyPhuKienQ sp) {
        try {
            PKRepos.sua(new PhuKienQ(sp.getId(), sp.getMa(), sp.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
         
        }
    }

    @Override
    public void xoa(String ma) {
        try {
             PKRepos.xoa(ma);
        } catch (Exception e) {
            System.out.println("xoa loi"+e.getMessage());
            
        }
    }
    
}
