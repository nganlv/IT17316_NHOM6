/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.TaiKhoan;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author levan
 */
public class TaiKhoanRepo {

    public TaiKhoan getAllTk(String ten, String matKhau) throws SQLException {
        Connection conn = DBContext.getConnection();
        String sql = "select Ten, MatKhau from TaiKhoan where Ten=? and MatKhau=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, ten);
        ps.setString(2, matKhau);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            TaiKhoan tk = new TaiKhoan();
            tk.setTen(rs.getString("Ten"));
            tk.setMatKhau(rs.getString("MatKhau"));
            return tk;
        }
        rs.close();
        ps.close();
        conn.close();
        return null;
    }
}
