/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.controller;

import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Movie;
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
    private SeatsSelection sts = new SeatsSelection();
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

    public void setIsClient(boolean isClient) {
        this.isClient = isClient;
        this.isCashier = !isClient;
    }

    public void setIsCashier(boolean isCashier) {
        this.isCashier = isCashier;
        this.isClient = !isCashier;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    
    public int getCounter() {
        return counter;
    }
    
    public SSController(JFrame fr, Movie mv, Function fn) {
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
            System.out.println(hall);
            sts.displayH.setText(hall + fn.getNhall());
            sts.displayH1.setText(fn.getSchedule());
            for(JToggleButton btn : sts.seats()){
                btn.addActionListener(this);
            }
        
            sts.setVisible(true);
            sts.setLocationRelativeTo(null);
        } else{
            JOptionPane.showMessageDialog(fr,"There was a problem at SSController!", "Warning!", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    @Override
    public void actionPerformed(ActionEvent ev) {
        Object sr = ev.getSource();
        if(sts.isActive()){
            for(JToggleButton btn : sts.seats()){
                if(sr == btn){
                    System.out.println(btn.getName());
                    locks.add(btn);
                    counter++;
                    sts.displayS.setText(Integer.toString(counter));
                }
            }
            
            if(sr == sts.aceptB){
                int op = JOptionPane.showConfirmDialog(fr, "Are you sure to reserve this seats?", "Policinema", JOptionPane.YES_NO_OPTION);
                if(op == 0){
                    sts.setVisible(false);
                    fr.setVisible(true);
                    fr.setLocationRelativeTo(null);
                } 
            }
        }
    }
    
    public void lockSeats(){
        for(JToggleButton bnt : locks){
            bnt.disable();
        }
    }
    
    public void clear(){
        locks.clear();
        counter = 0;
        sts.displayS.setText("");
    }
    
}
