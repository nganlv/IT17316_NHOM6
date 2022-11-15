/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.math.BigDecimal;

/**
 *
 * @author pc
 */
public class ThongKe {
    private String MaSP, TenSP, ngay;
    private int SoLuong;
    private Double Dongia, ThanhTien;

    public ThongKe() {
    }
    
    public ThongKe(String MaSP, String TenSP, String ngay, int SoLuong, Double Dongia, Double ThanhTien) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.ngay = ngay;
        this.SoLuong = SoLuong;
        this.Dongia = Dongia;
        this.ThanhTien = ThanhTien;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Double getDongia() {
        return Dongia;
    }

    public void setDongia(Double Dongia) {
        this.Dongia = Dongia;
    }

    public Double getThanhTien() {
        return SoLuong * Dongia;
    }

    public void setThanhTien(Double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
    
}
