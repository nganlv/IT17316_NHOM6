/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBContext;
import ViewModels.KhachHang;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Acer
 */
public class KhachHangRepo {

    public ArrayList<KhachHang> getAll() throws Exception {
        ArrayList<KhachHang> Kh = new ArrayList();
        Connection con = DBContext.getConnection();
        String sql = "SELECT Ma, HoTen, GioiTinh, NgaySinh, Sdt, DiaChi, Email, NgayTao, NgayHetHan, Diem FROM KhachHang";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Kh.add(new KhachHang(
                    rs.getString("Ma"),
                    rs.getString("Hoten"),
                    rs.getString("GioiTinh"),
                    rs.getString("Sdt"),
                    rs.getString("DiaChi"),
                    rs.getString("Email"),
                    rs.getString("Diem"),
                    rs.getDate("NgaySinh"),
                    rs.getDate("NgayTao"),
                    rs.getDate("NgayHetHan")
            ));
        }

        return Kh;
    }

    public Integer insert(KhachHang kh) throws Exception {
        String sql = " INSERT INTO KhachHang"
                + "         (Ma, HoTen, GioiTinh, Sdt, DiaChi, Email, Diem, NgaySinh, NgayTao, NgayHetHan)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getHoTen());
            ps.setString(3, kh.getGioiTinh());
            ps.setString(4, kh.getSdt());
            ps.setString(5, kh.getDiaChi());
            ps.setString(6, kh.getEmail());
            ps.setString(7, kh.getDiem());
            ps.setDate(8, (Date) kh.getNgaysinh());
            ps.setDate(9, (Date) kh.getNgayTao());
            ps.setDate(10, (Date) kh.getNgayHetHan());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Integer deleteK(String maKH) {
        String sql = "DELETE FROM KhachHang where Ma = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maKH);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;

    }

}
