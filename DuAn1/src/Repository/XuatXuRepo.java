/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.XuatXu;
import Utilities.DBContext;
import ViewModels.QuanLyXuatXu;
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
public class XuatXuRepo {
    public List<QuanLyXuatXu> getAll(){
       List<QuanLyXuatXu> listCV=new ArrayList();
       String sql="select Id,Ma,Ten from XuatXu";
       try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            listCV.add(new QuanLyXuatXu(rs.getString("Id"),rs.getString("Ma"),rs.getString("Ten")));
            }
            return listCV;
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    return null;
    }
     
    public List<XuatXu> getView() {
        List<XuatXu> listCV = new ArrayList<>();
        String sql = """
                     SELECT Id, Ma, Ten
                     FROM     XuatXu""";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listCV.add(new XuatXu(rs.getString("Id") ,rs.getString("Ma"), rs.getString("Ten")));
            }
            return listCV;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
       public XuatXu getOne(String maCV) {
        String sql = """
                     SELECT Id, Ma, Ten
                     FROM     XuatXu """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maCV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                XuatXu cv = new XuatXu(rs.getString(1), rs.getString(2), rs.getString(3));
                return cv;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
     public Integer addCV(XuatXu cv) throws SQLException{
      String sql="insert into XuatXu(Ma,Ten) values(?,?)";
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
    public Integer updateCV(XuatXu cv) {
        String sql = """
                     UPDATE [dbo].[XuatXu]
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
    
    
     public Integer deleteCV(String maXuatXu) {
        String sql = """
                     DELETE FROM [dbo].[XuatXu]
                                 WHERE Ma = ?""";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maXuatXu);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
