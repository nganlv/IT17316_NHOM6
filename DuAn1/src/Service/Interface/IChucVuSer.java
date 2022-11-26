/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModels.ChucVu;
import ViewModels.QuanLyChucVu;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IChucVuSer {
    public List<QuanLyChucVu> getAllThs();
    public List<ChucVu> getAll();
    public Integer addThs(ChucVu th);
    public Integer updateThs(ChucVu th);
    public Integer deleteThs(String ma);
}
