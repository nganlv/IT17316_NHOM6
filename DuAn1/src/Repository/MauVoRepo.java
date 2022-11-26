/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import DomainModels.MauVo;
import Repository.Interface.IMauVoRepo;
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
public class MauVoRepo implements IMauVoRepo{
    @Override
    public List<MauVo> getAllMv() {
        try {
            List<MauVo> listMv = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select * from MauVo";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauVo mv = new MauVo();
                mv.setId(rs.getString("Id"));
                mv.setMa(rs.getString("Ma"));
                mv.setTen(rs.getString("Ten"));
                listMv.add(mv);
            }
            rs.close();
            ps.close();
            conn.close();
            return listMv;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addMv(MauVo mv) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into MauVo values(newid(),?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mv.getMa());
            ps.setString(2, mv.getTen());
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
    public Integer updateMv(MauVo mv) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update MauVo set Ten=? where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(2, mv.getMa());
            ps.setString(1, mv.getTen());
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
    public Integer deleteMv(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from MauVo where Ma=?";
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
