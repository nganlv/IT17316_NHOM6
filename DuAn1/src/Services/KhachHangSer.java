/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.KhachHang;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public interface KhachHangSer {

    ArrayList<KhachHang> getView();

    Boolean checkMa(String maTk);

    String add(KhachHang kH);

    String delete(String KH);
    
    String update(KhachHang Kh);
}
