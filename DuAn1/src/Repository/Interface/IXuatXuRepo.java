/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.XuatXu;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IXuatXuRepo {
    public List<XuatXu> getAllXx();
   public Integer addXx(XuatXu xx);
   public Integer updateXx(XuatXu xx);
   public Integer deleteXx(String ma);
}
