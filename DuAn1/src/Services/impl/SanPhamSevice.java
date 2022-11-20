/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.SanPham;
import Repository.SanPhamRepository;
import Services.IsanPham;
import ViewModels.QuanLySanPham;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author nguyenhongphong
 */
public class SanPhamSevice implements IsanPham {

    private SanPhamRepository sanPhamRepos = new SanPhamRepository();

    @Override
    public ArrayList<QuanLySanPham> getAll() {
        try {
            return sanPhamRepos.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean add(QuanLySanPham sp) {
        try {
            return sanPhamRepos.addSP(sp);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(QuanLySanPham sp) {
        try {
            return sanPhamRepos.suaSP(sp);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String ma) {
        try {
            return sanPhamRepos.xoaSP(ma);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
