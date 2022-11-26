/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.TheLoai;
import java.util.List;

/**
 *
 * @author levan
 */
public interface ITheLoaiRepo {
    public List<TheLoai> getAllTl();
   public Integer addTl(TheLoai th);
   public Integer updateTl(TheLoai tl);
   public Integer deleteTl(String ma);
}
