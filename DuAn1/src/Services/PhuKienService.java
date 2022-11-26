/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.PhuKien;
import Repository.Interface.IPhuKienRepo;
import Repository.PhuKienRepo;
import Service.Interface.IPhuKienSer;
import ViewModels.QlPhuKien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class PhuKienService implements IPhuKienSer {

    private final IPhuKienRepo iPhuKienRepo = new PhuKienRepo();

    @Override
    public List<QlPhuKien> getAllPks() {
        try {
            List<QlPhuKien> listPk = new ArrayList<>();
            for (PhuKien pk : iPhuKienRepo.getAllPk()) {
                listPk.add(new QlPhuKien(pk.getId(), pk.getMa(), pk.getTen()));
            }
            return listPk;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addPks(QlPhuKien pk) {
        try {
            return iPhuKienRepo.addPk(new PhuKien(pk.getId(), pk.getMa(), pk.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updatePks(QlPhuKien pk) {
        try {
            return iPhuKienRepo.updatePk(new PhuKien(pk.getId(), pk.getMa(), pk.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer deletePks(String ma) {
        try {
            return iPhuKienRepo.deletePk(ma);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
