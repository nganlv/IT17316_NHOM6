/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import ViewModels.QuanLyCTSP;
import DomainModels.CTSP;
import Repository.ChiTietSP;
import Services.IChiTietSPSV;
import java.util.*;
import java.sql.*;

/**
 *
 * @author pc
 */
public class ChiTietSPSV implements IChiTietSPSV {

    private final ChiTietSP repo = new ChiTietSP();

    @Override
    public List<QuanLyCTSP> layDS() {
   List<QuanLyCTSP>dssp= new ArrayList<>();
        for (CTSP sp : repo.getAll()) {
            dssp.add(new QuanLyCTSP(sp.getId(),sp.getIdkm(), sp.getIdsp(), sp.getIdthuonghieu(),sp.getIdxuaxu(), sp.getIdtheloai(),sp.getIdchatlieuday(), sp.getIdmaumatso(),sp.getIdmauvo(), 
                    sp.getIdphukien(),sp.getIdtinhnang(), sp.getHinhdangmatso(),sp.getChatlieumatkinh(), sp.getGioitinh(), sp.getKieumay(),sp.getKichthuoc(), sp.getSoluongton(), sp.getTinhtrang(),sp.getDongia(), sp.getNambh()));
        }
        return dssp;

    }
    
  @Override
  public void them(QuanLyCTSP sp){
      try {
          repo.themDL(new CTSP(sp.getId(),sp.getIdkm(), sp.getIdsp(), sp.getIdthuonghieu(),sp.getIdxuaxu(), sp.getIdtheloai(),sp.getIdchatlieuday(), sp.getIdmaumatso(),sp.getIdmauvo(), 
                    sp.getIdphukien(),sp.getIdtinhnang(), sp.getHinhdangmatso(),sp.getChatlieumatkinh(), sp.getGioitinh(), sp.getKieumay(),sp.getKichthuoc(), sp.getSoluongton(), sp.getTinhtrang(),sp.getDongia(), sp.getNambh()));
      } catch (Exception e) {
          System.out.println("lỗi thêm "+e.getMessage());
      }
  
  }
  @Override
  public void sua(QuanLyCTSP sp){
      try {
          repo.suaDL(new CTSP(sp.getId(),sp.getIdkm(), sp.getIdsp(), sp.getIdthuonghieu(),sp.getIdxuaxu(), sp.getIdtheloai(),sp.getIdchatlieuday(), sp.getIdmaumatso(),sp.getIdmauvo(), 
                    sp.getIdphukien(),sp.getIdtinhnang(), sp.getHinhdangmatso(),sp.getChatlieumatkinh(), sp.getGioitinh(), sp.getKieumay(),sp.getKichthuoc(), sp.getSoluongton(), sp.getTinhtrang(),sp.getDongia(), sp.getNambh()));
      } catch (Exception e) {
          System.out.println("lỗi sửa "+e.getMessage());
      }
  
  }
  @Override
  public void xoa(String ma){
      try {
          repo.xoaDL(ma);
      } catch (Exception e) {
          System.out.println("lỗi xoa "+e.getMessage());
      }
  
  }
//  @Override
//  public   List<QLChiTietSanPham> tim(String ma){
//             List<QLChiTietSanPham> dsct = new ArrayList<>();
//        for (ChiTietSanPham ct : repo.tim(ma)) {
//   dsct.add(new QLChiTietSanPham(ct.getId(), ct.getMoTa(),ct.getMs(), ct.getSoLgTon(), ct.getGiaNhap(), ct.getGiaBan()));
//   
//        }
//        return dsct;
//  
//  }
}
