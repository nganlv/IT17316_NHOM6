/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import Repository.ChatLieuDayRepo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Services.ChatLuongDaySer;
import ViewModels.ChatLieuDay;


/**
 *
 * @author Acer
 */
public class ChatLuongDayImpl implements  ChatLuongDaySer {
    private final ChatLieuDayRepo cLDRe = new ChatLieuDayRepo();

    @Override
    public ArrayList<ChatLieuDay> getView() {
         try {
            return cLDRe.getAll();
        } catch (Exception ex) {
            Logger.getLogger(ChatLuongDayImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Boolean checkMa(String Ma) {
         ArrayList<ChatLieuDay> list;
        try {
            list = cLDRe.getAll();
            for (ChatLieuDay c : list) {
                if (c.getMa().equalsIgnoreCase(Ma)) {
                    return true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }


    @Override
    public String delete(String day) {
         
        if (cLDRe.deleteK(day) < 1) {
            return "Xóa thất bại";
        } else {
            return "Xóa thành công";
        }
    }

   

    @Override
    public String add(ChatLieuDay day) {
          try {
            if (cLDRe.insert(day) < 1) {
                return "Thêm thất bại";
            } else {
                return "Thêm thành công";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public String update(ChatLieuDay day) {
        if(cLDRe.updateK(day) < 1){
            return "Sửa thất bại";
        }else{
            return "Sửa thành công";
        }
    }
    
    
}
