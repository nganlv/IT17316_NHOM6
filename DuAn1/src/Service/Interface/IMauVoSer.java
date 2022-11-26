/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import ViewModels.QlMauVo;
import ViewModels.QlSanPham;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IMauVoSer {
    public List<QlMauVo> getAllMvs();
    public Integer addMvs(QlMauVo mv);
    public Integer updateMvs(QlMauVo mv);
    public Integer deleteMvs(String ma);
}
