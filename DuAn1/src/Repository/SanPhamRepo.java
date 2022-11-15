/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import DomainModels.SanPham;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author levan
 */
public class SanPhamRepo {
    public List<SanPham> getAllSp() throws SQLException{
        List<SanPham> listSp=new ArrayList<>();
        Connection conn=DBContext.getConnection();
        String sql="select Ma, Ten, ThuongHieu, XuatXu, GioiTinh,MauSac, KichThuoc, ChatLieu, NamBH, DonGia, SoLuongTon "
                + " from SanPham join ChiTietSP on SanPham.Id=ChiTietSP.IdSP";
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            SanPham sp=new SanPham();
            sp.setMa(rs.getString("Ma"));
            sp.setTen(rs.getString("Ten"));
            sp.setThuongHieu(rs.getString("ThuongHieu"));
            sp.setXuatXu(rs.getString("XuatXu"));
            sp.setGioiTinh(rs.getString("GioiTinh"));
            sp.setMauSac(rs.getString("MauSac"));
            sp.setKichThuoc(rs.getString("KichThuoc"));
            sp.setChatLieu(rs.getString("ChatLieu"));
            sp.setNamBh(rs.getInt("NamBH"));
            sp.setDonGia(rs.getBigDecimal("DonGia"));
            sp.setSoLuong(rs.getInt("SoLuongTon"));
            listSp.add(sp);
        }     
        rs.close();
        ps.close();
        conn.close();
        return listSp;
    }  
}
