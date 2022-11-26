/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.ChucVu;
import DomainModels.ChucVu;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IChucVuRepo {
   public List<ChucVu> getAllTh();
   public Integer addTh(ChucVu th);
   public Integer updateTh(ChucVu th);
   public Integer deleteTh(String ma);
}
