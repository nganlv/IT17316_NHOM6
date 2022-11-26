/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.XuatXu;
import Repository.Interface.IXuatXuRepo;
import Repository.XuatXuRepo;
import Service.Interface.IXuatXuSer;
import ViewModels.QlXuatXu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class XuatXuService implements IXuatXuSer{
    private final IXuatXuRepo iXuatXuRepo=new XuatXuRepo();
    @Override
    public List<QlXuatXu> getAllXxs(){
        try {
            List<QlXuatXu> listXx=new ArrayList<>();
            for(XuatXu xx: iXuatXuRepo.getAllXx()){
                listXx.add(new QlXuatXu(xx.getId(), xx.getMa(), xx.getTen()));
            }
            return listXx;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Integer addXxs(QlXuatXu xx){
        try {
            return iXuatXuRepo.addXx(new XuatXu(xx.getId(), xx.getMa(), xx.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Integer updateXxs(QlXuatXu xx){
        try {
            return iXuatXuRepo.updateXx(new XuatXu(xx.getId(), xx.getMa(), xx.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Integer deleteXxs(String ma){
        try {
            return iXuatXuRepo.deleteXx(ma);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
