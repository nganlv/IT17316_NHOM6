/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBContext;
import ViewModels.QuanLyNhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class NhanVienRepo {
     public List<QuanLyNhanVien> getAllNV() {
        List<QuanLyNhanVien> listNV = new ArrayList<>();
        String sql = """
                     select NhanVien.Ma, NhanVien.HoTen, GioiTinh, NgaySinh, Sdt, NhanVien.DiaChi,Email, ChucVu.Ten as 'ChucVu', TaiKhoan.Ten as 'TaiKhoan', TrangThai 
                       from NhanVien join ChucVu on NhanVien.IdCV = ChucVu.Id
                       				join TaiKhoan on NhanVien.IdTK = TaiKhoan.Id""";

        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listNV.add(new QuanLyNhanVien(rs.getString("Ma"), rs.getString("HoTen"),
                       rs.getString("GioiTinh"), rs.getDate("NgaySinh"), rs.getString("Sdt"), rs.getString("DiaChi"),
                        rs.getString("Email"), rs.getString("ChucVu"), rs.getString("TaiKhoan"), rs.getInt("TrangThai")));
            }

            return listNV;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
