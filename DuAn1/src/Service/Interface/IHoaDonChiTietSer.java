/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import ViewModels.QlHoaDonChiTiet;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IHoaDonChiTietSer {
    public List<QlHoaDonChiTiet> getAllHdcts(String ma);
    public Integer updateSls(QlHoaDonChiTiet hdct);
    public List<QlHoaDonChiTiet> deletes();
}
