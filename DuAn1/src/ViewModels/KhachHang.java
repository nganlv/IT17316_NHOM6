/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;



/**
 *
 * @author Acer
 */
public class KhachHang {
    
    private String maKH, hoTen, gioiTinh, sdt, diaChi, email, diem;
    private String ngaysinh, ngayTao, ngayHetHan;

    public KhachHang() {
    }

    public KhachHang(String maKH, String hoTen, String gioiTinh, String sdt, String diaChi, String email, String diem, String ngaysinh, String ngayTao, String ngayHetHan) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.email = email;
        this.diem = diem;
        this.ngaysinh = ngaysinh;
        this.ngayTao = ngayTao;
        this.ngayHetHan = ngayHetHan;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKH=" + maKH + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", sdt=" + sdt + ", diaChi=" + diaChi + ", email=" + email + ", diem=" + diem + ", ngaysinh=" + ngaysinh + ", ngayTao=" + ngayTao + ", ngayHetHan=" + ngayHetHan + '}';
    }

    

}
