/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.MauVo;
import java.util.ArrayList;


/**
 *
 * @author Acer
 */
public interface MauVoSer {
    ArrayList<MauVo> getView();
    
    Boolean checkMa(String Ma);
    
    String add(MauVo mau);

    String delete(String mau);
    
    String update(MauVo mau);
    
}
