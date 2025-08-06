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
public class ClientReserv extends MarkReservation{
    
    public ClientReserv(Function fn, SSController ssc, Reservation rs) {
        super(fn, ssc, rs);
    }

    @Override
    public void markSeats() {
        rs.setSeats(ssc.getCounter());
        ssc.setCounter(0);
    }
    
    
    
}
