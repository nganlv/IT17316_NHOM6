/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import ViewModels.QlSanPham;
import ViewModels.QlXuatXu;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IXuatXuSer {
    public List<QlXuatXu> getAllXxs();
    public Integer addXxs(QlXuatXu xx);
    public Integer updateXxs(QlXuatXu xx);
    public Integer deleteXxs(String ma);
}
