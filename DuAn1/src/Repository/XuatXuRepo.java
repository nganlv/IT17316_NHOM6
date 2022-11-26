/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.XuatXu;
import Repository.Interface.IXuatXuRepo;
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
public class XuatXuRepo implements IXuatXuRepo {

    @Override
    public List<XuatXu> getAllXx() {
        try {
            List<XuatXu> listXx = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select * from XuatXu";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                XuatXu xx = new XuatXu();
                xx.setId(rs.getString("Id"));
                xx.setMa(rs.getString("Ma"));
                xx.setTen(rs.getString("Ten"));
                listXx.add(xx);
            }
            rs.close();
            ps.close();
            conn.close();
            return listXx;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addXx(XuatXu xx) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into XuatXu values(newid(),?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, xx.getMa());
            ps.setString(2, xx.getTen());
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
    public Integer updateXx(XuatXu xx) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update XuatXu set Ten=? where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(2, xx.getMa());
            ps.setString(1, xx.getTen());
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
    public Integer deleteXx(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from XuatXu where Ma=?";
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
