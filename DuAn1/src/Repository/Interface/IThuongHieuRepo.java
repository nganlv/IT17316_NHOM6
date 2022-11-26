/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.ThuongHieu;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IThuongHieuRepo {
   public List<ThuongHieu> getAllTh();
   public Integer addTh(ThuongHieu th);
   public Integer updateTh(ThuongHieu th);
   public Integer deleteTh(String ma);
}
