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
public class QlChiTietSanPham {
    private String ma, ten, thuongHieu, xuatXu, gioiTinh, kieuMay, theLoai, phuKien, tinhNang, hinhDangMat, chatLieuMat,
            chatLieuDay, mauMat, mauVo, kichThuoc, donGia;
    private int namBh, soLuong, tinhTrang;

    public QlChiTietSanPham() {
    }

    public QlChiTietSanPham(String ma, String ten, String thuongHieu, String xuatXu, String gioiTinh, String kieuMay, String theLoai, String phuKien, String tinhNang, String hinhDangMat, String chatLieuMat, String chatLieuDay, String mauMat, String mauVo, String kichThuoc, String donGia, int namBh, int soLuong, int tinhTrang) {
        this.ma = ma;
        this.ten = ten;
        this.thuongHieu = thuongHieu;
        this.xuatXu = xuatXu;
        this.gioiTinh = gioiTinh;
        this.kieuMay = kieuMay;
        this.theLoai = theLoai;
        this.phuKien = phuKien;
        this.tinhNang = tinhNang;
        this.hinhDangMat = hinhDangMat;
        this.chatLieuMat = chatLieuMat;
        this.chatLieuDay = chatLieuDay;
        this.mauMat = mauMat;
        this.mauVo = mauVo;
        this.kichThuoc = kichThuoc;
        this.donGia = donGia;
        this.namBh = namBh;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
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

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
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

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getPhuKien() {
        return phuKien;
    }

    public void setPhuKien(String phuKien) {
        this.phuKien = phuKien;
    }

    public String getTinhNang() {
        return tinhNang;
    }

    public void setTinhNang(String tinhNang) {
        this.tinhNang = tinhNang;
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

    public String getChatLieuDay() {
        return chatLieuDay;
    }

    public void setChatLieuDay(String chatLieuDay) {
        this.chatLieuDay = chatLieuDay;
    }

    public String getMauMat() {
        return mauMat;
    }

    public void setMauMat(String mauMat) {
        this.mauMat = mauMat;
    }

    public String getMauVo() {
        return mauVo;
    }

    public void setMauVo(String mauVo) {
        this.mauVo = mauVo;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public int getNamBh() {
        return namBh;
    }

    public void setNamBh(int namBh) {
        this.namBh = namBh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String tinhTrange() {
        if (tinhTrang == 0) {
            return "Còn kinh doanh";
        } else {
            return "Ngừng kinh doanh";
        }
    }
}
