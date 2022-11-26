/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import DomainModels.PhuKien;
import Repository.Interface.IPhuKienRepo;
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
public class PhuKienRepo implements IPhuKienRepo{
   @Override
    public List<PhuKien> getAllPk() {
        try {
            List<PhuKien> listPk = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select * from PhuKien";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhuKien pk = new PhuKien();
                pk.setId(rs.getString("Id"));
                pk.setMa(rs.getString("Ma"));
                pk.setTen(rs.getString("Ten"));
                listPk.add(pk);
            }
            rs.close();
            ps.close();
            conn.close();
            return listPk;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addPk(PhuKien pk) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into PhuKien values(newid(),?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pk.getMa());
            ps.setString(2, pk.getTen());
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
    public Integer updatePk(PhuKien pk) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update PhuKien set Ten=? where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(2, pk.getMa());
            ps.setString(1, pk.getTen());
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
    public Integer deletePk(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from PhuKien where Ma=?";
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
