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
     public List<ChucVu> getAlls() {
        List<ChucVu> listCV = new ArrayList<>();
        String sql = """
                     SELECT Id, Ma, Ten
                     FROM     ChucVu""";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listCV.add(new ChucVu(rs.getString("Id") ,rs.getString("Ma"), rs.getString("Ten")));
            }
            return listCV;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ChucVu getOne(String maCV) {
        String sql = """
                     SELECT Id, Ma, Ten
                     FROM     ChucVu """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maCV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ChucVu cv = new ChucVu(rs.getString(1), rs.getString(2), rs.getString(3));
                return cv;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Integer addCV(ChucVu cv) {
        String sql = """
                     INSERT INTO [dbo].[ChucVu]
                                ([Ma]
                                ,[Ten])
                          VALUES (?, ?) """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, cv.getMa());
            ps.setObject(2, cv.getTen());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
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
