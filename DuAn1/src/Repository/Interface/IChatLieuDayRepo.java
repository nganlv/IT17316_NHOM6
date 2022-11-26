/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.ChatLieuDay;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IChatLieuDayRepo {
    public List<ChatLieuDay> getAllCld();
   public Integer addCld(ChatLieuDay cld);
   public Integer updateCld(ChatLieuDay cld);
   public Integer deleteCld(String ma);
}
