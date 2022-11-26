/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.SanPham;
import java.util.List;

/**
 *
 * @author levan
 */
public interface ISanPhamRepo {
    public List<SanPham> getAllSp();
   public Integer addSp(SanPham sp);
   public Integer updateSp(SanPham sp);
   public Integer deleteSp(String ma);
}
