/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.MauVo;
import Repository.Interface.IMauVoRepo;
import Repository.MauVoRepo;
import Service.Interface.IMauVoSer;
import ViewModels.QlMauVo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class MauVoService implements IMauVoSer {

    private final IMauVoRepo iMauVoRepo = new MauVoRepo();

    @Override
    public List<QlMauVo> getAllMvs() {
        try {
            List<QlMauVo> listMv = new ArrayList<>();
            for (MauVo mv : iMauVoRepo.getAllMv()) {
                listMv.add(new QlMauVo(mv.getId(), mv.getMa(), mv.getTen()));
            }
            return listMv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addMvs(QlMauVo mv) {
        try {
            return iMauVoRepo.addMv(new MauVo(mv.getId(), mv.getMa(), mv.getTen()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateMvs(QlMauVo mv) {
        try {
            return iMauVoRepo.updateMv(new MauVo(mv.getId(), mv.getMa(), mv.getTen()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer deleteMvs(String ma) {
        try {
            return iMauVoRepo.deleteMv(ma);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
