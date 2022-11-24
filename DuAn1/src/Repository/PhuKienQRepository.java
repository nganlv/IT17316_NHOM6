/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.SanPham;
import Utilities.DBContext;
import DomainModels.PhuKienQ;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author nguyenhongphong
 */
public class PhuKienQRepository {

    private DBContext dBcontext;

    public ArrayList<PhuKienQ> getAll() throws SQLException {
        ArrayList<PhuKienQ> list = new ArrayList<>();
        String sql = "SELECT *  from PhuKien";
        Connection connection = dBcontext.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PhuKienQ sp = new PhuKienQ();
            sp.setId(rs.getString(1));
            sp.setMa(rs.getString(2));
            sp.setTen(rs.getString(3));

            list.add(sp);
        }
        return list;
    }

    public boolean add(PhuKienQ sp) throws SQLException {
        String sql = "insert into PhuKien(Id,Ma, Ten) VALUES(newid(),?, ?)";
        Connection connection = dBcontext.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, sp.getMa());
        ps.setString(2, sp.getTen());

        return ps.executeUpdate() > 0;
    }

    public boolean sua(PhuKienQ sp) throws SQLException {
        String sql = " UPDATE PhuKien SET Ten = ? where Ma = ? ";
        Connection connection = dBcontext.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(2, sp.getMa());
        ps.setString(1, sp.getTen());

        return ps.executeUpdate() > 0;
    }

    public boolean xoa(String ma) throws SQLException {
        String sql = " DELETE FROM [dbo].[PhuKien]\n"
                + "      WHERE Ma = ? ";
        Connection connection = dBcontext.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, ma);
        boolean kq = ps.executeUpdate() > 0;
        ps.close();
        connection.close();
        return kq;

    }
}
