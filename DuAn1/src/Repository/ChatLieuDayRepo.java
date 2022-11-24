/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;


import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ViewModels.ChatLieuDay;


/**
 *
 * @author Acer
 */
public class ChatLieuDayRepo {
     public ArrayList<ChatLieuDay> getAll() throws Exception {
        ArrayList<ChatLieuDay> cL = new ArrayList();
        Connection con = DBContext.getConnection();
        String sql = "SELECT Id, Ma, Ten FROM     ChatLieuDay";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            cL.add(new ChatLieuDay(
                    rs.getString("Id"),
                    rs.getString("Ma"),
                    rs.getString("Ten")
                    
            ));
        }

        return cL;
    }
     public Integer insert(ChatLieuDay day ) throws Exception {
        String sql = " INSERT INTO ChatLieuDay (Ma, Ten) VALUES (?,?)";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, day.getMa());
            ps.setString(2, day.getTen());
            
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
     public Integer deleteK(String ID) {
        String sql = "DELETE FROM ChatLieuDay where Id = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ID);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;

    }
      public Integer updateK(ChatLieuDay cL) {
        String sql = "UPDATE ChatLieuDay SET Ten = ? where Ma = ?";
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
