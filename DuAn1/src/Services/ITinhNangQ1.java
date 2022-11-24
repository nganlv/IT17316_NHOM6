/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;
import ViewModels.QuanLyTinhNangQ1;
import java.util.*;

/**
 *
 * @author pc
 */
public interface ITinhNangQ1 {
  ArrayList<QuanLyTinhNangQ1> getAll();
    void add(QuanLyTinhNangQ1 sp);
    void sua(QuanLyTinhNangQ1 sp);
    void xoa(String ma); 
 
}
