/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import java.sql.*;
import java.util.*;
import DomainModels.CTSP;
import DomainModels.PhuKienQ;
import DomainModels.TinhNangQ;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utilities.DBContext;

/**
 *
 * @author pc
 */
public class ChiTietSP {

    public ArrayList<CTSP> getAll() {
        try {
            ArrayList<CTSP> ds = new ArrayList<>();

            String sql = "SELECT Id, IdKm, IdSp, IdThuongHieu, IdXuatxu, IdTheLoai, IdChatLieuDay,"
                    + " IdMauMatSo, IdMauVo, IdPhuKien, HinhDangMatSo, IdTinhNang, ChatLieuMatKinh,"
                    + " GioiTinh, KieuMay, NamBH, KichThuoc, SoLuongTon, TinhTrang, DonGia\n"
                    + "FROM     ChiTietSP";

            Connection cn = DBContext.getConnection();
            PreparedStatement pre = cn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CTSP ct = new CTSP();
//                PhuKienQ ms = new PhuKienQ();
//                ms.setId(rs.getString("IdMauSac"));
//                ms.setMa(rs.getString("Ma"));
//                ms.setTen(rs.getString("Ten"));
                ct.setId("Id");
                ct.setIdkm(rs.getString("IdKm"));
                ct.setIdsp(rs.getString("IdSp"));
                ct.setIdchatlieuday(rs.getString("IdChatLieuDay"));
                ct.setIdmaumatso(rs.getString("IdMauMatSo"));
                ct.setIdmauvo(rs.getString("IdMauVo"));
                ct.setIdphukien(rs.getString("IdPhuKien"));
                ct.setIdtheloai(rs.getString("IdTheLoai"));
                ct.setIdthuonghieu(rs.getString("IdThuongHieu"));
                ct.setIdtinhnang(rs.getString("IdTinhNang"));
                ct.setIdxuaxu(rs.getString("IdXuatxu"));
                ct.setGioitinh(rs.getString("GioiTinh"));
                ct.setChatlieumatkinh(rs.getString("ChatLieuMatKinh"));
                ct.setDongia(rs.getDouble("DonGia"));
                ct.setHinhdangmatso(rs.getString("HinhDangMatSo"));
                ct.setNambh(rs.getDouble("NamBH"));
                ct.setKichthuoc(rs.getString("KichThuoc"));
                ct.setKieumay(rs.getString("KieuMay"));
                ct.setSoluongton(rs.getInt("SoLuongTon"));
                ct.setTinhtrang(rs.getInt("IdTinhNang"));
                ds.add(ct);
            }
            rs.close();
            pre.close();
            cn.close();
            return ds;

        } catch (SQLException ex) {
            System.out.println("lỗi đọc dl" + ex.getMessage());
            return null;
        }

    }

    public boolean themDL(CTSP ct) {
        try {
            String sql = "INSERT INTO [dbo].[ChiTietSP]\n"
                    + "           ([Id]\n"
                    + "           ,[IdKm]\n"
                    + "           ,[IdSp]\n"
                    + "           ,[IdThuongHieu]\n"
                    + "           ,[IdXuatxu]\n"
                    + "           ,[IdTheLoai]\n"
                    + "           ,[IdChatLieuDay]\n"
                    + "           ,[IdMauMatSo]\n"
                    + "           ,[IdMauVo]\n"
                    + "           ,[IdPhuKien]\n"
                    + "           ,[IdTinhNang]\n"
                    + "           ,[HinhDangMatSo]\n"
                    + "           ,[ChatLieuMatKinh]\n"
                    + "           ,[GioiTinh]\n"
                    + "           ,[KieuMay]\n"
                    + "           ,[NamBH]\n"
                    + "           ,[KichThuoc]\n"
                    + "           ,[SoLuongTon]\n"
                    + "           ,[DonGia]\n"
                    + "           ,[TinhTrang])\n"
                    + "     VALUES\n"
                    + "           (newid()\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            Connection cn = DBContext.getConnection();
            PreparedStatement pre = cn.prepareStatement(sql);

            //  pre.setString(1, ct.getId());
            pre.setString(1, ct.getId());
            pre.setString(2, ct.getIdkm());
            pre.setString(3, ct.getIdsp());
            pre.setString(4, ct.getIdthuonghieu());
            pre.setString(5, ct.getIdxuaxu());
            pre.setString(6, ct.getIdtheloai());
            pre.setString(7, ct.getIdchatlieuday());
            pre.setString(8, ct.getIdmaumatso());
            pre.setString(9, ct.getIdmauvo());
            pre.setString(10, ct.getIdphukien());
            pre.setString(11, ct.getIdtinhnang());
            pre.setString(12, ct.getHinhdangmatso());
            pre.setString(13, ct.getChatlieumatkinh());
            pre.setString(14, ct.getGioitinh());
            pre.setString(15, ct.getKieumay());
            pre.setDouble(16, ct.getNambh());
            pre.setString(17, ct.getKichthuoc());
            pre.setInt(18, ct.getSoluongton());
            pre.setDouble(19, ct.getDongia());
            pre.setInt(20, ct.getTinhtrang());

            boolean kq = pre.executeUpdate() > 0;
            pre.close();
            cn.close();
            return kq;
        } catch (SQLException ex) {
            System.out.println("lỗi thêm dl " + ex.getMessage());
            return false;
        }

    }

    public boolean suaDL(CTSP ct) {
        try {
            String sql = " UPDATE [dbo].[ChiTietSP]\n"
                    + "   SET \n"
                    + "      [IdKm] = ?\n"
                    + "      ,[IdSp] = ?\n"
                    + "      ,[IdThuongHieu] = ?\n"
                    + "      ,[IdXuatxu] = ?\n"
                    + "      ,[IdTheLoai] = ?\n"
                    + "      ,[IdChatLieuDay] = ?\n"
                    + "      ,[IdMauMatSo] = ?\n"
                    + "      ,[IdMauVo] = ?\n"
                    + "      ,[IdPhuKien] = ?\n"
                    + "      ,[IdTinhNang] = ?\n"
                    + "      ,[HinhDangMatSo] = ?\n"
                    + "      ,[ChatLieuMatKinh] = ?\n"
                    + "      ,[GioiTinh] = ?\n"
                    + "      ,[KieuMay] = ?\n"
                    + "      ,[NamBH] = ?\n"
                    + "      ,[KichThuoc] = ?\n"
                    + "      ,[SoLuongTon] = ?\n"
                    + "      ,[DonGia] = ?\n"
                    + "      ,[TinhTrang] = ?\n"
                    + " WHERE Id = ? ";
            Connection cn = DBContext.getConnection();
            PreparedStatement pre = cn.prepareStatement(sql);
            
            
            pre.setString(1, ct.getIdkm());
            pre.setString(2, ct.getIdsp());
            pre.setString(3, ct.getIdthuonghieu());
            pre.setString(4, ct.getIdxuaxu());
            pre.setString(5, ct.getIdtheloai());
            pre.setString(6, ct.getIdchatlieuday());
            pre.setString(7, ct.getIdmaumatso());
            pre.setString(8, ct.getIdmauvo());
            pre.setString(9, ct.getIdphukien());
            pre.setString(10, ct.getIdtinhnang());
            pre.setString(11, ct.getHinhdangmatso());
            pre.setString(12, ct.getChatlieumatkinh());
            pre.setString(13, ct.getGioitinh());
            pre.setString(14, ct.getKieumay());
            pre.setDouble(15, ct.getNambh());
            pre.setString(16, ct.getKichthuoc());
            pre.setInt(17, ct.getSoluongton());
            pre.setDouble(18, ct.getDongia());
            pre.setInt(19, ct.getTinhtrang());
            
              pre.setString(20, ct.getId());
            boolean kq = pre.executeUpdate() > 0;
            pre.close();
            cn.close();
            return kq;
        } catch (SQLException ex) {
            System.out.println("lỗi sửa dl" + ex.getMessage());
            return false;
        }
    }

 
    public boolean xoaDL(String ma) {
        try {
            String sql = "delete from ChiTietSP where Id = ? ";
            Connection cn = DBContext.getConnection();
            PreparedStatement pre = cn.prepareStatement(sql);

            pre.setString(1, ma);

            boolean kq = pre.executeUpdate() > 0;
            pre.close();
            cn.close();
            return kq;
        } catch (SQLException ex) {
            System.out.println("lỗi sửa dl" + ex.getMessage());
            return false;
        }

    }

   
//    public List<CTSP> tim(String ma) {
//        List<CTSP> ds = new ArrayList<>();
//        try {
//            String sql = "SELECT ChiTietSP.Id, ChiTietSP.IdMauSac,MauSac.Ma,MauSac.Ten,\n"
//                    + "ChiTietSP.MoTa,ChiTietSP.SoLuongTon,ChiTietSP.GiaNhap,\n"
//                    + "ChiTietSP.GiaBan\n"
//                    + "FROM     ChiTietSP JOIN MauSac ON ChiTietSP.IdMauSac = MauSac.Id\n"
//                    + "				  where MauSac.Ma = ?";
//            Connection cn = DBContext.getConnection();
//            PreparedStatement pre = cn.prepareStatement(sql);
//
//            pre.setString(1, ma);
//            ResultSet rs = pre.executeQuery();
//            if (rs.next()) {
//                ChiTietSanPham ct = new ChiTietSanPham();
//                MauSac ms = new MauSac();
//                ms.setId(rs.getString("IdMauSac"));
//                ms.setMa(rs.getString("Ma"));
//                ms.setTen(rs.getString("Ten"));
//                ct.setMs(ms);
//                ct.setId(rs.getString("Id"));
//                ct.setGiaBan(rs.getDouble("GiaBan"));
//                ct.setGiaNhap(rs.getDouble("GiaNhap"));
//                ct.setSoLgTon(rs.getDouble("SoLuongTon"));
//                ct.setMoTa(rs.getString("MoTa"));
//                ds.add(ct);
//            }
//            return ds;
//
//        } catch (SQLException ex) {
//            System.out.println("lỗi sửa dl" + ex.getMessage());
//            return null;
//        }
//
//    }

}
