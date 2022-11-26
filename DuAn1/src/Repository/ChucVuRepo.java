/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChucVu;
import Repository.Interface.IChucVuRepo;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class ChucVuRepo implements IChucVuRepo{
  
 @Override
    public List<ChucVu> getAllTh() {
        try {
            List<ChucVu> listTh = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select * from ChucVu";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChucVu th = new ChucVu();
                th.setId(rs.getString("Id"));
                th.setMa(rs.getString("Ma"));
                th.setTen(rs.getString("Ten"));
                listTh.add(th);
            }
            rs.close();
            ps.close();
            conn.close();
            return listTh;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addTh(ChucVu th) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into ChucVu values(newid(),?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, th.getMa());
            ps.setString(2, th.getTen());
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
    public Integer updateTh(ChucVu th) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update ChucVu set Ten=? where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(2, th.getMa());
            ps.setString(1, th.getTen());
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
    public Integer deleteTh(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from ChucVu where Ma=?";
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
