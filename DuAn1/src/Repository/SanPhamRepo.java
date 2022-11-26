/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.SanPham;
import Repository.Interface.ISanPhamRepo;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class SanPhamRepo implements ISanPhamRepo {

    @Override
    public List<SanPham> getAllSp() {
        try {
            List<SanPham> listSp = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select * from SanPham";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setId(rs.getString("Id"));
                sp.setMa(rs.getString("Ma"));
                sp.setTen(rs.getString("Ten"));
                listSp.add(sp);
            }
            rs.close();
            ps.close();
            conn.close();
            return listSp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addSp(SanPham sp) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into SanPham values(newid(),?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMa());
            ps.setString(2, sp.getTen());
            int add = ps.executeUpdate();
            ps.close();
            conn.close();
            return add;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateSp(SanPham sp) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update SanPham set Ten=? where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(2, sp.getMa());
            ps.setString(1, sp.getTen());
            int update = ps.executeUpdate();
            ps.close();
            conn.close();
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer deleteSp(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from SanPham where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            int delete = ps.executeUpdate();
            ps.close();
            conn.close();
            return delete;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
