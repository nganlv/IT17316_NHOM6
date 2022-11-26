/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author nguye
 */
public class QuanLyTaiKhoan {
    private String id;
    private String ma;
    private String ten;
    private String matkhau;

    public QuanLyTaiKhoan() {
    }

    public QuanLyTaiKhoan(String id, String ma, String ten, String matkhau) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.matkhau = matkhau;
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

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
    
}

