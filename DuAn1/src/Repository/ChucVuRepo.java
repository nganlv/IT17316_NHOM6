/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChucVu;
import Utilities.DBContext;
import ViewModels.QuanLyChucVu;
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
     public Integer addCV(ChucVu cv) throws SQLException{
      String sql="insert into ChucVu(Ma,Ten) values(?,?)";
      try(Connection conn=DBContext.getConnection();
              PreparedStatement ps=conn.prepareStatement(sql)){
          ps.setObject(1,cv.getMa());
          ps.setObject(2,cv.getTen());
return ps.executeUpdate();
      }catch(SQLException ex){
          ex.printStackTrace();
      }
      return -1;
  }
    public Integer updateCV(ChucVu cv) {
        String sql = """
                     UPDATE [dbo].[ChucVu]
                             SET [Ten] = ?
                           WHERE Ma = ? """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(2, cv.getMa());
            ps.setObject(1, cv.getTen());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
        
    } 
    
    
     public Integer deleteCV(String maChucVu) {
        String sql = """
                     DELETE FROM [dbo].[ChucVu]
                                 WHERE Ma = ?""";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maChucVu);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
