/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.MauMatSo;
import Repository.Interface.IMauMatSoRepo;
import Repository.MauMatSoRepo;
import Service.Interface.IMauMatSoSer;
import ViewModels.QlMauMatSo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class MauMatSoService implements IMauMatSoSer{
    private final IMauMatSoRepo iMauMatSoRepo=new MauMatSoRepo();
    @Override
    public List<QlMauMatSo> getAllMmss(){
        try {
            List<QlMauMatSo> listMms=new ArrayList<>();
            for(MauMatSo mms:iMauMatSoRepo.getAllMms()){
                listMms.add(new QlMauMatSo(mms.getId(),mms.getMa(),mms.getTen()));
            }
            return listMms;
        } catch (Exception e) {
        }
        return null;
    }
    @Override
    public Integer addMmss(QlMauMatSo mms){
        try {
            return iMauMatSoRepo.addMms(new MauMatSo(mms.getId(),mms.getMa(),mms.getTen()));
        } catch (Exception e) {
        }
        return null;
    }
    @Override
    public Integer updateMmss(QlMauMatSo mms){
        try {
            return iMauMatSoRepo.updateMms(new MauMatSo(mms.getId(),mms.getMa(),mms.getTen()));
        } catch (Exception e) {
        }
        return null;
    }
    @Override
    public Integer deleteMmss(String ma){
        try {
            return iMauMatSoRepo.deleteMms(ma);
        } catch (Exception e) {
        }
        return null;
    }
}
