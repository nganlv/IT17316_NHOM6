/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChatLieuDay;
import Repository.ChatLieuDayRepo;
import Repository.Interface.IChatLieuDayRepo;
import Service.Interface.IChatLieuDaySer;
import ViewModels.QlChatLieuDay;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class ChatLieuDayService implements IChatLieuDaySer {

    private final IChatLieuDayRepo iChatLieuDayRepo = new ChatLieuDayRepo();

    @Override
    public List<QlChatLieuDay> getAllClds() {
        try {
            List<QlChatLieuDay> listCld = new ArrayList<>();
            for (ChatLieuDay cld : iChatLieuDayRepo.getAllCld()) {
                listCld.add(new QlChatLieuDay(cld.getId(), cld.getMa(), cld.getTen()));
            }
            return listCld;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addClds(QlChatLieuDay cld) {
        try {
            return iChatLieuDayRepo.addCld(new ChatLieuDay(cld.getId(), cld.getMa(), cld.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateClds(QlChatLieuDay cld) {
        try {
            return iChatLieuDayRepo.updateCld(new ChatLieuDay(cld.getId(), cld.getMa(), cld.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer deleteClds(String ma) {
        try {
            return iChatLieuDayRepo.deleteCld(ma);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
