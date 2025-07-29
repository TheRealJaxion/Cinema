/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.controller;

import fis.poo.cinemalayout.view.AdminPanel;
import fis.poo.cinemalayout.view.CashierPanel;
import fis.poo.cinemalayout.view.HiddenView;
import fis.poo.cinemalayout.view.Loginoptions;
import fis.poo.cinemalayout.view.MainLayout;
import fis.poo.cinemalayout.view.SeatsSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jordy
 */
public class BController implements ActionListener {
    private AdminPanel adm;
    private CashierPanel csh;
    private HiddenView hdn;
    private Loginoptions lgn;
    private MainLayout ml;
    private SeatsSelection st;

    public BController(AdminPanel adm, CashierPanel csh, HiddenView hdn, Loginoptions lgn, MainLayout ml, SeatsSelection st) {
        this.adm = adm;
        this.csh = csh;
        this.hdn = hdn;
        this.lgn = lgn;
        this.ml = ml;
        this.st = st;
        
        
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
