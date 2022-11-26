/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.util.Date;

/**
 *
 * @author nguye
 */
public class NhanVien {
     private String id;
   private String ma;
   private String ten;
   private String gioitinh;
   private Date ngaysinh;
   private String sdt;
   private String diachi;
   private String email;
   private String idtk;
   private String idcv;
   private int trangthai;

    public NhanVien() {
    }

    public NhanVien(String id, String ma, String ten, String gioitinh, Date ngaysinh, String sdt, String diachi, String email, String idtk, String idcv, int trangthai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.diachi = diachi;
        this.email = email;
        this.idtk = idtk;
        this.idcv = idcv;
        this.trangthai = trangthai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdtk() {
        return idtk;
    }

    public void setIdtk(String idtk) {
        this.idtk = idtk;
    }

    public String getIdcv() {
        return idcv;
    }

    public void setIdcv(String idcv) {
        this.idcv = idcv;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
   
}
