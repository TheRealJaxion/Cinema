/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.controller;

import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Movie;
import fis.poo.cinemalayout.model.entities.Reservation;
import fis.poo.cinemalayout.view.SeatsSelection;
import javax.swing.JFrame;


/**
 *
 * @author jordy
 */
public class SeatManager {
    private SeatsSelection sts = new SeatsSelection();
    private Function fn;
    private Movie mv;
    private JFrame fr;
    private String smID;
    private String person;
    private SSController ssc;

    public void setFr(JFrame fr) {
        this.fr = fr;
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
    

    public void init(){
        smID = fn.getFunctionId();
        ssc = new SSController(fr, mv, fn, person, sts);
    }
    
    public Function getFunction(){
        return ssc.getFunction();
    }
    
    public int getCount(){
        return ssc.getCounter();
    }
    public void clear(){
        ssc.clear();
    }
    
}
