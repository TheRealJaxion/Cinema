/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import fis.poo.cinemalayout.controller.SSController;
import fis.poo.cinemalayout.controller.SeatManager;
import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Reservation;

/**
 *
 * @author jordy
 */
public abstract class MarkReservation {
    protected Function fn;
    //protected SeatManager smn;
    protected SSController ssc;
    protected Reservation rs;

    public MarkReservation(Function fn, SSController ssc, Reservation rs) {
        this.fn = fn;
        this.ssc = ssc;
        this.rs = rs;
    }
    
    public abstract void markSeats(); 
    
}
