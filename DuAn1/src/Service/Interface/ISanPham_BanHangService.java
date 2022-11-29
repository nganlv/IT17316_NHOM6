/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import ViewModels.QLSanPham_BanHang;
import java.util.List;

/**
 *
 * @author levan
 */
public interface ISanPham_BanHangService {
    List<QLSanPham_BanHang> getAllSps();
    List<QLSanPham_BanHang> timSpTheoMas();

    public List<QLSanPham_BanHang> timSpTheoMas(String text);
}
