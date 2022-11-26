/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Repository.Interface.IChiTietSanPhamRepo;
import DomainModels.ChiTietSanPham;
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
public class ChiTietSanPhamRepo implements IChiTietSanPhamRepo {

    @Override
    public List<ChiTietSanPham> getAllCtsp() {
        try {
            List<ChiTietSanPham> listCtsp = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select SanPham.Ma, SanPham.Ten, ThuongHieu.Ten as ThuongHieu, XuatXu.Ten as XuatXu, "
                    + " GioiTinh, KieuMay, TheLoai.Ten as TheLoai, PhuKien.Ten as PhuKien, TinhNang.Ten as TinhNang, "
                    + " HinhDangMatSo, ChatLieuMatKinh, ChatLieuDay.Ten as ChatLieuDay, MauMatSo.Ten as MauMatSo, "
                    + " MauVo.Ten as MauVo, KichThuoc,FORMAT(DonGia, 'c', 'vi-VN') as DonGia, NamBH, SoLuongTon, TinhTrang from ChiTietSP\n"
                    + " join SanPham on ChiTietSP.IdSp=SanPham.Id\n"
                    + " join ThuongHieu on ChiTietSP.IdThuongHieu=ThuongHieu.Id\n"
                    + " join XuatXu on ChiTietSP.IdXuatxu=XuatXu.Id\n"
                    + " join TheLoai on ChiTietSP.IdTheLoai=TheLoai.Id\n"
                    + " join ChatLieuDay on ChiTietSP.IdChatLieuDay=ChatLieuDay.Id\n"
                    + " join MauMatSo on ChiTietSP.IdMauMatSo=MauMatSo.Id\n"
                    + " join MauVo on ChiTietSP.IdMauVo=MauVo.Id\n"
                    + " join PhuKien on ChiTietSP.IdPhuKien=PhuKien.Id\n"
                    + " join TinhNang on ChiTietSP.IdTinhNang=TinhNang.Id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham();
                ctsp.setMa(rs.getString("Ma"));
                ctsp.setTen(rs.getString("Ten"));
                ctsp.setThuongHieu(rs.getString("ThuongHieu"));
                ctsp.setXuatXu(rs.getString("XuatXu"));
                ctsp.setTheLoai(rs.getString("TheLoai"));
                ctsp.setChatLieuDay(rs.getString("ChatLieuDay"));
                ctsp.setChatLieuMat(rs.getString("ChatLieuMatKinh"));
                ctsp.setMauMat(rs.getString("MauMatSo"));
                ctsp.setMauVo(rs.getString("MauVo"));
                ctsp.setGioiTinh(rs.getString("GioiTinh"));
                ctsp.setPhuKien(rs.getString("PhuKien"));
                ctsp.setTinhNang(rs.getString("TinhNang"));
                ctsp.setNamBh(rs.getInt("NamBH"));
                ctsp.setDonGia(rs.getString("DonGia"));
                ctsp.setHinhDangMat(rs.getString("HinhDangMatSo"));
                ctsp.setSoLuong(rs.getInt("SoLuongTon"));
                ctsp.setKieuMay(rs.getString("KieuMay"));
                ctsp.setTinhTrang(rs.getInt("TinhTrang"));
                ctsp.setKichThuoc(rs.getString("KichThuoc"));
                listCtsp.add(ctsp);
            }
            rs.close();
            ps.close();
            conn.close();
            return listCtsp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ChiTietSanPham> timSp(String ma) {
        try {
            List<ChiTietSanPham> listCtsp = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select SanPham.Ma, SanPham.Ten, ThuongHieu.Ten as ThuongHieu, XuatXu.Ten as XuatXu, "
                    + " GioiTinh, KieuMay, TheLoai.Ten as TheLoai, PhuKien.Ten as PhuKien, TinhNang.Ten as TinhNang, "
                    + " HinhDangMatSo, ChatLieuMatKinh, ChatLieuDay.Ten as ChatLieuDay, MauMatSo.Ten as MauMatSo, "
                    + " MauVo.Ten as MauVo, KichThuoc,FORMAT(DonGia, 'c', 'vi-VN') as DonGia, NamBH, SoLuongTon, TinhTrang from ChiTietSP\n"
                    + " join SanPham on ChiTietSP.IdSp=SanPham.Id\n"
                    + " join ThuongHieu on ChiTietSP.IdThuongHieu=ThuongHieu.Id\n"
                    + " join XuatXu on ChiTietSP.IdXuatxu=XuatXu.Id\n"
                    + " join TheLoai on ChiTietSP.IdTheLoai=TheLoai.Id\n"
                    + " join ChatLieuDay on ChiTietSP.IdChatLieuDay=ChatLieuDay.Id\n"
                    + " join MauMatSo on ChiTietSP.IdMauMatSo=MauMatSo.Id\n"
                    + " join MauVo on ChiTietSP.IdMauVo=MauVo.Id\n"
                    + " join PhuKien on ChiTietSP.IdPhuKien=PhuKien.Id\n"
                    + " join TinhNang on ChiTietSP.IdTinhNang=TinhNang.Id"
                    + " where SanPham.Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham();
                ctsp.setMa(rs.getString("Ma"));
                ctsp.setTen(rs.getString("Ten"));
                ctsp.setThuongHieu(rs.getString("ThuongHieu"));
                ctsp.setXuatXu(rs.getString("XuatXu"));
                ctsp.setTheLoai(rs.getString("TheLoai"));
                ctsp.setChatLieuDay(rs.getString("ChatLieuDay"));
                ctsp.setChatLieuMat(rs.getString("ChatLieuMatKinh"));
                ctsp.setMauMat(rs.getString("MauMatSo"));
                ctsp.setMauVo(rs.getString("MauVo"));
                ctsp.setGioiTinh(rs.getString("GioiTinh"));
                ctsp.setPhuKien(rs.getString("PhuKien"));
                ctsp.setTinhNang(rs.getString("TinhNang"));
                ctsp.setNamBh(rs.getInt("NamBH"));
                ctsp.setDonGia(rs.getString("DonGia"));
                ctsp.setHinhDangMat(rs.getString("HinhDangMatSo"));
                ctsp.setSoLuong(rs.getInt("SoLuongTon"));
                ctsp.setKieuMay(rs.getString("KieuMay"));
                ctsp.setTinhTrang(rs.getInt("TinhTrang"));
                ctsp.setKichThuoc(rs.getString("KichThuoc"));
                listCtsp.add(ctsp);
            }
            rs.close();
            ps.close();
            conn.close();
            return listCtsp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ChiTietSanPham> locSpTheoTH(String th) {
        try {
            List<ChiTietSanPham> listCtsp = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select SanPham.Ma, SanPham.Ten, ThuongHieu.Ten as ThuongHieu, XuatXu.Ten as XuatXu, "
                    + " GioiTinh, KieuMay, TheLoai.Ten as TheLoai, PhuKien.Ten as PhuKien, TinhNang.Ten as TinhNang, "
                    + " HinhDangMatSo, ChatLieuMatKinh, ChatLieuDay.Ten as ChatLieuDay, MauMatSo.Ten as MauMatSo, "
                    + " MauVo.Ten as MauVo, KichThuoc,FORMAT(DonGia, 'c', 'vi-VN') as DonGia, NamBH, SoLuongTon, TinhTrang from ChiTietSP\n"
                    + " join SanPham on ChiTietSP.IdSp=SanPham.Id\n"
                    + " join ThuongHieu on ChiTietSP.IdThuongHieu=ThuongHieu.Id\n"
                    + " join XuatXu on ChiTietSP.IdXuatxu=XuatXu.Id\n"
                    + " join TheLoai on ChiTietSP.IdTheLoai=TheLoai.Id\n"
                    + " join ChatLieuDay on ChiTietSP.IdChatLieuDay=ChatLieuDay.Id\n"
                    + " join MauMatSo on ChiTietSP.IdMauMatSo=MauMatSo.Id\n"
                    + " join MauVo on ChiTietSP.IdMauVo=MauVo.Id\n"
                    + " join PhuKien on ChiTietSP.IdPhuKien=PhuKien.Id\n"
                    + " join TinhNang on ChiTietSP.IdTinhNang=TinhNang.Id"
                    + " where ThuongHieu.Ten=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, th);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham();
                ctsp.setMa(rs.getString("Ma"));
                ctsp.setTen(rs.getString("Ten"));
                ctsp.setThuongHieu(rs.getString("ThuongHieu"));
                ctsp.setXuatXu(rs.getString("XuatXu"));
                ctsp.setTheLoai(rs.getString("TheLoai"));
                ctsp.setChatLieuDay(rs.getString("ChatLieuDay"));
                ctsp.setChatLieuMat(rs.getString("ChatLieuMatKinh"));
                ctsp.setMauMat(rs.getString("MauMatSo"));
                ctsp.setMauVo(rs.getString("MauVo"));
                ctsp.setGioiTinh(rs.getString("GioiTinh"));
                ctsp.setPhuKien(rs.getString("PhuKien"));
                ctsp.setTinhNang(rs.getString("TinhNang"));
                ctsp.setNamBh(rs.getInt("NamBH"));
                ctsp.setDonGia(rs.getString("DonGia"));
                ctsp.setHinhDangMat(rs.getString("HinhDangMatSo"));
                ctsp.setSoLuong(rs.getInt("SoLuongTon"));
                ctsp.setKieuMay(rs.getString("KieuMay"));
                ctsp.setTinhTrang(rs.getInt("TinhTrang"));
                ctsp.setKichThuoc(rs.getString("KichThuoc"));
                listCtsp.add(ctsp);
            }
            rs.close();
            ps.close();
            conn.close();
            return listCtsp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ChiTietSanPham> locSpTheoGT(String gt) {
        try {
            List<ChiTietSanPham> listCtsp = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select SanPham.Ma, SanPham.Ten, ThuongHieu.Ten as ThuongHieu, XuatXu.Ten as XuatXu, "
                    + " GioiTinh, KieuMay, TheLoai.Ten as TheLoai, PhuKien.Ten as PhuKien, TinhNang.Ten as TinhNang, "
                    + " HinhDangMatSo, ChatLieuMatKinh, ChatLieuDay.Ten as ChatLieuDay, MauMatSo.Ten as MauMatSo, "
                    + " MauVo.Ten as MauVo, KichThuoc,FORMAT(DonGia, 'c', 'vi-VN') as DonGia, NamBH, SoLuongTon, TinhTrang from ChiTietSP\n"
                    + " join SanPham on ChiTietSP.IdSp=SanPham.Id\n"
                    + " join ThuongHieu on ChiTietSP.IdThuongHieu=ThuongHieu.Id\n"
                    + " join XuatXu on ChiTietSP.IdXuatxu=XuatXu.Id\n"
                    + " join TheLoai on ChiTietSP.IdTheLoai=TheLoai.Id\n"
                    + " join ChatLieuDay on ChiTietSP.IdChatLieuDay=ChatLieuDay.Id\n"
                    + " join MauMatSo on ChiTietSP.IdMauMatSo=MauMatSo.Id\n"
                    + " join MauVo on ChiTietSP.IdMauVo=MauVo.Id\n"
                    + " join PhuKien on ChiTietSP.IdPhuKien=PhuKien.Id\n"
                    + " join TinhNang on ChiTietSP.IdTinhNang=TinhNang.Id"
                    + " where GioiTinh=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, gt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham();
                ctsp.setMa(rs.getString("Ma"));
                ctsp.setTen(rs.getString("Ten"));
                ctsp.setThuongHieu(rs.getString("ThuongHieu"));
                ctsp.setXuatXu(rs.getString("XuatXu"));
                ctsp.setTheLoai(rs.getString("TheLoai"));
                ctsp.setChatLieuDay(rs.getString("ChatLieuDay"));
                ctsp.setChatLieuMat(rs.getString("ChatLieuMatKinh"));
                ctsp.setMauMat(rs.getString("MauMatSo"));
                ctsp.setMauVo(rs.getString("MauVo"));
                ctsp.setGioiTinh(rs.getString("GioiTinh"));
                ctsp.setPhuKien(rs.getString("PhuKien"));
                ctsp.setTinhNang(rs.getString("TinhNang"));
                ctsp.setNamBh(rs.getInt("NamBH"));
                ctsp.setDonGia(rs.getString("DonGia"));
                ctsp.setHinhDangMat(rs.getString("HinhDangMatSo"));
                ctsp.setSoLuong(rs.getInt("SoLuongTon"));
                ctsp.setKieuMay(rs.getString("KieuMay"));
                ctsp.setTinhTrang(rs.getInt("TinhTrang"));
                ctsp.setKichThuoc(rs.getString("KichThuoc"));
                listCtsp.add(ctsp);
            }
            rs.close();
            ps.close();
            conn.close();
            return listCtsp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ChiTietSanPham> locSpTheoTT(Integer tt) {
        try {
            List<ChiTietSanPham> listCtsp = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select SanPham.Ma, SanPham.Ten, ThuongHieu.Ten as ThuongHieu, XuatXu.Ten as XuatXu, "
                    + " GioiTinh, KieuMay, TheLoai.Ten as TheLoai, PhuKien.Ten as PhuKien, TinhNang.Ten as TinhNang, "
                    + " HinhDangMatSo, ChatLieuMatKinh, ChatLieuDay.Ten as ChatLieuDay, MauMatSo.Ten as MauMatSo, "
                    + " MauVo.Ten as MauVo, KichThuoc,FORMAT(DonGia, 'c', 'vi-VN') as DonGia, NamBH, SoLuongTon, TinhTrang from ChiTietSP\n"
                    + " join SanPham on ChiTietSP.IdSp=SanPham.Id\n"
                    + " join ThuongHieu on ChiTietSP.IdThuongHieu=ThuongHieu.Id\n"
                    + " join XuatXu on ChiTietSP.IdXuatxu=XuatXu.Id\n"
                    + " join TheLoai on ChiTietSP.IdTheLoai=TheLoai.Id\n"
                    + " join ChatLieuDay on ChiTietSP.IdChatLieuDay=ChatLieuDay.Id\n"
                    + " join MauMatSo on ChiTietSP.IdMauMatSo=MauMatSo.Id\n"
                    + " join MauVo on ChiTietSP.IdMauVo=MauVo.Id\n"
                    + " join PhuKien on ChiTietSP.IdPhuKien=PhuKien.Id\n"
                    + " join TinhNang on ChiTietSP.IdTinhNang=TinhNang.Id"
                    + " where TinhTrang=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham();
                ctsp.setMa(rs.getString("Ma"));
                ctsp.setTen(rs.getString("Ten"));
                ctsp.setThuongHieu(rs.getString("ThuongHieu"));
                ctsp.setXuatXu(rs.getString("XuatXu"));
                ctsp.setTheLoai(rs.getString("TheLoai"));
                ctsp.setChatLieuDay(rs.getString("ChatLieuDay"));
                ctsp.setChatLieuMat(rs.getString("ChatLieuMatKinh"));
                ctsp.setMauMat(rs.getString("MauMatSo"));
                ctsp.setMauVo(rs.getString("MauVo"));
                ctsp.setGioiTinh(rs.getString("GioiTinh"));
                ctsp.setPhuKien(rs.getString("PhuKien"));
                ctsp.setTinhNang(rs.getString("TinhNang"));
                ctsp.setNamBh(rs.getInt("NamBH"));
                ctsp.setDonGia(rs.getString("DonGia"));
                ctsp.setHinhDangMat(rs.getString("HinhDangMatSo"));
                ctsp.setSoLuong(rs.getInt("SoLuongTon"));
                ctsp.setKieuMay(rs.getString("KieuMay"));
                ctsp.setTinhTrang(rs.getInt("TinhTrang"));
                ctsp.setKichThuoc(rs.getString("KichThuoc"));
                listCtsp.add(ctsp);
            }
            rs.close();
            ps.close();
            conn.close();
            return listCtsp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
