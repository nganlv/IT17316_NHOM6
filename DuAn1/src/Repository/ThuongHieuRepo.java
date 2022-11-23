/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ThuongHieu;
import Utilities.DBContext;
import ViewModels.QuanLyThuongHieu;
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
public class ThuongHieuRepo {
    public List<QuanLyThuongHieu> getAll(){
       List<QuanLyThuongHieu> listCV=new ArrayList();
       String sql="select Id,Ma,Ten from ThuongHieu";
       try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            listCV.add(new QuanLyThuongHieu(rs.getString("Id"),rs.getString("Ma"),rs.getString("Ten")));
            }
            return listCV;
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    return null;
    }
     
    public List<ThuongHieu> getView() {
        List<ThuongHieu> listCV = new ArrayList<>();
        String sql = """
                     SELECT Id, Ma, Ten
                     FROM     ThuongHieu""";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listCV.add(new ThuongHieu(rs.getString("Id") ,rs.getString("Ma"), rs.getString("Ten")));
            }
            return listCV;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
       public ThuongHieu getOne(String maCV) {
        String sql = """
                     SELECT Id, Ma, Ten
                     FROM     ThuongHieu """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maCV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ThuongHieu cv = new ThuongHieu(rs.getString(1), rs.getString(2), rs.getString(3));
                return cv;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
     public Integer addCV(ThuongHieu cv) throws SQLException{
      String sql="insert into ThuongHieu(Ma,Ten) values(?,?)";
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
    public Integer updateCV(ThuongHieu cv) {
        String sql = """
                     UPDATE [dbo].[ThuongHieu]
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
    
    
     public Integer deleteCV(String maThuongHieu) {
        String sql = """
                     DELETE FROM [dbo].[ThuongHieu]
                                 WHERE Ma = ?""";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maThuongHieu);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
