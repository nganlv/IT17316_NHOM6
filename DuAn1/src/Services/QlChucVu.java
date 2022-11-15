/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.ChucVu;
import ViewModels.QuanLyChucVu;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface QlChucVu {
    List<QuanLyChucVu> getView();
      Boolean checkMa(String maChucVu);
      List<ChucVu> getAll();
    ChucVu getOne(String maChucVu);
  
    String addCV(ChucVu cv);
    String updateCV(ChucVu cv);
    String deleteCV(String maChucVu);
}