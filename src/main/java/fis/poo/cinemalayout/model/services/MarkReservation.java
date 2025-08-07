/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import fis.poo.cinemalayout.controller.SeatManager;
import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Movie;
import fis.poo.cinemalayout.model.entities.Reservation;
import java.awt.Component;
import javax.swing.JFrame;

/**
 *
 * @author jordy
 */
public abstract class MarkReservation {
    protected Reservation rsrv;
    protected Movie mv;
    protected Function fn;
    protected SeatManager smn;
    protected String person;

    public MarkReservation(Movie mv, Function fn, SeatManager smn, JFrame fr1, JFrame fr2, String person) {
        this.smn = smn;
        this.mv = mv;
        this.fn = fn;
        this.smn = smn;
    }
    
    public abstract Reservation markSeats(Component fr); 
}
