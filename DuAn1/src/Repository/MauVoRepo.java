/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;


import Utilities.DBContext;
import ViewModels.MauVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



/**
 *
 * @author Acer
 */
public class MauVoRepo {
     public ArrayList<MauVo> getAll() throws Exception {
        ArrayList<MauVo> mMs = new ArrayList();
        Connection con = DBContext.getConnection();
        String sql = "SELECT Id, Ma, Ten FROM     MauVo";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            mMs.add(new MauVo(
                    rs.getString("Id"),
                    rs.getString("Ma"),
                    rs.getString("Ten")
                    
            ));
        }

        return mMs;
    }
     public Integer insert(MauVo mau ) throws Exception {
        String sql = " INSERT INTO MauVo (Ma, Ten) VALUES (?,?)";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mau.getMa());
            ps.setString(2, mau.getTen());
            
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
     public Integer delete(String ID) {
        String sql = "DELETE FROM MauVo where Id = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ID);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;

    }
      public Integer updateK(MauVo cL) {
        String sql = "UPDATE MauVo SET Ten = ? where Ma = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, cL.getTen());
            ps.setObject(2, cL.getMa());
            
            return ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
