/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import DomainModels.MauMatSo;
import Repository.Interface.IMauMatSoRepo;
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
public class MauMatSoRepo implements IMauMatSoRepo{
    @Override
    public List<MauMatSo> getAllMms() {
        try {
            List<MauMatSo> listMms = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select * from MauMatSo";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauMatSo mms = new MauMatSo();
                mms.setId(rs.getString("Id"));
                mms.setMa(rs.getString("Ma"));
                mms.setTen(rs.getString("Ten"));
                listMms.add(mms);
            }
            rs.close();
            ps.close();
            conn.close();
            return listMms;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addMms(MauMatSo mms) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into MauMatSo values(newid(),?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mms.getMa());
            ps.setString(2, mms.getTen());
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
    public Integer updateMms(MauMatSo mms) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update MauMatSo set Ten=? where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(2, mms.getMa());
            ps.setString(1, mms.getTen());
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
    public Integer deleteMms(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from MauMatSo where Ma=?";
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
