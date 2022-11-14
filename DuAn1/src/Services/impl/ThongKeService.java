/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.ThongKe;
import Services.IThongKeSV;
import Repository.ThongKeRepo;
import ViewModels.QuanLyThongKe;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class ThongKeService implements IThongKeSV {

    private final ThongKeRepo iTKRepo = new ThongKeRepo();

    @Override
    public List<QuanLyThongKe> getAll() {
        try {
            List<QuanLyThongKe> listKh = new ArrayList<>();
            for (ThongKe kh : iTKRepo.getAll()) {
                listKh.add(new QuanLyThongKe(kh.getMaSP(), kh.getTenSP(), kh.getNgay(), kh.getSoLuong(),
                        kh.getDongia(), kh.getThanhTien()));
            }
            return listKh;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public List<QuanLyThongKe> tim(String ma) {
        try {
            List<QuanLyThongKe> listKh = new ArrayList<>();
            for (ThongKe kh : iTKRepo.tim(ma)) {
                listKh.add(new QuanLyThongKe(kh.getMaSP(), kh.getTenSP(), kh.getNgay(), kh.getSoLuong(),
                        kh.getDongia(), kh.getThanhTien()));
            }
            return listKh;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

}
