/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import ViewModels.QuanLyChucVu;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IChucVuSer {
    public List<QuanLyChucVu> getAllThs();
    public Integer addThs(QuanLyChucVu th);
    public Integer updateThs(QuanLyChucVu th);
    public Integer deleteThs(String ma);
}
