/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import fis.poo.cinemalayout.controller.SMainController;
import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Reservation;
import fis.poo.cinemalayout.view.SeatsSelection;

/**
 *
 * @author jordy
 */
public abstract class MarkReservation {
    protected Function fn;
    protected SMainController smc;
    protected SeatsSelection sl; 
    protected Reservation rs;

    public MarkReservation(Function fn, SMainController smc, SeatsSelection sl, Reservation rs) {
        this.fn = fn;
        this.smc = smc;
        this.sl = sl;
        this.rs = rs;
    }
    
    public abstract void markSeats(); 
    
}
