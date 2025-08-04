/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.controller;

import fis.poo.cinemalayout.model.entities.Client;
import fis.poo.cinemalayout.model.services.CinemaManager;
import fis.poo.cinemalayout.model.services.PersonManager;
import fis.poo.cinemalayout.model.services.Verificator;
import fis.poo.cinemalayout.view.AdminPanel;
import fis.poo.cinemalayout.view.Loginoptions;
import fis.poo.cinemalayout.view.MainLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author jordy
 */
public class LController implements ActionListener{
    private Loginoptions lgn; 
    private Verificator vrf;
    private MainLayout ml; 
    private MLController mlc; 
    private CinemaManager cnm;
    private PersonManager prm;
    private AdminPanel adm;
    private Client client; 
    private String secret = "RR1717160533";
    
    public LController(Loginoptions lgn, AdminPanel adm, MainLayout ml, MLController mlc) {
        this.lgn = lgn;
        this.mlc = mlc; 
        this.ml = ml; 
        this.adm = adm;
        lgn.signB.addActionListener(this);
        lgn.lognB.addActionListener(this);
        lgn.cnclB.addActionListener(this);
        lgn.hiddenB.addActionListener(this);
        lgn.loginB.addActionListener(this);
        lgn.signin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        Object sr = ev.getSource(); 
        if(lgn.isActive()){
            if(sr==lgn.signB){
                lgn.setVisible(false);
                lgn.signinF.setVisible(true);
            } else if(sr==lgn.lognB){
                lgn.maiIn.setVisible(true);
            } else if(sr==lgn.hiddenB){
                String pss = JOptionPane.showInputDialog(null, "Enter the secret Password:"); 
                if(pss.equals(secret)){
                    lgn.setVisible(false);
                    adm.setVisible(false);
                } else{
                    JOptionPane.showConfirmDialog(null, "INVALID PASSWORD!", "ALERT", JOptionPane.ERROR_MESSAGE);
                    lgn.setVisible(false);
                }
            }
        }
        
        if(lgn.signinF.isActive()){
            if(sr == lgn.cnclB){
                lgn.clear(); 
                lgn.signinF.setVisible(false);
                lgn.setVisible(true);
            } else if(sr == lgn.signin){
                if(lgn.conditions()){
                    prm.registerClient(lgn.unTxt.getText(), lgn.nTxt.getText(), lgn.lnTxt.getText(), lgn.pwTxt.getText(), lgn.mTxt.getText(), Integer.parseInt(lgn.idTxt.getText()));
                } else{
                    JOptionPane.showMessageDialog(null, "Incompatible data. Please, try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    lgn.clear();
                }
            }
        }
        
        if(lgn.maiIn.isEnabled()){
            if(sr == lgn.loginB){
                String uN = lgn.userIn.getText();
                String pW = lgn.psw.getText();
                if(vrf.verifier("client", uN, pW)){
                    JOptionPane.showMessageDialog(null, "Welcome Back!", "Policinema", JOptionPane.OK_OPTION);
                    mlc.setCln(prm.clients().get(vrf.getPosition())); 
                    mlc.setIsLoged(true);
                    lgn.maiIn.setVisible(false);
                    lgn.setVisible(false);
                    ml.setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    lgn.clear();
                }
                
            }
        }
        
    }
    
    
    
}
