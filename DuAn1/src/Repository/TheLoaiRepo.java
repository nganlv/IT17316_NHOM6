/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import DomainModels.TheLoai;
import Repository.Interface.ITheLoaiRepo;
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
public class TheLoaiRepo implements ITheLoaiRepo{
    @Override
    public List<TheLoai> getAllTl() {
        try {
            List<TheLoai> listTl = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select * from TheLoai";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TheLoai tl=new TheLoai();
                tl.setId(rs.getString("Id"));
                tl.setMa(rs.getString("Ma"));
                tl.setTen(rs.getString("Ten"));
                listTl.add(tl);
            }
            rs.close();
            ps.close();
            conn.close();
            return listTl;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addTl(TheLoai tl) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into TheLoai values(newid(),?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tl.getMa());
            ps.setString(2, tl.getTen());
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
    public Integer updateTl(TheLoai tl) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update TheLoai set Ten=? where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(2, tl.getMa());
            ps.setString(1, tl.getTen());
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
    public Integer deleteTl(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from TheLoai where Ma=?";
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
