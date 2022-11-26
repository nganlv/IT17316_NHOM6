/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ThuongHieu;
import Repository.Interface.IThuongHieuRepo;
import Repository.ThuongHieuRepo;
import Service.Interface.IThuongHieuSer;
import ViewModels.QlThuongHieu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class ThuongHieuService implements IThuongHieuSer {

    private final IThuongHieuRepo iThuongHieuRepo = new ThuongHieuRepo();

    @Override
    public List<QlThuongHieu> getAllThs() {
        try {
            List<QlThuongHieu> listTh = new ArrayList<>();
            for (ThuongHieu th : iThuongHieuRepo.getAllTh()) {
                listTh.add(new QlThuongHieu(th.getId(), th.getMa(), th.getTen()));
            }
            return listTh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addThs(QlThuongHieu th) {
        try {
            return iThuongHieuRepo.addTh(new ThuongHieu(th.getId(), th.getMa(), th.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateThs(QlThuongHieu th) {
        try {
            return iThuongHieuRepo.updateTh(new ThuongHieu(th.getId(), th.getMa(), th.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer deleteThs(String ma) {
        try {
            return iThuongHieuRepo.deleteTh(ma);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
