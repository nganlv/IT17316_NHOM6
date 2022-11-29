/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;

/**
 *
 * @author levan
 */
public class QLSanPham_BanHang {
    private String ma, ten;
    private double donGia, giamGia;
    private String hinhDangMat, chatLieuMat, kichThuoc, mauVo, theLoai, gioiTinh, kieuMay;
    private int soLuong;

    public QLSanPham_BanHang() {
    }

    public QLSanPham_BanHang(String ma, String ten, double donGia, double giamGia, String hinhDangMat, String chatLieuMat, String kichThuoc, String mauVo, String theLoai, String gioiTinh, String kieuMay, int soLuong) {
        this.ma = ma;
        this.ten = ten;
        this.donGia = donGia;
        this.giamGia = giamGia;
        this.hinhDangMat = hinhDangMat;
        this.chatLieuMat = chatLieuMat;
        this.kichThuoc = kichThuoc;
        this.mauVo = mauVo;
        this.theLoai = theLoai;
        this.gioiTinh = gioiTinh;
        this.kieuMay = kieuMay;
        this.soLuong = soLuong;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public String getHinhDangMat() {
        return hinhDangMat;
    }

    public void setHinhDangMat(String hinhDangMat) {
        this.hinhDangMat = hinhDangMat;
    }

    public String getChatLieuMat() {
        return chatLieuMat;
    }

    public void setChatLieuMat(String chatLieuMat) {
        this.chatLieuMat = chatLieuMat;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getMauVo() {
        return mauVo;
    }

    public void setMauVo(String mauVo) {
        this.mauVo = mauVo;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getKieuMay() {
        return kieuMay;
    }

    public void setKieuMay(String kieuMay) {
        this.kieuMay = kieuMay;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
   
}
