/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import ViewModels.QlSanPham;
import ViewModels.QlTinhNang;
import java.util.List;

/**
 *
 * @author levan
 */
public interface ITinhNangSer {
    public List<QlTinhNang> getAllTns();
    public Integer addTns(QlTinhNang tn);
    public Integer updateTns(QlTinhNang tn);
    public Integer deleteTns(String ma);
}
