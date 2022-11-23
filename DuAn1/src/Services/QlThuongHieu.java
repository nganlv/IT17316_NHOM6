/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.ThuongHieu;
import ViewModels.QuanLyThuongHieu;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface QlThuongHieu {
    List<QuanLyThuongHieu> getView();
     List<ThuongHieu> getAlls();
       ThuongHieu getOne(String maThuongHieu);
      Boolean checkMa(String maThuongHieu);
       String addCVs(ThuongHieu cv);
         String updateCV(ThuongHieu cv);
    String deleteCV(String maThuongHieu);
}
