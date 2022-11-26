/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.SanPham_BanHang;
import java.util.List;

/**
 *
 * @author levan
 */
public interface ISanPham_BanHangRepo {
    public List<SanPham_BanHang> getAllSp();
    public List<SanPham_BanHang> timSpTheoMa(String ma);
}
