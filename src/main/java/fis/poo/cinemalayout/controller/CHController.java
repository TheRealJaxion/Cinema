/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.controller;

import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Recipe;
import fis.poo.cinemalayout.model.entities.Reservation;
import fis.poo.cinemalayout.model.services.CashierReserv;
import fis.poo.cinemalayout.model.services.CinemaManager;
import fis.poo.cinemalayout.view.AdminPanel;
import fis.poo.cinemalayout.view.CashierPanel;
import fis.poo.cinemalayout.view.SeatsSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author jordy
 */
public class CHController implements ActionListener{
    private CinemaManager cnm;
    private Reservation rsr = new Reservation();
    private Recipe rcp;
    private AdminPanel adm;
    private SeatsSelection stl;
    private CashierReserv chr;
    private SeatController stc; 
    private APController ap;
    private CashierPanel cshp;

    public CHController(Reservation rsr, Recipe rcp, AdminPanel adm, SeatsSelection stl, CashierPanel cshp) {
        this.rsr = rsr;
        this.cshp = cshp;
        this.rcp = rcp;
        this.stl = stl; 
        this.adm = adm;
        chr = new CashierReserv(rsr.getFunction(), stc, stl, rsr);
        for(JButton btn : cshp.buttons()){
            btn.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        Object sr = ev.getSource();
        if(sr == cshp.seatSB){
            String sel = (String) cshp.functionCB.getSelectedItem(); 
            if(sel.isBlank() || sel.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please, select a function first", "Cashier Panel", JOptionPane.OK_OPTION);
            } else{
                ArrayList<Function> fns = cnm.functions();
                for(Function fn : fns){
                    if(sel.equals(fn.getFunctionId())){
                        rsr.setFunction(fn);
                        break;
                    }
                }
                chr = new CashierReserv(rsr.getFunction(), stc, stl, rsr);
                stl.setVisible(true);
            }
        }
        
        if(sr == cshp.addB){
            if(cshp.isEmpty() || stc.getCounter() == 0){
                JOptionPane.showMessageDialog(null, "Invalid Statements!", "Cashier Panel", JOptionPane.ERROR);
                cshp.clear();
            } else{
                rcp.setClientId(cshp.clientID.getText());
                rcp.setClientName(cshp.clientNames.getText());
                chr.markSeats();
                rcp.setRes(rsr);
                cshp.displayC.setText(rcp.displayRecipe());
            }
        }
        
        if(sr == cshp.cancelB){
            cshp.clear();
            stc.clean();
            cshp.displayC.setText("");
        }
        
        if(sr == cshp.payB){
            
        }
        
        if(sr == cshp.logOut){
            if(JOptionPane.showConfirmDialog(null, "Are you sure to finish this shift?", "Cashier Panel", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                cshp.clear();
                adm.setVisible(true);
                cshp.setVisible(false);
            }
        }
    }
    
    
     
}
