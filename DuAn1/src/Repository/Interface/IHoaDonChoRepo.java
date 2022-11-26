/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.HoaDonCho;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IHoaDonChoRepo {
    public List<HoaDonCho> getHd();

    public List<HoaDonCho> getHd2(String ma);

}
