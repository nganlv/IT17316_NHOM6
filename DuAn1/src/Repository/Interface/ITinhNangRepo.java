/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.TinhNang;
import java.util.List;

/**
 *
 * @author levan
 */
public interface ITinhNangRepo {
    public List<TinhNang> getAllTn();
   public Integer addTn(TinhNang tn);
   public Integer updateTn(TinhNang tn);
   public Integer deleteTn(String ma);
}
