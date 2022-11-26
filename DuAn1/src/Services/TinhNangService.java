/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.TinhNang;
import Repository.Interface.ITinhNangRepo;
import Repository.TinhNangRepo;
import Service.Interface.ITinhNangSer;
import ViewModels.QlTinhNang;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class TinhNangService implements ITinhNangSer {

    private final ITinhNangRepo iTinhNangRepo = new TinhNangRepo();

    @Override
    public List<QlTinhNang> getAllTns() {
        try {
            List<QlTinhNang> listTn = new ArrayList<>();
            for (TinhNang tn : iTinhNangRepo.getAllTn()) {
                listTn.add(new QlTinhNang(tn.getId(), tn.getMa(), tn.getTen()));
            }
            return listTn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addTns(QlTinhNang tn) {
        try {
            return iTinhNangRepo.addTn(new TinhNang(tn.getId(), tn.getMa(), tn.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateTns(QlTinhNang tn) {
        try {
            return iTinhNangRepo.updateTn(new TinhNang(tn.getId(), tn.getMa(), tn.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer deleteTns(String ma) {
        try {
            return iTinhNangRepo.deleteTn(ma);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
