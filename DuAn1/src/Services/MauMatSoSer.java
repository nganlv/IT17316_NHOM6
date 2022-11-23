/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.MauMatSo;
import java.util.ArrayList;


/**
 *
 * @author Acer
 */
public interface MauMatSoSer {
    ArrayList<MauMatSo> getView();
    
    Boolean checkMa(String Ma);
    
    String add(MauMatSo mau);

    String delete(String mau);
    
    String update(MauMatSo mau);
    
}
