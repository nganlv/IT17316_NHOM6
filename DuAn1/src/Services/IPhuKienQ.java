/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;
import ViewModels.QuanLyPhuKienQ;
import java.util.*;

/**
 *
 * @author pc
 */
public interface IPhuKienQ {
  ArrayList<QuanLyPhuKienQ> getAll();
    void add(QuanLyPhuKienQ sp);
    void sua(QuanLyPhuKienQ sp);
    void xoa(String ma); 
 
}
