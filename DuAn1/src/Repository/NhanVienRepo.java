/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.NhanVien;
import Utilities.DBContext;
import ViewModels.QuanLyNhanVien;
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
public class NhanVienRepo {

    public List<QuanLyNhanVien> getAllNV() {
        List<QuanLyNhanVien> listNV = new ArrayList<>();
        String sql = """
                     select NhanVien.Ma, NhanVien.HoTen, GioiTinh, NgaySinh, Sdt, NhanVien.DiaChi,Email, TaiKhoan.Ten as 'TaiKhoan', ChucVu.Ten as 'ChucVu', TrangThai 
                       from NhanVien join TaiKhoan on NhanVien.IdTK = TaiKhoan.Id
                       				join ChucVu on NhanVien.IdCV = ChucVu.Id""";

        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listNV.add(new QuanLyNhanVien(rs.getString("Ma"), rs.getString("HoTen"),
                        rs.getString("GioiTinh"), rs.getDate("NgaySinh"), rs.getString("Sdt"), rs.getString("DiaChi"),
                        rs.getString("Email"), rs.getString("TaiKhoan"), rs.getString("ChucVu"), rs.getInt("TrangThai")));
            }

            return listNV;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Integer addNV(NhanVien nv) throws SQLException {
        String sql = """
                    insert into NhanVien
                    (Ma
                    ,HoTen
                    ,GioiTinh
                    ,NgaySinh
                    ,Sdt
                    ,DiaChi
                    ,Email
                    ,IdTK
                    ,idCV
                    ,TrangThai)
                    values(?,?,?,?,?,?,?,?,?,?) """;

        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getTen());
            ps.setString(3, nv.getGioitinh());
            ps.setDate(4, new java.sql.Date(nv.getNgaysinh().getTime()));
            ps.setString(5, nv.getSdt());
            ps.setString(6, nv.getDiachi());
            ps.setString(7, nv.getEmail());
            ps.setString(8, nv.getIdtk());
            ps.setString(9, nv.getIdcv());
            ps.setInt(10, nv.getTrangthai());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;

    }

    public Integer updates(NhanVien nv) {
        String sql = """
                     UPDATE [dbo].[NhanVien]
                             SET [HoTen] = ?
                                ,[GioiTinh] = ?
                                ,[NgaySinh] = ?
                                ,[Sdt] = ?
                                ,[DiaChi] = ?
                                ,[Email] = ?
                                ,[IdTK] = ?
                                ,[IdCV] = ?
                                ,[TrangThai] = ?
                           WHERE Ma = ?""";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(10, nv.getMa());
            ps.setObject(1, nv.getTen());

            ps.setObject(2, nv.getGioitinh());
            ps.setObject(3, nv.getNgaysinh());
            ps.setObject(4, nv.getSdt());
            ps.setObject(5, nv.getDiachi());
            ps.setObject(6, nv.getEmail());
            ps.setString(7, nv.getIdtk());
            ps.setString(8, nv.getIdcv());
            ps.setObject(9, nv.getTrangthai());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    public Integer deletes(String maNV) {
        String sql = """
                     DELETE FROM [dbo].[NhanVien]
                                 WHERE Ma = ? """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, maNV);

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    public List<NhanVien> getTim(String ma) {
        List<NhanVien> listTNV = new ArrayList<>();
        String sql = """
                     select NhanVien.Ma, NhanVien.HoTen, GioiTinh, NgaySinh, Sdt, NhanVien.DiaChi,Email, TaiKhoan.Ten as 'TaiKhoan', ChucVu.Ten as 'ChucVu', TrangThai 
                                            from NhanVien join TaiKhoan on NhanVien.IdTK = TaiKhoan.Id
                                            				join ChucVu on NhanVien.IdCV = ChucVu.Id 
                                          where NhanVien.Ma= ?  """;

        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, ma);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMa(rs.getString("Ma"));
                nv.setTen(rs.getString("HoTen"));
                nv.setGioitinh(rs.getString("GioiTinh"));
                nv.setNgaysinh(rs.getDate("NgaySinh"));
                nv.setSdt(rs.getString("Sdt"));
                nv.setDiachi(rs.getString("DiaChi"));
                nv.setEmail(rs.getString("Email"));
                nv.setIdtk(rs.getString("TaiKhoan"));
                nv.setIdcv(rs.getString("ChucVu"));
                nv.setTrangthai(rs.getInt("TrangThai"));
                listTNV.add(nv);

            }

            return listTNV;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<QuanLyNhanVien> getloc(String cv) {
        List<QuanLyNhanVien> listTNV = new ArrayList<>();
        String sql = """
                     
                     select NhanVien.Ma, NhanVien.HoTen, GioiTinh, NgaySinh, Sdt, NhanVien.DiaChi,Email, TaiKhoan.Ten as 'TaiKhoan', ChucVu.Ten as 'ChucVu', TrangThai 
                                            from NhanVien join TaiKhoan on NhanVien.IdTK = TaiKhoan.Id \n
                                            				join ChucVu on NhanVien.IdCV = ChucVu.Id \n
                                          where ChucVu.Ten=?  """;

        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, cv);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuanLyNhanVien nv = new QuanLyNhanVien();
                nv.setMa(rs.getString("Ma"));
                nv.setTen(rs.getString("HoTen"));
                nv.setGioitinh(rs.getString("GioiTinh"));
                nv.setNgaysinh(rs.getDate("NgaySinh"));
                nv.setSdt(rs.getString("Sdt"));
                nv.setDiachi(rs.getString("DiaChi"));
                nv.setEmail(rs.getString("Email"));
                nv.setTaikhoan(rs.getString("TaiKhoan"));
                nv.setChucvu(rs.getString("ChucVu"));
                nv.setTrangthai(rs.getInt("TrangThai"));
                listTNV.add(nv);

            }
            rs.close();
            ps.close();
            con.close();
            return listTNV;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<NhanVien> getTimTen(String ten) {
        List<NhanVien> listTNV = new ArrayList<>();
        String sql = "select *from NhanVien where NhanVien.HoTen like '%" + ten + "%'";

        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {

//           ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien tnv = new NhanVien();
                tnv.setMa(rs.getString("Ma"));
                tnv.setTen(rs.getString("HoTen"));
                tnv.setGioitinh(rs.getString("GioiTinh"));
                tnv.setNgaysinh(rs.getDate("NgaySinh"));
                tnv.setSdt(rs.getString("Sdt"));
                tnv.setDiachi(rs.getString("DiaChi"));
                tnv.setEmail(rs.getString("Email"));
                tnv.setIdtk(rs.getString("TaiKhoan"));
                tnv.setIdcv(rs.getString("ChucVu"));
                tnv.setTrangthai(rs.getInt("TrangThai"));
                listTNV.add(tnv);

            }

            return listTNV;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
