/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.math.BigDecimal;

/**
 *
 * @author levan
 */
public class HoaDonChiTiet {

    private String maSp, tenSp;
    private double donGia, giamGia;
    private int soLuong;
    private double thanhTien;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maSp, String tenSp, double donGia, double giamGia, int soLuong, double thanhTien) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.donGia = donGia;
        this.giamGia = giamGia;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    
    
}
