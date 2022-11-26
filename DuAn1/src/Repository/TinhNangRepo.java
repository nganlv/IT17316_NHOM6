/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.TinhNang;
import Repository.Interface.ITinhNangRepo;
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
public class TinhNangRepo implements ITinhNangRepo {

    @Override
    public List<TinhNang> getAllTn() {
        try {
            List<TinhNang> listTn = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select * from TinhNang";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TinhNang tn = new TinhNang();
                tn.setId(rs.getString("Id"));
                tn.setMa(rs.getString("Ma"));
                tn.setTen(rs.getString("Ten"));
                listTn.add(tn);
            }
            rs.close();
            ps.close();
            conn.close();
            return listTn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addTn(TinhNang tn) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into TinhNang values(newid(),?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tn.getMa());
            ps.setString(2, tn.getTen());
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
    public Integer updateTn(TinhNang tn) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update TinhNang set Ten=? where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(2, tn.getMa());
            ps.setString(1, tn.getTen());
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
    public Integer deleteTn(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from TinhNang where Ma=?";
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
