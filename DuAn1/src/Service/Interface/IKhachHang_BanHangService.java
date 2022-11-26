/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import ViewModels.QlKhachHang_BanHang;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IKhachHang_BanHangService {
    public List<QlKhachHang_BanHang> getAllKhs();
    public Integer addKhs(QlKhachHang_BanHang kh);
    public Integer updateKhs(QlKhachHang_BanHang kh);
    public List<QlKhachHang_BanHang> timKhs(String ten);
}
