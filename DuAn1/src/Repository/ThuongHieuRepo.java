/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ThuongHieu;
import Repository.Interface.IThuongHieuRepo;
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
public class ThuongHieuRepo implements IThuongHieuRepo {

    @Override
    public List<ThuongHieu> getAllTh() {
        try {
            List<ThuongHieu> listTh = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select * from ThuongHieu";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuongHieu th = new ThuongHieu();
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
    public Integer addTh(ThuongHieu th) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into ThuongHieu values(newid(),?,?)";
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
    public Integer updateTh(ThuongHieu th) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update ThuongHieu set Ten=? where Ma=?";
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
            String sql = "delete from ThuongHieu where Ma=?";
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
