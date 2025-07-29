/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.controller;

import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.view.CashierPanel;
import fis.poo.cinemalayout.view.MainLayout;
import fis.poo.cinemalayout.view.SeatsSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JToggleButton;

/**
 *
 * @author jordy
 */
public class SMainController implements ActionListener{
    
    private Function fn;
    private MainLayout mn; 
    private CashierPanel csp;
    private SeatsSelection st;
    private int counter = 0;
    private boolean isCashier;
    private boolean isClient;

    public SMainController(Function fn, SeatsSelection st) {
        this.fn = fn;
        this.st = st;
        this.st.aceptB.addActionListener(this);
        this.st.A1.addActionListener(this);
        this.st.A2.addActionListener(this);
        this.st.A3.addActionListener(this);
        this.st.A4.addActionListener(this);
        this.st.A5.addActionListener(this);
        this.st.A6.addActionListener(this);
        this.st.A7.addActionListener(this);
        this.st.A8.addActionListener(this);
        this.st.A9.addActionListener(this);
        this.st.A10.addActionListener(this);
        this.st.A11.addActionListener(this);
        this.st.A12.addActionListener(this);
        this.st.B1.addActionListener(this);
        this.st.B2.addActionListener(this);
        this.st.B3.addActionListener(this);
        this.st.B4.addActionListener(this);
        this.st.B5.addActionListener(this);
        this.st.B6.addActionListener(this);
        this.st.B7.addActionListener(this);
        this.st.B8.addActionListener(this);
        this.st.B9.addActionListener(this);
        this.st.B10.addActionListener(this);
        this.st.B11.addActionListener(this);
        this.st.B12.addActionListener(this);
        this.st.C1.addActionListener(this);
        this.st.C2.addActionListener(this);
        this.st.C3.addActionListener(this);
        this.st.C4.addActionListener(this);
        this.st.C5.addActionListener(this);
        this.st.C6.addActionListener(this);
        this.st.C7.addActionListener(this);
        this.st.C8.addActionListener(this);
        this.st.C9.addActionListener(this);
        this.st.C10.addActionListener(this);
        this.st.C11.addActionListener(this);
        this.st.C12.addActionListener(this);
        this.st.D1.addActionListener(this);
        this.st.D2.addActionListener(this);
        this.st.D3.addActionListener(this);
        this.st.D4.addActionListener(this);
        this.st.D5.addActionListener(this);
        this.st.D6.addActionListener(this);
        this.st.D7.addActionListener(this);
        this.st.D8.addActionListener(this);
        this.st.D9.addActionListener(this);
        this.st.D10.addActionListener(this);
        this.st.D11.addActionListener(this);
        this.st.D12.addActionListener(this);
        this.st.E1.addActionListener(this);
        this.st.E2.addActionListener(this);
        this.st.E3.addActionListener(this);
        this.st.E4.addActionListener(this);
        this.st.E5.addActionListener(this);
        this.st.E6.addActionListener(this);
        this.st.E7.addActionListener(this);
        this.st.E8.addActionListener(this);
        this.st.E9.addActionListener(this);
        this.st.E10.addActionListener(this);
        this.st.E11.addActionListener(this);
        this.st.E12.addActionListener(this);
        this.st.F1.addActionListener(this);
        this.st.F2.addActionListener(this);
        this.st.F3.addActionListener(this);
        this.st.F4.addActionListener(this);
        this.st.F5.addActionListener(this);
        this.st.F6.addActionListener(this);
        this.st.F7.addActionListener(this);
        this.st.F8.addActionListener(this);
        this.st.F9.addActionListener(this);
        this.st.F10.addActionListener(this);
        this.st.F11.addActionListener(this);
        this.st.F12.addActionListener(this);
    }

    public ArrayList<JToggleButton> getSel() {
        return sel;
    }

    public SeatsSelection getSt() {
        return st;
    }
    public int getCounter() {
        return counter;
    }
    public void setIsCashier(boolean isCashier) {
        this.isCashier = isCashier;
    }

    public void setIsClient(boolean isClient) {
        this.isClient = isClient;
    }
    
    private ArrayList<JToggleButton> sel;
    
    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource() == st.A1){
                addB(st.A1);
            } else if(ev.getSource() == st.A2){
                addB(st.A2);
            } else if(ev.getSource() == st.A3){
                addB(st.A3);
            }else if(ev.getSource() == st.A4){
                addB(st.A4);
            }else if(ev.getSource() == st.A5){
                addB(st.A5);
            }else if(ev.getSource() == st.A6){
                addB(st.A6);
            }else if(ev.getSource() == st.A7){
                addB(st.A7);
            }else if(ev.getSource() == st.A8){
                addB(st.A8);
            }else if(ev.getSource() == st.A9){
                addB(st.A9);
            }else if(ev.getSource() == st.A10){
                addB(st.A10);
            }else if(ev.getSource() == st.A11){
                addB(st.A11);
            }else if(ev.getSource() == st.A12){
                addB(st.A12);
            }else if(ev.getSource() == st.B1){
                addB(st.B1);
            }else if(ev.getSource() == st.B2){
                addB(st.B2);
            }else if(ev.getSource() == st.B3){
                addB(st.B3);
            }else if(ev.getSource() == st.B4){
                addB(st.B4);
            }else if(ev.getSource() == st.B5){
                addB(st.B5);
            }else if(ev.getSource() == st.B6){
                addB(st.B6);
            }else if(ev.getSource() == st.B7){
                addB(st.B7);
            }else if(ev.getSource() == st.B8){
                addB(st.B8);
            }else if(ev.getSource() == st.B9){
                addB(st.B9);
            }else if(ev.getSource() == st.B10){
                addB(st.B10);
            }else if(ev.getSource() == st.B11){
                addB(st.B11);
            }else if(ev.getSource() == st.B12){
                addB(st.B12);
            }else if(ev.getSource() == st.C1){
                addB(st.C1);
            }else if(ev.getSource() == st.C2){
                addB(st.C2);
            }else if(ev.getSource() == st.C3){
                addB(st.C3);
            }else if(ev.getSource() == st.C4){
                addB(st.C4);
            }else if(ev.getSource() == st.C5){
                addB(st.C5);
            }else if(ev.getSource() == st.C6){
                addB(st.C6);
            }else if(ev.getSource() == st.C7){
                addB(st.C7);
            }else if(ev.getSource() == st.C8){
                addB(st.C8);
            }else if(ev.getSource() == st.C9){
                addB(st.C9);
            }else if(ev.getSource() == st.C10){
                addB(st.C10);
            }else if(ev.getSource() == st.C11){
                addB(st.C11);
            }else if(ev.getSource() == st.C12){
                addB(st.C12);
            }else if(ev.getSource() == st.D1){
                addB(st.D1);
            }else if(ev.getSource() == st.D2){
                addB(st.D2);
            }else if(ev.getSource() == st.D3){
                addB(st.D3);
            }else if(ev.getSource() == st.D4){
                addB(st.D4);
            }else if(ev.getSource() == st.D5){
                addB(st.D5);
            }else if(ev.getSource() == st.D6){
                addB(st.D6);
            }else if(ev.getSource() == st.D7){
                addB(st.D7);
            }else if(ev.getSource() == st.D8){
                addB(st.D8);
            }else if(ev.getSource() == st.D9){
                addB(st.D9);
            }else if(ev.getSource() == st.D10){
                addB(st.D10);
            }else if(ev.getSource() == st.D11){
                addB(st.D11);
            }else if(ev.getSource() == st.D12){
                addB(st.D12);
            }else if(ev.getSource() == st.E1){
                addB(st.E1);
            }else if(ev.getSource() == st.E2){
                addB(st.E2);
            }else if(ev.getSource() == st.E3){
                addB(st.E3);
            }else if(ev.getSource() == st.E4){
                addB(st.E4);
            }else if(ev.getSource() == st.E5){
                addB(st.E5);
            }else if(ev.getSource() == st.E6){
                addB(st.E6);
            }else if(ev.getSource() == st.E7){
                addB(st.E7);
            }else if(ev.getSource() == st.E8){
                addB(st.E8);
            }else if(ev.getSource() == st.E9){
                addB(st.E9);
            }else if(ev.getSource() == st.E10){
                addB(st.E10);
            }else if(ev.getSource() == st.E11){
                addB(st.E11);
            }else if(ev.getSource() == st.E12){
                addB(st.E12);
            }else if(ev.getSource() == st.F1){
                addB(st.F1);
            }else if(ev.getSource() == st.F2){
                addB(st.F2);
            }else if(ev.getSource() == st.F3){
                addB(st.F3);
            }else if(ev.getSource() == st.F4){
                addB(st.F4);
            }else if(ev.getSource() == st.F5){
                addB(st.F5);
            }else if(ev.getSource() == st.F6){
                addB(st.F6);
            }else if(ev.getSource() == st.F7){
                addB(st.F7);
            }else if(ev.getSource() == st.F8){
                addB(st.F8);
            }else if(ev.getSource() == st.F9){
                addB(st.F9);
            }else if(ev.getSource() == st.F10){
                addB(st.F10);
            }else if(ev.getSource() == st.F11){
                addB(st.F11);
            }else if(ev.getSource() == st.F12){
                addB(st.F12);
        }
            
        if(ev.getSource() == st.aceptB){
            
            for(JToggleButton button : sel){
                button.setEnabled(false);
            }
            
            if(isCashier){
                csp.setVisible(true);
                st.setVisible(false);
                
            }else if(isClient){
                mn.FinalSel.setVisible(true);
                st.setVisible(false);
            }
        }
        
        if(ev.getSource() == st.cancelB1){
            sel.clear();
            counter = 0; 
            st.displayS.setText("");
            
            if(isCashier){
                csp.setVisible(true);
                st.setVisible(false);
                
            }else if(isClient){
                mn.setVisible(true);
                st.setVisible(false);
            }
        }
    }
    
    private void addB(JToggleButton b){
        counter++;
        st.show(counter);
        sel.add(b);
    }
    
    
}
