/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;
import DomainModels.SanPham;
import java.util.*;
import ViewModels.QuanLySanPham;
/**
 *
 * @author pc
 */
public interface IsanPham {
      List<QuanLySanPham> getAll();
    boolean add(QuanLySanPham nx);
    boolean update(QuanLySanPham nx);
    boolean delete(String ma);     
}
