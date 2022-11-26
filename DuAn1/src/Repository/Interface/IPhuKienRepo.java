/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.PhuKien;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IPhuKienRepo {
    public List<PhuKien> getAllPk();
   public Integer addPk(PhuKien pk);
   public Integer updatePk(PhuKien pk);
   public Integer deletePk(String ma);
}
