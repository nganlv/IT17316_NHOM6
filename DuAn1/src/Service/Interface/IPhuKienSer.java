/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import ViewModels.QlPhuKien;
import ViewModels.QlSanPham;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IPhuKienSer {
    public List<QlPhuKien> getAllPks();
    public Integer addPks(QlPhuKien pk);
    public Integer updatePks(QlPhuKien pk);
    public Integer deletePks(String ma);
}
