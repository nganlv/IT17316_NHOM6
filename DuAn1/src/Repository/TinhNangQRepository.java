/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;


import Utilities.DBContext;
import DomainModels.TinhNangQ;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author nguyenhongphong
 */
public class TinhNangQRepository {

    private DBContext dBcontext;

    public ArrayList<TinhNangQ> getAll() throws SQLException {
        ArrayList<TinhNangQ> list = new ArrayList<>();
        String sql = "SELECT *  from TinhNang";
        Connection connection = dBcontext.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            TinhNangQ sp = new TinhNangQ();
            sp.setId(rs.getString(1));
            sp.setMa(rs.getString(2));
            sp.setTen(rs.getString(3));

            list.add(sp);
        }
        return list;
    }

    public boolean add(TinhNangQ sp) throws SQLException {
        String sql = "insert into TinhNang(Id,Ma, Ten) VALUES(newid(),?, ?)";
        Connection connection = dBcontext.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, sp.getMa());
        ps.setString(2, sp.getTen());

        return ps.executeUpdate() > 0;
    }

    public boolean sua(TinhNangQ sp) throws SQLException {
        String sql = " UPDATE TinhNang SET Ten = ? where Ma = ? ";
        Connection connection = dBcontext.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(2, sp.getMa());
        ps.setString(1, sp.getTen());

        return ps.executeUpdate() > 0;
    }

    public boolean xoa(String ma) throws SQLException {
        String sql = " DELETE FROM [dbo].[TinhNang]\n"
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
