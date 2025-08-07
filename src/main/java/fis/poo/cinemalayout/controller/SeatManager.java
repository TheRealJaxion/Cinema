/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.controller;

import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Movie;
import fis.poo.cinemalayout.model.entities.Reservation;
import fis.poo.cinemalayout.view.SeatsSelection;
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
public class SeatManager {
    private SeatsSelection sts = new SeatsSelection();
    private Reservation rsrv;
    private Function fn;
    private boolean hasEnded = false;
    private Movie mv;
    private JFrame fr;
    private JFrame auxFr;
    private String smID;
    private String person;
    private SSController ssc;

    public void setFr(JFrame fr) {
        this.fr = fr;
    }
    
    public void setAuxFr(JFrame fr2){
        this.auxFr = fr2;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public void setFn(Function fn) {
        this.fn = fn;
    }

    public void setMv(Movie mv) {
        this.mv = mv;
    }

    public String getSmID() {
        return smID;
    }

    public SeatManager(Function fn, Movie mv, JFrame fr, JFrame auxFr, String person) {
        this.fn = fn;
        this.mv = mv;
        this.fr = fr;
        this.auxFr = auxFr;
        this.person = person;
        smID = mv.getNameM()+" "+fn.getFunctionId();
        this.ssc = new SSController(fr, auxFr, mv, fn, person, sts);
    }

    public SeatManager() {
    }
    
    
    public boolean isHasEnded() {
        return hasEnded;
    }

    public SSController getSsc() {
        return ssc;
    }
    
    public void clear(){
        this.ssc.clear();
    }

    public Reservation getRsrv() {
        return rsrv;
    }
    
    //This class will controll the seat-selection view and will update the reservation marked once the user finishes the selection.
    
    private class SSController implements ActionListener {
        private Movie mv; 
        private Function fn;
        private int counter = 0;
        private int c =0;
        private SeatsSelection sts;
        private JFrame fr1;
        private JFrame fr2;
        private boolean isClient = false;
        private boolean isCashier = false;
        private ArrayList<JToggleButton> locks = new ArrayList<>();

        public SSController(JFrame fr1, JFrame fr2 ,Movie mv, Function fn, String person, SeatsSelection sts) {
            this.sts = sts;
            this.fr1 = fr1;
            this.fr2 = fr2;
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
                JOptionPane.showMessageDialog(fr2,"There was a problem at SSController!", "Warning!", JOptionPane.ERROR_MESSAGE);
            }
        }


        @Override
        public void actionPerformed(ActionEvent ev) {
            Object sr = ev.getSource();
            if(sr == sts.aceptB){

                int op = JOptionPane.showConfirmDialog(sts, "Are you sure to reserve this seats?", "Policinema", JOptionPane.YES_NO_OPTION);
                if(op == 0 && counter!=0){

                    SeatManager.this.rsrv = new Reservation(fn, counter);
                    clean();
                    System.out.println(SeatManager.this.rsrv);
                    
                    sts.setVisible(false);
                    if(!locks.isEmpty()){
                        lockSeats();
                    }
                    SeatManager.this.hasEnded = true;
                    fr2.setLocationRelativeTo(null);
                }else{
                    JOptionPane.showMessageDialog(fr2, "There's no seats selected!", "Alert!", JOptionPane.ERROR_MESSAGE);
                }
            } else if(sr == sts.cancelB1){
                clear();
                sts.setVisible(false);
                fr1.setLocationRelativeTo(null);
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
    
}
