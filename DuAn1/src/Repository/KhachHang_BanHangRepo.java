/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Repository.Interface.IKhachHang_BanHangRepo;
import DomainModels.KhachHang_BanHang;
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
public class KhachHang_BanHangRepo implements IKhachHang_BanHangRepo{
    @Override
    public List<KhachHang_BanHang> getAllKh(){
        try {
            List<KhachHang_BanHang> listKh=new ArrayList<>();
            Connection conn=DBContext.getConnection();
            String sql="select * from KhachHang";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                KhachHang_BanHang kh=new KhachHang_BanHang();
                kh.setMa(rs.getString("Ma"));
                kh.setHoTen(rs.getString("HoTen"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setNgaySinh(rs.getString("NgaySinh"));
                kh.setSdt(rs.getString("Sdt"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setEmail(rs.getString("Email"));
                kh.setNgayTao(rs.getString("NgayTao"));
                kh.setNgayHh(rs.getString("NgayHetHan"));
                kh.setDiem(rs.getString("Diem"));
                listKh.add(kh);
            }
            rs.close();
            ps.close();
            conn.close();
            return listKh;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override 
    public Integer addKh(KhachHang_BanHang kh){
        try {
            Connection conn=DBContext.getConnection();
            String sql="insert into KhachHang values(newid(),?,?,?,?,?,?,?,getdate(),?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getHoTen());
            ps.setString(3, kh.getGioiTinh());
            ps.setString(4, kh.getNgaySinh());
            ps.setString(5, kh.getSdt());
            ps.setString(6, kh.getDiaChi());
            ps.setString(7, kh.getEmail());
            ps.setString(8, kh.getNgayHh());
            ps.setString(9, kh.getDiem());
            int addRow=ps.executeUpdate();
            ps.close();
            conn.close();
            return addRow;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override 
    public Integer updateKh(KhachHang_BanHang kh){
        try {
            Connection conn=DBContext.getConnection();
            String sql="update KhachHang set HoTen=?, GioiTinh=?, NgaySinh=?, Sdt=?, DiaChi=?, Email=?, NgayHetHan=?, Diem=?"
                    + " where Ma=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(9, kh.getMa());
            ps.setString(1, kh.getHoTen());
            ps.setString(2, kh.getGioiTinh());
            ps.setString(3, kh.getNgaySinh());
            ps.setString(4, kh.getSdt());
            ps.setString(5, kh.getDiaChi());
            ps.setString(6, kh.getEmail());
            ps.setString(7, kh.getNgayHh());
            ps.setString(8, kh.getDiem());
            int updateRow=ps.executeUpdate();
            ps.close();
            conn.close();
            return updateRow;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<KhachHang_BanHang> timKh(String ten){
        try {
            List<KhachHang_BanHang> listKh=new ArrayList<>();
            Connection conn=DBContext.getConnection();
            String sql="select * from KhachHang where HoTen=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, ten);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                KhachHang_BanHang kh=new KhachHang_BanHang();
                kh.setMa(rs.getString("Ma"));
                kh.setHoTen(rs.getString("HoTen"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setNgaySinh(rs.getString("NgaySinh"));
                kh.setSdt(rs.getString("Sdt"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setEmail(rs.getString("Email"));
                kh.setNgayTao(rs.getString("NgayTao"));
                kh.setNgayHh(rs.getString("NgayHetHan"));
                kh.setDiem(rs.getString("Diem"));
                listKh.add(kh);
            }
            rs.close();
            ps.close();
            conn.close();
            return listKh;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
