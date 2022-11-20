/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.SanPham;
import Utilities.DBContext;
import ViewModels.QuanLySanPham;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author nguyenhongphong
 */
public class SanPhamRepository {

    private DBContext dBcontext;

    public ArrayList<QuanLySanPham> getAll() throws SQLException {
        ArrayList<QuanLySanPham> list = new ArrayList<>();
        String sql = "SELECT Ma, Ten  from SanPham";
        Connection connection = dBcontext.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            QuanLySanPham sp = new QuanLySanPham();
            sp.setMaSP(rs.getString(1));
            sp.setTenSP(rs.getString(2));

            list.add(sp);
        }
        return list;
    }

    public boolean addSP(QuanLySanPham sp) throws SQLException {
        String sql = "insert into SanPham(Ma, Ten) VALUES(?, ?)";
        Connection connection = dBcontext.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, sp.getMaSP());
        ps.setString(2, sp.getTenSP());
        
        return ps.executeUpdate()>0;
    }
    
    public boolean suaSP(QuanLySanPham sp) throws SQLException {
        String sql = "UPDATE SanPham SET Ten = ? where Ma = ?";
        Connection connection = dBcontext.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, sp.getTenSP());
        ps.setString(2, sp.getMaSP());
        
        return ps.executeUpdate()>0;
    }
    public boolean xoaSP(String ma) throws SQLException {
        String sql= "DELETE FROM SanPham WHERE Ma = ?";
        Connection connection = dBcontext.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, ma);
        
        return ps.executeUpdate()>0;
    }
}
