/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.NhanVien;
import ViewModels.QuanLyNhanVien;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface QLNhanVien {
    List<QuanLyNhanVien> getAll();
     String add(NhanVien nv);
     String update(NhanVien nv);
      String delete(String maNV);
}
