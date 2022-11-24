/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.TinhNangQ;
import Repository.TinhNangQRepository;
import Services.ITinhNangQ1;
import ViewModels.QuanLyTinhNangQ1;
import java.awt.List;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguyenhongphong
 */
public class TinhNangQService1 implements ITinhNangQ1 {

    private TinhNangQRepository PKRepos = new TinhNangQRepository();

    @Override
    public ArrayList<QuanLyTinhNangQ1>getAll(){
        try {
            ArrayList <QuanLyTinhNangQ1> listMs = new ArrayList<>();
            for (TinhNangQ ms : PKRepos.getAll()) {
                listMs.add(new QuanLyTinhNangQ1(ms.getId(), ms.getMa(), ms.getTen()));
            }
            return listMs;
        } catch (SQLException ex) {
            Logger.getLogger(TinhNangQService1.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }

    @Override
    public void add(QuanLyTinhNangQ1 sp) {
        try {
             PKRepos.add(new TinhNangQ(sp.getId(), sp.getMa(), sp.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
          
        }
    }

    @Override
    public void sua(QuanLyTinhNangQ1 sp) {
        try {
            PKRepos.sua(new TinhNangQ(sp.getId(), sp.getMa(), sp.getTen()));
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
