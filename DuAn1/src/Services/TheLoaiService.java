/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.TheLoai;
import Repository.Interface.ITheLoaiRepo;
import Repository.TheLoaiRepo;
import Service.Interface.ITheLoaiSer;
import ViewModels.QlTheLoai;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class TheLoaiService implements ITheLoaiSer{
    private final ITheLoaiRepo iTheLoaiRepo=new TheLoaiRepo();
    @Override
    public List<QlTheLoai> getAllTls(){
        try {
            List<QlTheLoai> listTl=new ArrayList<>();
        for(TheLoai tl:iTheLoaiRepo.getAllTl()){
            listTl.add(new QlTheLoai(tl.getId(), tl.getMa(), tl.getTen()));
        }
        return listTl;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Integer addTls(QlTheLoai tl){
        try {
            return iTheLoaiRepo.addTl(new TheLoai(tl.getId(), tl.getMa(), tl.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Integer updateTls(QlTheLoai tl){
        try {
            return iTheLoaiRepo.updateTl(new TheLoai(tl.getId(), tl.getMa(), tl.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Integer deleteTls(String ma){
        try {
            return iTheLoaiRepo.deleteTl(ma);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
