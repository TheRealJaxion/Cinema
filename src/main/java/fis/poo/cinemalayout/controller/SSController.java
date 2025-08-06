/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.controller;

import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Movie;
import fis.poo.cinemalayout.model.entities.Reservation;
import fis.poo.cinemalayout.view.CashierPanel;
import fis.poo.cinemalayout.view.MainLayout;
import fis.poo.cinemalayout.view.SeatsSelection;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

/**
 *
 * @author jordy
 */
public class SSController implements ActionListener {
    private Movie mv; 
    private Function fn;
    private int counter = 0;
    private int c =0;
    private SeatsSelection sts;
    private JFrame fr;
    private boolean isClient = false;
    private boolean isCashier = false;
    private ArrayList<JToggleButton> locks = new ArrayList<>();

    public void setFr(JFrame fr) {
        this.fr = fr;
    }
    
    public void setMv(Movie mv) {
        this.mv = mv;
    }

    public void setFn(Function fn) {
        this.fn = fn;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    
    public int getCounter() {
        return c;
    }
    
    public Function getFunction(){
        return fn;
    }

    public void setSts(SeatsSelection sts) {
        this.sts = sts;
    }
    
    public SSController(JFrame fr, Movie mv, Function fn, String person, SeatsSelection sts) {
        this.sts = sts;
        this.fr = fr;
        this.mv = mv;
        this.fn = fn;
        if(fn != null){
            sts.displayMN.setText(mv.getNameM());
            String hall;
            if(fn.getHall() == 'N'){
                hall = "Hall";
            } else{
                hall = "IMAX";
            }
            sts.displayH.setText(hall + fn.getNhall());
            sts.displayH1.setText(fn.getSchedule());
            for(JToggleButton btn : sts.seats()){
                btn.addActionListener(this);
            }
            
            if(person.equals("Cashier")){
                this.isClient = false;
                this.isCashier = true;
            } else{
                this.isClient = true;
                this.isCashier = false;
            }
            
            sts.aceptB.addActionListener(this);
            sts.cancelB1.addActionListener(this);
            sts.setVisible(true);
            sts.setLocationRelativeTo(null);
            
        } else{
            JOptionPane.showMessageDialog(fr,"There was a problem at SSController!", "Warning!", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    @Override
    public void actionPerformed(ActionEvent ev) {
        Object sr = ev.getSource();
        if(sr == sts.aceptB){
            
            int op = JOptionPane.showConfirmDialog(sts, "Are you sure to reserve this seats?", "Policinema", JOptionPane.YES_NO_OPTION);
            if(op == 0){
                
                c = counter;
                
                clean();
                
                sts.setVisible(false);
                if(!locks.isEmpty()){
                    lockSeats();
                }
                fr.setVisible(true);
                fr.setLocationRelativeTo(null);
            }
        } else if(sr == sts.cancelB1){
            clear();
            fr.setVisible(true);
            sts.setVisible(false);
            fr.setLocationRelativeTo(null);
        } else{
            for(JToggleButton btn : sts.seats()){
                if(sr == btn){
                    if(!check(locks, btn)){
                        locks.add(btn);
                        counter++;
                        sts.displayS.setText(Integer.toString(counter));
                    } else{
                        counter --;
                        sts.displayS.setText(Integer.toString(counter));
                        remove(btn);
                    }
                    break;
                }
            }
        }
    }
    
    public void lockSeats(){
        for(JToggleButton bnt : locks){
            bnt.hide();
        }
    }
    
    public void clear(){
        locks.clear();
        counter = 0;
        sts.displayS.setText("");
    }
    
    public void clean(){
        counter =0;
        sts.displayS.setText("");
    }
    
    public boolean check(ArrayList<JToggleButton> btns, JToggleButton bt){
        if(!btns.isEmpty()){
            for(JToggleButton btn : btns){
                if(btn.equals(bt)){
                    return true;
                }
            }
        } 
        return false; 
    }
    
    public void remove(JToggleButton btn){
        if(!locks.isEmpty()){
            for(int i=0; i<locks.size(); i++){
                if(btn.equals(locks.get(i))){
                    locks.remove(btn);
                }
            }
        }
    }
    
}
