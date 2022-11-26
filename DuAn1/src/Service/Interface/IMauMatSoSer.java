/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import ViewModels.QlMauMatSo;
import ViewModels.QlSanPham;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IMauMatSoSer {
    public List<QlMauMatSo> getAllMmss();
    public Integer addMmss(QlMauMatSo mms);
    public Integer updateMmss(QlMauMatSo mms);
    public Integer deleteMmss(String ma);
}
