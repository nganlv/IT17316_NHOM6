/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.TheLoai;
import ViewModels.QuanLyTheLoai;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface QlTheLoai {
    List<QuanLyTheLoai> getView();
     List<TheLoai> getAlls();
       TheLoai getOne(String maTheLoai);
      Boolean checkMa(String maTheLoai);
       String addCVs(TheLoai cv);
         String updateCV(TheLoai cv);
    String deleteCV(String maTheLoai);
}
