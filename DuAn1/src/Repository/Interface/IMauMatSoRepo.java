/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.MauMatSo;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IMauMatSoRepo {
    public List<MauMatSo> getAllMms();
   public Integer addMms(MauMatSo mms);
   public Integer updateMms(MauMatSo mms);
   public Integer deleteMms(String ma);
}
