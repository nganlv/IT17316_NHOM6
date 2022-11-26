/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.MauVo;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IMauVoRepo {
    public List<MauVo> getAllMv();
   public Integer addMv(MauVo mv);
   public Integer updateMv(MauVo mv);
   public Integer deleteMv(String ma);
}
