/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.TheLoai;
import Utilities.DBContext;
import ViewModels.QuanLyTheLoai;
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
public class TheLoaiRepo {
    public List<QuanLyTheLoai> getAll(){
       List<QuanLyTheLoai> listCV=new ArrayList();
       String sql="select Id,Ma,Ten from TheLoai";
       try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            listCV.add(new QuanLyTheLoai(rs.getString("Id"),rs.getString("Ma"),rs.getString("Ten")));
            }
            return listCV;
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    return null;
    }
     
    public List<TheLoai> getView() {
        List<TheLoai> listCV = new ArrayList<>();
        String sql = """
                     SELECT Id, Ma, Ten
                     FROM     TheLoai""";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listCV.add(new TheLoai(rs.getString("Id") ,rs.getString("Ma"), rs.getString("Ten")));
            }
            return listCV;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
       public TheLoai getOne(String maCV) {
        String sql = """
                     SELECT Id, Ma, Ten
                     FROM     TheLoai """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maCV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TheLoai cv = new TheLoai(rs.getString(1), rs.getString(2), rs.getString(3));
                return cv;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
     public Integer addCV(TheLoai cv) throws SQLException{
      String sql="insert into TheLoai(Ma,Ten) values(?,?)";
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
    public Integer updateCV(TheLoai cv) {
        String sql = """
                     UPDATE [dbo].[TheLoai]
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
    
    
     public Integer deleteCV(String maTheLoai) {
        String sql = """
                     DELETE FROM [dbo].[TheLoai]
                                 WHERE Ma = ?""";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maTheLoai);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
