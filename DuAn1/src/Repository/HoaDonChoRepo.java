/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Repository.Interface.IHoaDonChoRepo;
import DomainModels.HoaDonCho;
import Utilities.DBContext;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author levan
 */
public class HoaDonChoRepo implements IHoaDonChoRepo {

    @Override
    public List<HoaDonCho> getHd() {
        try {
            List<HoaDonCho> listHd = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select HoaDon.Ma as MaHD, HoaDon.NgayTao, NhanVien.Ma as MaNV, KhachHang.Ma as MaKH, KhachHang.HoTen from HoaDon \n"
                    + " join NhanVien on HoaDon.IdNV=NhanVien.Id\n"
                    + " join KhachHang on KhachHang.Id=HoaDon.IdKH\n"
                    + " where HoaDon.Ma='hd000'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCho hdc = new HoaDonCho();
                hdc.setMaHd(rs.getString("MaHD"));
                hdc.setNgayTao(rs.getString("NgayTao"));
                hdc.setMaNv(rs.getString("MaNV"));
                hdc.setMaKh(rs.getString("MaKH"));
                hdc.setTenKh(rs.getString("HoTen"));
                listHd.add(hdc);
            }
            rs.close();
            ps.close();
            conn.close();
            return listHd;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HoaDonCho> getHd2(String ma) {
        try {
            List<HoaDonCho> listHd = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select top(1) HoaDon.Ma as MaHD, GETDATE() as NgayTao, NhanVien.Ma as MaNV, KhachHang.Ma as MaKH, KhachHang.HoTen from HoaDon \n"
                    + " join NhanVien on HoaDon.IdNV=NhanVien.Id\n"
                    + " join KhachHang on KhachHang.Id=HoaDon.IdKH\n"
                    + " where KhachHang.Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCho hdc = new HoaDonCho();
                hdc.setMaHd(rs.getString("MaHD"));
                hdc.setNgayTao(rs.getString("NgayTao"));
                hdc.setMaNv(rs.getString("MaNV"));
                hdc.setMaKh(rs.getString("MaKH"));
                hdc.setTenKh(rs.getString("HoTen"));
                listHd.add(hdc);
            }
            rs.close();
            ps.close();
            conn.close();
            return listHd;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
