/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import ViewModels.QlHoaDonCho;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IHoaDonChoService {
    public List<QlHoaDonCho> getHds();
    public List<QlHoaDonCho> getHd2s(String ma);
}
