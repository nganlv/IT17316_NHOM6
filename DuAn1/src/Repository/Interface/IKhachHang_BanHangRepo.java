/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.KhachHang_BanHang;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IKhachHang_BanHangRepo {
    public List<KhachHang_BanHang> getAllKh();
    public Integer addKh(KhachHang_BanHang kh);
    public Integer updateKh(KhachHang_BanHang kh);
    public List<KhachHang_BanHang> timKh(String ten);
}
