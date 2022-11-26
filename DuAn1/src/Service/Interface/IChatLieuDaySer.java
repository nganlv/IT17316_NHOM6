/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import ViewModels.QlChatLieuDay;
import ViewModels.QlSanPham;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IChatLieuDaySer {
    public List<QlChatLieuDay> getAllClds();
    public Integer addClds(QlChatLieuDay cld);
    public Integer updateClds(QlChatLieuDay cld);
    public Integer deleteClds(String ma);
}
