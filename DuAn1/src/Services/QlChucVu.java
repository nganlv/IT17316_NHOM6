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
     List<ChucVu> getAlls();
//       ChucVu getOne(String maChucVu);
      Boolean checkMa(String maChucVu);
       String addCVs(ChucVu cv);
         String updateCV(ChucVu cv);
    String deleteCV(String maChucVu);
}
