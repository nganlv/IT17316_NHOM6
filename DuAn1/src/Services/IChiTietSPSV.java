/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;
import ViewModels.QuanLyCTSP;
import java.util.*;

/**
 *
 * @author pc
 */
public interface IChiTietSPSV {
  List<QuanLyCTSP>layDS();
void them(QuanLyCTSP sp);  
void sua(QuanLyCTSP sp);  
void xoa(String ma);  
 
}
