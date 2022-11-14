/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBContext;
import ViewModels.KhachHang;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Acer
 */
public class KhachHangRepo {
    public  ArrayList<KhachHang> getAll() throws Exception{
        ArrayList<KhachHang> listKH = new ArrayList();
        Connection con = DBContext.getConnection();
        String sql = "SELECT Ma, HoTen, GioiTinh, NgaySinh, Sdt, DiaChi, Email, NgayTao FROM KhachHang";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            listKH.add(new KhachHang(rs.getString("Ma"),
                    rs.getString("HoTen"),
                    rs.getString("GioiTinh"),
                    rs.getString("Sdt"), 
                    rs.getString("DiaChi"),
                    rs.getString("Email"), 
                    rs.getString("Diem"), 
                    rs.getDate("NgaySinh"),
                    rs.getDate("NgayTao"), 
                    rs.getDate("NgayHetHan")));
        }
        return listKH; 
    }
    
    
}
