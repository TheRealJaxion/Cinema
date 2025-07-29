/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.controller;

import fis.poo.cinemalayout.view.AdminPanel;
import fis.poo.cinemalayout.view.CashierPanel;
import fis.poo.cinemalayout.view.HiddenView;
import fis.poo.cinemalayout.view.SeatsSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jordy
 */
public class HController implements ActionListener{
    private AdminPanel adm;
    private CashierPanel csh;
    private HiddenView hdn; 

    public HController(AdminPanel adm, CashierPanel csh, HiddenView hdn) {
        this.adm = adm;
        this.csh = csh;
        this.hdn = hdn;
        this.hdn.hiddenAdm.addActionListener(this);
        this.hdn.hiddenCash.addActionListener(this);
    }    
    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource() == hdn.hiddenCash){
            csh.setVisible(true);
            hdn.setVisible(false);
        } else if(ev.getSource() == hdn.hiddenAdm){
            hdn.setVisible(false);
            adm.setVisible(true);  
        }
    }
    
    
    
}
