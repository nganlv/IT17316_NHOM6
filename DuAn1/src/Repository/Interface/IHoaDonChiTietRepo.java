/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IHoaDonChiTietRepo {
    public List<HoaDonChiTiet> getAllHdct(String ma);
    public Integer updateSl(HoaDonChiTiet hdct);
    public List<HoaDonChiTiet> delete();
}
