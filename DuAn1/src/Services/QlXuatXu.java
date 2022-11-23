/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.XuatXu;
import ViewModels.QuanLyXuatXu;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface QlXuatXu {
    List<QuanLyXuatXu> getView();
     List<XuatXu> getAlls();
       XuatXu getOne(String maXuatXu);
      Boolean checkMa(String maXuatXu);
       String addCVs(XuatXu cv);
         String updateCV(XuatXu cv);
    String deleteCV(String maXuatXu);
}
