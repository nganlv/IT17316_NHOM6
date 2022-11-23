/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.ChatLieuDay;
import java.util.ArrayList;


/**
 *
 * @author Acer
 */
public interface ChatLuongDaySer {
    ArrayList<ChatLieuDay> getView();
    
    Boolean checkMa(String Ma);
    
    String add(ChatLieuDay day);

    String delete(String day);
    
    String update(ChatLieuDay day);
    
}
