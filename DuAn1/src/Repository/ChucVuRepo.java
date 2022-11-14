/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBContext;
import ViewModels.QuanLyChucVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class ChucVuRepo {
    public List<QuanLyChucVu> getAll(){
       List<QuanLyChucVu> listCV=new ArrayList();
       String sql="select Id,Ma,Ten from ChucVu";
       try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            listCV.add(new QuanLyChucVu(rs.getString("Id"),rs.getString("Ma"),rs.getString("Ten")));
            }
            return listCV;
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    return null;
    }
    
}
