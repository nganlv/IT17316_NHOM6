/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.TaiKhoan;
import Utilities.DBContext;
import ViewModels.QuanLyChucVu;
import ViewModels.QuanLyTaiKhoan;
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
public class TaiKhoanRepo {

    public List<QuanLyTaiKhoan> getAll() {
        List<QuanLyTaiKhoan> listCV = new ArrayList();
        String sql = "select Id,Ma,Ten,MatKhau from TaiKhoan";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listCV.add(new QuanLyTaiKhoan(rs.getString("Id"), rs.getString("Ma"), rs.getString("Ten"), rs.getString("MatKhau")));
            }
            return listCV;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Integer addTT(TaiKhoan tk) throws SQLException {
      String sql = """
                     INSERT INTO [dbo].[TaiKhoan]
                                ([Ma]
                                ,[Ten]
                                 ,[MatKhau])
                          VALUES (?,?,?)""";

        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tk.getMa());
            ps.setString(2, tk.getTen());
            ps.setString(3, tk.getMatkhau());
       
            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public Integer updateCV(TaiKhoan tk) {
        String sql = """
                     UPDATE [dbo].[TaiKhoan]
                             SET [Ten] = ?
                           WHERE Ma = ? """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(2, tk.getMa());
            ps.setObject(1, tk.getTen());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;

    }

    public Integer deleteCV(String maTk) {
        String sql = """
                     DELETE FROM [dbo].[TaiKhoan]
                                 WHERE Ma = ?""";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maTk);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}
