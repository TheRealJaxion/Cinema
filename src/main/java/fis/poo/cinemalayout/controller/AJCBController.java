/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.controller;

import fis.poo.cinemalayout.view.AdminPanel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author jordy
 */
public class AJCBController implements ItemListener{
    private AdminPanel adm; 

    public AJCBController(AdminPanel adm) {
        this.adm = adm;
        adm.hallSet.addItemListener(this);
        adm.scheduleSel.addItemListener(this);
        adm.numH.addItemListener(this);
    }
    
    
    @Override
    public void itemStateChanged(ItemEvent ie) {
        if(adm.hallSet.isShowing()){
            if(ie.getStateChange() == ItemEvent.SELECTED){
                String hall = (String) ie.getItem();
                
                if(hall.equals("Normal Hall")){
                    if(adm.numH.getItemCount() != 0){
                        adm.numH.removeAllItems();
                    }
                    adm.numH.addItem("1");
                    adm.numH.addItem("2");
                    adm.numH.addItem("3");
                    adm.numH.addItem("4");
                    adm.numH.addItem("5");
                    adm.numH.addItem("6");
                } else if(hall.equals("IMAX")){
                    if(adm.numH.getItemCount() != 0){
                        adm.numH.removeAllItems();
                    }
                    adm.numH.addItem("1");
                    adm.numH.addItem("2");
                }
            }  
                
        }
    }
    
}
